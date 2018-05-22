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
		TarifaSocial tarifa = tarjetaAbm.traerTarifaSocial();
		List<Boleto> lstBoletosUltimas2horas = movimientoAlta.traerBoletosRedSube(tarjeta, fechaHora);
		Boleto boletoAnterior = movimientoAlta.traerUltimoBoleto(tarjeta.getIdTarjeta());
		LectoraColectivo lectora = traerLectoraColectivo(numeroSerieLectora);
		Boleto nuevoBoleto = new Boleto(fechaHora,(Lectora)lectora,tramo.getSeccionViaje().getMonto(),tarjeta,tramo);
		
		if(lstBoletosUltimas2horas.size()>0 && lstBoletosUltimas2horas.get(lstBoletosUltimas2horas.size()-1).getIntRedSube() < 6 &&
			!(boletoAnterior != null && boletoAnterior.getTramoTrenYSubte().getEstacionA().getTransporte().getTipoTransporte()==TipoTransporte.Tren && boletoAnterior.getMonto()>0))
				nuevoBoleto.setIntRedSube(lstBoletosUltimas2horas.get(lstBoletosUltimas2horas.size()-1).getIntRedSube()+1);
		
		nuevoBoleto.setMonto(nuevoBoleto.getMonto()-(nuevoBoleto.getMonto()*Funciones.calcularRedSube(lstBoletosUltimas2horas, nuevoBoleto.getIntRedSube())));
		System.out.println("\n---"+tarjeta+"---\n");
		if(Funciones.tarjetaContieneTarifaSocial(tarjeta.getBeneficios().toArray(), tarifa))
			Funciones.calcularTarifaSocial(nuevoBoleto, tarifa);
		if(tarjeta.getMonto() - nuevoBoleto.getMonto() < -25) 
			throw new Exception("ERROR: saldo insuficiente");
		movimientoAlta.agregarBoleto(nuevoBoleto);
		tarjeta.setMonto(tarjeta.getMonto()-nuevoBoleto.getMonto());
		tarjetaAbm.modificarTarjeta(tarjeta);
		System.out.println("\n\nMonto Final = "+nuevoBoleto.getMonto()+"   Red Sube = "+nuevoBoleto.getIntRedSube()+"\n");
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
		List<Boleto> lstBoletosUltimas2horas = movimientoAlta.traerBoletosRedSube(tarjeta, fechaHora);
		Boleto boletoAnterior = movimientoAlta.traerUltimoBoleto(tarjeta.getIdTarjeta());
		LectoraTrenYSubte lectora = traerLectoraTrenYSubte(numeroSerieLectora);
		//Tramo Estacion - Null
		TramoTrenYSubte tramo = tramosConsultas.traerTramoUnaEstacion(lectora.getEstacion().getIdEstacion());
		Boleto nuevoBoleto = new Boleto(fechaHora,(Lectora)lectora,tramo.getSeccionViaje().getMonto(),tarjeta,tramo);
		if(lectora.getEstacion().getTransporte().getTipoTransporte() == TipoTransporte.Tren)
		{
			calcularDescuentos = boletoAnterior!=null &&  
					boletoAnterior.getTramoTrenYSubte().getEstacionA().getTransporte().equals(lectora.getEstacion().getTransporte()) &&
					Funciones.tiempoDeViajeValido(boletoAnterior.getFecha(), fechaHora) && 
					!(lectora.getEstacion().equals(boletoAnterior.getTramoTrenYSubte().getEstacionA()));
			if(calcularDescuentos)
			{	//Aca entra cuando es un boleto de BAJADA (Cierre o como lo llames)			
				tramo = tramosConsultas.traerTramoTrenYSubte(boletoAnterior.getTramoTrenYSubte().getEstacionA(),lectora.getEstacion());
				nuevoBoleto.setTramoTrenYSubte(tramo);
				nuevoBoleto.setMonto(-(boletoAnterior.getMonto()-tramo.getSeccionViaje().getMonto()));
				System.out.println("El boleto con devolucion sin descuento: " + nuevoBoleto.getMonto());
				nuevoBoleto.setIntRedSube(boletoAnterior.getIntRedSube());
			} else {
				if(lstBoletosUltimas2horas.size()>0 && 
					lstBoletosUltimas2horas.get(lstBoletosUltimas2horas.size()-1).getIntRedSube() < 6 &&
					!(boletoAnterior != null && boletoAnterior.getTramoTrenYSubte().getEstacionA().getTransporte().getTipoTransporte()==TipoTransporte.Tren && boletoAnterior.getMonto()>0)
					)
					nuevoBoleto.setIntRedSube(lstBoletosUltimas2horas.get(lstBoletosUltimas2horas.size()-1).getIntRedSube()+1);
			}
		}
		else 
			if(lstBoletosUltimas2horas.size()>0 && lstBoletosUltimas2horas.get(lstBoletosUltimas2horas.size()-1).getIntRedSube() < 6 && (boletoAnterior == null || !(boletoAnterior.getTramoTrenYSubte().getEstacionA().getTransporte().getTipoTransporte()==TipoTransporte.Tren && boletoAnterior.getMonto()>0)))
				nuevoBoleto.setIntRedSube(lstBoletosUltimas2horas.get(lstBoletosUltimas2horas.size()-1).getIntRedSube()+1);
		if(calcularDescuentos)
		{
			if(nuevoBoleto.getMonto()>0) {
				nuevoBoleto.setMonto(nuevoBoleto.getMonto()-(nuevoBoleto.getMonto()*Funciones.calcularRedSube(lstBoletosUltimas2horas, nuevoBoleto.getIntRedSube())));
			}
			else {
				nuevoBoleto.setMonto(nuevoBoleto.getMonto()+(nuevoBoleto.getMonto()*Funciones.calcularRedSube(lstBoletosUltimas2horas, nuevoBoleto.getIntRedSube())));
			}
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
