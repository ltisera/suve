package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.LectoraDao;
import datos.Boleto;
import datos.Lectora;
import datos.LectoraColectivo;
import datos.LectoraTrenYSubte;
import datos.TarifaSocial;
import datos.Tarjeta;
import datos.TipoTransporte;
import datos.TramoColectivo;
import datos.TramoTrenYSubte;

public class AdminDeLectoras 
{
	LectoraDao lectoraDao = new LectoraDao();
	TarjetaABM tarjetaAbm = new TarjetaABM();
	MovimientoAlta movimientoAlta = new MovimientoAlta();
	TramosConsultas tramosConsultas = new TramosConsultas();
	
	//agrega un boleto de colectivo
	public void agregarBoleto(int numeroSerieLectora, Tarjeta tarjeta, GregorianCalendar fechaHora, TramoColectivo tramo) throws Exception
	{
		if(tarjeta == null)
			throw new Exception("ERROR: La tarjeta no existe.");
		if(!tarjeta.isActiva()) 
			throw new Exception("ERROR: tarjeta inactiva.");
		LectoraColectivo lectora = traerLectoraColectivo(numeroSerieLectora);
		Boleto nuevoBoleto = new Boleto(fechaHora,(Lectora)lectora,tramo.getSeccionViaje().getMonto(),tarjeta,tramo);
		
		List<Boleto> lbu2h = movimientoAlta.traerBoletosRedSube(tarjeta, fechaHora);
		System.out.println(lbu2h);
		
		Funciones.calcularRedSube(lbu2h, nuevoBoleto);
		if(tarjeta.getBeneficios().contains(tarjetaAbm.traerTarifaSocial()))
			Funciones.calcularTarifaSocial(nuevoBoleto, tarjetaAbm.traerTarifaSocial());
		if(tarjeta.getMonto() - nuevoBoleto.getMonto() < -25) 
			throw new Exception("ERROR: saldo insuficiente");
		movimientoAlta.agregarBoleto(nuevoBoleto);
		tarjeta.setMonto(tarjeta.getMonto()-nuevoBoleto.getMonto());
		tarjetaAbm.modificarTarjeta(tarjeta);
		System.out.println("NICO MIRA LA RED: " + nuevoBoleto.getIntRedSube() + "TOMA EL MONTO: " + nuevoBoleto.getMonto());
	}
	
	public LectoraColectivo traerLectoraColectivo(int numeroSerieLectora)
	{
		return lectoraDao.traerLectoraColectivo(numeroSerieLectora);
	}
	
	public void agregarBoleto(int numeroSerieLectora, Tarjeta tarjeta, GregorianCalendar fechaHora)throws Exception
	{
		boolean calcularDescuentos = true;
		if(tarjeta == null)
			throw new Exception("ERROR: La tarjeta no existe.");
		if(!tarjeta.isActiva()) 
			throw new Exception("ERROR: tarjeta inactiva.");
		LectoraTrenYSubte lectora = traerLectoraTrenYSubte(numeroSerieLectora);
		TramoTrenYSubte tramo = tramosConsultas.traerTramoUnaEstacion(lectora.getEstacion().getIdEstacion());
		System.out.println("\n---tramo---"+tramo+"-----\n");
		Boleto nuevoBoleto = new Boleto(fechaHora,(Lectora)lectora,tramo.getSeccionViaje().getMonto(),tarjeta,tramo);
		if(lectora.getEstacion().getTransporte().getTipoTransporte() == TipoTransporte.Tren)
		{
			Boleto boletoAnterior = movimientoAlta.traerUltimoBoleto(tarjeta.getIdTarjeta());
			calcularDescuentos = boletoAnterior!=null && // 
					boletoAnterior.getTramoTrenYSubte().getEstacionA().getTransporte().equals(lectora.getEstacion().getTransporte()) &&
					Funciones.tiempoDeViajeValido(boletoAnterior.getFecha(), fechaHora) && 
					!(lectora.getEstacion().equals(boletoAnterior.getTramoTrenYSubte().getEstacionA()));
			if(calcularDescuentos)
			{	//Aca entra cuando es un boleto de BAJADA (Cierre o como lo llames)			
				System.out.println("\n-------calculo descuentos\n");
				tramo = tramosConsultas.traerTramoTrenYSubte(boletoAnterior.getTramoTrenYSubte().getEstacionA(),lectora.getEstacion());
				nuevoBoleto.setMonto(-(boletoAnterior.getMonto()-tramo.getSeccionViaje().getMonto()));
			}
		}
		if(calcularDescuentos)
		{
			System.out.println("\n\nMonto sin descuentos = "+nuevoBoleto.getMonto()+"\n");
			Funciones.calcularRedSube(movimientoAlta.traerBoletosRedSube(tarjeta, fechaHora), nuevoBoleto);
			System.out.println("\n\nMonto red sube = "+nuevoBoleto.getMonto()+"   Red Sube = "+nuevoBoleto.getIntRedSube()+"\n");
			TarifaSocial tarifa = tarjetaAbm.traerTarifaSocial();
			if(Funciones.tarjetaContieneTarifaSocial(tarjeta.getBeneficios().toArray(), tarifa))
				Funciones.calcularTarifaSocial(nuevoBoleto, tarifa);
		}		
		if(tarjeta.getMonto() - nuevoBoleto.getMonto() < -25) 
			throw new Exception("ERROR: saldo insuficiente");
		movimientoAlta.agregarBoleto(nuevoBoleto);
		tarjeta.setMonto(tarjeta.getMonto()-nuevoBoleto.getMonto());
		tarjetaAbm.modificarTarjeta(tarjeta);
		System.out.println("\n\nMonto Final = "+nuevoBoleto.getMonto()+"   Red Sube = "+nuevoBoleto.getIntRedSube()+"\n");
		
	}

	private LectoraTrenYSubte traerLectoraTrenYSubte(int numeroSerieLectora) 
	{
		return lectoraDao.traerLectoraTrenYSubte(numeroSerieLectora);
	}
}
