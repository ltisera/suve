package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.LectoraDao;
import datos.Boleto;
import datos.Estacion;
import datos.Lectora;
import datos.LectoraColectivo;
import datos.LectoraEstacion;
import datos.TarifaSocial;
import datos.Tarjeta;
import datos.TipoTransporte;
import datos.TramoColectivo;
import datos.TramoTrenYSubte;
import datos.Transporte;

public class AdminDeLectoras
{
	LectoraDao lectoraDao = new LectoraDao();
	TarjetaABM tarjetaAbm = new TarjetaABM();
	MovimientoAlta movimientoAlta = new MovimientoAlta();
	TramosConsultas tramosConsultas = new TramosConsultas();
	
	//-------------AGREGA BOLETO DE COLECTIVO-------------\\
	public Boleto agregarBoleto(int numeroSerieLectora, Tarjeta tarjeta, GregorianCalendar fechaHora, TramoColectivo tramo) throws Exception
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
		
		if(redSubeEnCurso(lstBoletosUltimas2horas) && !esBoletoDeEntradaTren(boletoAnterior) && !lineaTransporteRepetidaEnRedSube(lstBoletosUltimas2horas, lectora.getTransporte()))
		{
			nuevoBoleto.setIntRedSube(lstBoletosUltimas2horas.get(lstBoletosUltimas2horas.size()-1).getIntRedSube()+1);
			nuevoBoleto.setMonto(nuevoBoleto.getMonto()-(nuevoBoleto.getMonto()*Funciones.calcularRedSube(nuevoBoleto.getIntRedSube())));
		}
		
		if(Funciones.tarjetaContieneTarifaSocial(tarjeta.getBeneficios().toArray(), tarifa))
			Funciones.calcularTarifaSocial(nuevoBoleto, tarifa);
		
		if(tarjeta.getMonto() - nuevoBoleto.getMonto() < -25) 
			throw new Exception("ERROR: saldo insuficiente");
		
		movimientoAlta.agregarBoleto(nuevoBoleto);
		tarjeta.setMonto(tarjeta.getMonto()-nuevoBoleto.getMonto());
		tarjetaAbm.modificarTarjeta(tarjeta);
		System.out.println("\n\nMonto Final = "+nuevoBoleto.getMonto()+"   Red Sube = "+nuevoBoleto.getIntRedSube()+"\n");
		return nuevoBoleto;
	}
	
	public LectoraColectivo traerLectoraColectivo(int numeroSerieLectora)
	{
		return lectoraDao.traerLectoraColectivo(numeroSerieLectora);
	}
	
	private LectoraEstacion traerLectoraEstacion(int numeroSerieLectora) 
	{
		return lectoraDao.traerLectoraEstacion(numeroSerieLectora);
	}
	
	public boolean esBoletoDeEntradaTren(Boleto boletoAnterior)
	{
		return boletoAnterior != null && boletoAnterior.getTramoTrenYSubte().getEstacionA().getTransporte().getTipoTransporte()==TipoTransporte.Tren && boletoAnterior.getMonto()>0;
	}
	
	public boolean esMismoTransporteYDiferenteEstacion(Estacion estacion1, Estacion estacion2)
	{
		return estacion1.getTransporte().equals(estacion2.getTransporte()) &&
				!(estacion1.equals(estacion2));
	}
	
	public boolean redSubeEnCurso(List<Boleto> lstBoletosUltimas2horas)
	{
		return lstBoletosUltimas2horas.size()>0 && 
				lstBoletosUltimas2horas.get(lstBoletosUltimas2horas.size()-1).getIntRedSube()<=lstBoletosUltimas2horas.size() &&
				lstBoletosUltimas2horas.get(lstBoletosUltimas2horas.size()-1).getIntRedSube() < 6;
	}	
	
	//-------------AGREGA BOLETO DE TREN O SUBTE-------------\\
	public Boleto agregarBoleto(int numeroSerieLectora, Tarjeta tarjeta, GregorianCalendar fechaHora)throws Exception
	{
		if(tarjeta == null)
			throw new Exception("ERROR: La tarjeta no existe.");
		if(!tarjeta.isActiva()) 
			throw new Exception("ERROR: tarjeta inactiva.");
		Boleto nuevoBoleto = null;
		List<Boleto> lstBoletosUltimas2horas = movimientoAlta.traerBoletosRedSube(tarjeta, fechaHora);
		Boleto boletoAnterior = movimientoAlta.traerUltimoBoleto(tarjeta.getIdTarjeta());
		LectoraEstacion lectora = traerLectoraEstacion(numeroSerieLectora);
		TramoTrenYSubte tramo = tramosConsultas.traerTramoUnaEstacion(lectora.getEstacion().getIdEstacion());//Tramo Estacion - Null
		if(lectora.getEstacion().getTransporte().getTipoTransporte() == TipoTransporte.Tren)
			nuevoBoleto = crearBoletoTren(lectora, tarjeta, fechaHora, tramo, lstBoletosUltimas2horas, boletoAnterior);
		else//boleto de subte
			nuevoBoleto = crearBoletoSubte(lectora, tarjeta, fechaHora, tramo, lstBoletosUltimas2horas, boletoAnterior);
			
		if(tarjeta.getMonto() - nuevoBoleto.getMonto() < -25) 
			throw new Exception("ERROR: saldo insuficiente");
		movimientoAlta.agregarBoleto(nuevoBoleto);
		tarjeta.setMonto(tarjeta.getMonto()-nuevoBoleto.getMonto());
		tarjetaAbm.modificarTarjeta(tarjeta);
		System.out.println("\n\nMonto Final = "+nuevoBoleto.getMonto()+"   Red Sube = "+nuevoBoleto.getIntRedSube()+"\n");
		return nuevoBoleto;
	}
	
	
	public Boleto crearBoletoTren(LectoraEstacion lectora, Tarjeta tarjeta, GregorianCalendar fechaHora,TramoTrenYSubte tramo,List<Boleto> lstBoletosUltimas2horas,Boleto boletoAnterior)
	{
		Boleto nuevoBoleto = new Boleto(fechaHora,(Lectora)lectora,tramo.getSeccionViaje().getMonto(),tarjeta,tramo);
		TarifaSocial tarifa = tarjetaAbm.traerTarifaSocial();
		boolean esBoletoDeSalida = boletoAnterior!=null &&  Funciones.tiempoDeViajeValido(boletoAnterior.getFecha(), fechaHora) &&
				esMismoTransporteYDiferenteEstacion(boletoAnterior.getTramoTrenYSubte().getEstacionA(), lectora.getEstacion());
		
		if(esBoletoDeSalida)
		{			
			tramo = tramosConsultas.traerTramoTrenYSubte(boletoAnterior.getTramoTrenYSubte().getEstacionA(),lectora.getEstacion());
			nuevoBoleto.setTramoTrenYSubte(tramo);
			nuevoBoleto.setIntRedSube(boletoAnterior.getIntRedSube());
			nuevoBoleto.setMonto(-(boletoAnterior.getMonto()-(tramo.getSeccionViaje().getMonto()-(tramo.getSeccionViaje().getMonto()*Funciones.calcularRedSube(nuevoBoleto.getIntRedSube())))));
			if(Funciones.tarjetaContieneTarifaSocial(tarjeta.getBeneficios().toArray(), tarifa))
				Funciones.calcularTarifaSocial(nuevoBoleto, tarifa);
		} 
		else 
		{
			if(redSubeEnCurso(lstBoletosUltimas2horas) && !esBoletoDeEntradaTren(boletoAnterior) &&
					!lineaTransporteRepetidaEnRedSube(lstBoletosUltimas2horas, lectora.getEstacion().getTransporte()))
					nuevoBoleto.setIntRedSube(lstBoletosUltimas2horas.get(lstBoletosUltimas2horas.size()-1).getIntRedSube()+1);
		}
		
		return nuevoBoleto;
	}
	
	
	public Boleto crearBoletoSubte(LectoraEstacion lectora, Tarjeta tarjeta, GregorianCalendar fechaHora,TramoTrenYSubte tramo,List<Boleto> lstBoletosUltimas2horas,Boleto boletoAnterior)
	{
		Boleto nuevoBoleto = new Boleto(fechaHora,(Lectora)lectora,tramo.getSeccionViaje().getMonto(),tarjeta,tramo); 
		TarifaSocial tarifa = tarjetaAbm.traerTarifaSocial();
		
		if(redSubeEnCurso(lstBoletosUltimas2horas) && !esBoletoDeEntradaTren(boletoAnterior) && !subteRepetidoEnRedSube(lstBoletosUltimas2horas))
		{
				nuevoBoleto.setIntRedSube(lstBoletosUltimas2horas.get(lstBoletosUltimas2horas.size()-1).getIntRedSube()+1);
				nuevoBoleto.setMonto(nuevoBoleto.getMonto()-(nuevoBoleto.getMonto()*Funciones.calcularRedSube(nuevoBoleto.getIntRedSube())));
		}
		
		if(Funciones.tarjetaContieneTarifaSocial(tarjeta.getBeneficios().toArray(), tarifa))
			Funciones.calcularTarifaSocial(nuevoBoleto, tarifa);

		return nuevoBoleto;
		
	}



	public boolean lineaTransporteRepetidaEnRedSube(List<Boleto> lstBoletosUltimas2horas, Transporte transporte) 
	{
		boolean lineaTransporteRepetida = false;
		boolean finRedSube = false;
		Lectora lectora = null;
		int posicion = lstBoletosUltimas2horas.size()-1;
		
		while(!lineaTransporteRepetida && !finRedSube && posicion >= 0)
		{
			lectora = lstBoletosUltimas2horas.get(posicion).getLectora();
			
			if(lectora instanceof LectoraColectivo)
				lineaTransporteRepetida = ((LectoraColectivo) lectora).getTransporte().equals(transporte);
			
			if(lectora instanceof LectoraEstacion)
				lineaTransporteRepetida = ((LectoraEstacion) lectora).getEstacion().getTransporte().equals(transporte);
			
			finRedSube = lstBoletosUltimas2horas.get(posicion).getIntRedSube() == 1;
			posicion--;
		}
		
		return lineaTransporteRepetida;
	}
	

	public boolean subteRepetidoEnRedSube(List<Boleto> lstBoletosUltimas2horas) 
	{
		boolean subteRepetido = false;
		boolean finRedSube = false;
		Lectora lectora = null;
		int posicion = lstBoletosUltimas2horas.size()-1;
		
		while(!subteRepetido && !finRedSube && posicion >= 0)
		{
			lectora = lstBoletosUltimas2horas.get(posicion).getLectora();
			
			if(lectora instanceof LectoraEstacion)
				subteRepetido = ((LectoraEstacion) lectora).getEstacion().getTransporte().getTipoTransporte() == TipoTransporte.Subte;
			
			finRedSube = lstBoletosUltimas2horas.get(posicion).getIntRedSube() == 1;
			posicion--;
		}
		
		return subteRepetido;
	}


}
