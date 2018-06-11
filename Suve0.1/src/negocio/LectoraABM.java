package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.LectoraDao;
import datos.Boleto;
import datos.Estacion;
import datos.Lectora;
import datos.LectoraColectivo;
import datos.LectoraEstacion;
import datos.Recarga;
import datos.TarifaSocial;
import datos.Tarjeta;
import datos.TipoTransporte;
import datos.TramoColectivo;
import datos.TramoTrenYSubte;
import datos.Transporte;

public class LectoraABM
{
	LectoraDao lectoraDao = new LectoraDao();
	TarjetaABM tarjetaAbm = new TarjetaABM();
	MovimientoABM movimientoAlta = new MovimientoABM();
	TramoABM tramosConsultas = new TramoABM();
	
	public Recarga agregarRecarga(Lectora lectora, Tarjeta tarjeta, GregorianCalendar fechaHora, float monto,boolean esRecargaEstudiantil) throws Exception{
		//Falta validar que no sean null y que la fecha no sea posterior al ultimo movimietno de la tarjeta
		
		if(!movimientoAlta.esFechaValida(fechaHora)) {
			throw new Exception("Fecha Invalida.");
		}
		
		Recarga recarga = new Recarga(fechaHora, lectora, monto, tarjeta, esRecargaEstudiantil);
		movimientoAlta.agregarRecarga(recarga);
		tarjeta.setMonto(tarjeta.getMonto() + monto);
		tarjetaAbm.modificarTarjeta(tarjeta);
		return recarga;
	}
	public Lectora traerLectora(int numeroSerieLectora) 
	{
		return lectoraDao.traerLectora(numeroSerieLectora);
	}
	public Recarga agregarRecarga(int numSerieLectora, int numSerieTarjeta, GregorianCalendar fechaHora, float monto,boolean esRecargaEstudiantil) throws Exception{
		Recarga r = null;
		Lectora l = this.traerLectora(numSerieLectora);
		Tarjeta t = tarjetaAbm.traerTarjeta(numSerieTarjeta);
		if(l!=null && t!=null)
			r = this.agregarRecarga(l, t, fechaHora, monto, esRecargaEstudiantil);
		return r;
	}
	
	//-------------AGREGA BOLETO DE COLECTIVO-------------\\
	public Boleto agregarBoleto(LectoraColectivo lectora, Tarjeta tarjeta, GregorianCalendar fechaHora, TramoColectivo tramo) throws Exception
	{
		if(tarjeta == null)
			throw new Exception("la tarjeta no existe.");
		if(!tarjeta.isActiva()) 
			throw new Exception("tarjeta inactiva.");
		if(!movimientoAlta.esFechaValida(fechaHora)) 
			throw new Exception("Fecha Invalida.");
		if(tramo==null)
			throw new Exception("Tramo invalido.");
		TarifaSocial tarifa = tarjetaAbm.traerTarifaSocial();
		List<Boleto> lstBoletosUltimas2horas = movimientoAlta.traerBoletosRedSube(tarjeta, fechaHora);
		Boleto boletoAnterior = movimientoAlta.traerUltimoBoleto(tarjeta.getIdTarjeta());
		Boleto nuevoBoleto = new Boleto(fechaHora,(Lectora)lectora,tramo.getSeccionViaje().getMonto(),tarjeta,tramo);
		
		if(redSubeEnCurso(lstBoletosUltimas2horas) && !esBoletoDeEntradaTren(boletoAnterior) && !lineaTransporteRepetidaEnRedSube(lstBoletosUltimas2horas, lectora.getTransporte()))
		{
			nuevoBoleto.setIntRedSube(lstBoletosUltimas2horas.get(lstBoletosUltimas2horas.size()-1).getIntRedSube()+1);
			nuevoBoleto.setMonto(nuevoBoleto.getMonto()-(nuevoBoleto.getMonto()*Funciones.calcularRedSube(nuevoBoleto.getIntRedSube())));
		}
		
		if(Funciones.tarjetaContieneTarifaSocial(tarjeta.getBeneficios(), tarifa))
			Funciones.calcularTarifaSocial(nuevoBoleto, tarifa);
		
		if(tarjeta.getMonto() - nuevoBoleto.getMonto() < -25) 
			throw new Exception("saldo insuficiente");
		
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
	public LectoraEstacion traerLectoraEstacion(int numeroSerieLectora) 
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
	public Boleto agregarBoleto(LectoraEstacion lectora, Tarjeta tarjeta, GregorianCalendar fechaHora)throws Exception
	{
		if(tarjeta == null) {
			throw new Exception("la tarjeta no existe.");
		}
		if(!tarjeta.isActiva()) 
			throw new Exception("tarjeta inactiva.");
		
		if(!movimientoAlta.esFechaValida(fechaHora)) {
			throw new Exception("Fecha Invalida.");
		}
		
		Boleto nuevoBoleto = null;
		List<Boleto> lstBoletosUltimas2horas = movimientoAlta.traerBoletosRedSube(tarjeta, fechaHora);
		Boleto boletoAnterior = movimientoAlta.traerUltimoBoleto(tarjeta.getIdTarjeta());
		TramoTrenYSubte tramo = tramosConsultas.traerTramoTrenYSubte(lectora.getEstacion().getIdEstacion());//Tramo Estacion - Null
		if(lectora.getEstacion().getTransporte().getTipoTransporte() == TipoTransporte.Tren)
			nuevoBoleto = crearBoletoTren(lectora, tarjeta, fechaHora, tramo, lstBoletosUltimas2horas, boletoAnterior);
		else//boleto de subte
			nuevoBoleto = crearBoletoSubte(lectora, tarjeta, fechaHora, tramo, lstBoletosUltimas2horas, boletoAnterior);
			
		if(tarjeta.getMonto() - nuevoBoleto.getMonto() < -25) 
			throw new Exception("saldo insuficiente");
		movimientoAlta.agregarBoleto(nuevoBoleto);
		tarjeta.setMonto(tarjeta.getMonto()-nuevoBoleto.getMonto());
		tarjetaAbm.modificarTarjeta(tarjeta);
		System.out.println("\n\nMonto Final = "+nuevoBoleto.getMonto()+"   Red Sube = "+nuevoBoleto.getIntRedSube()+"\n");
		return nuevoBoleto;
	}
	
	public Boleto traerBoletoAnterio(Tarjeta tarjeta){
		return movimientoAlta.traerUltimoBoleto(tarjeta.getIdTarjeta());
	}
	
	
	public Boleto previsualizarBoleto(LectoraColectivo lectora, Tarjeta tarjeta, GregorianCalendar fechaHora, TramoColectivo tramo){
		TarifaSocial tarifa = tarjetaAbm.traerTarifaSocial();
		List<Boleto> lstBoletosUltimas2horas = movimientoAlta.traerBoletosRedSube(tarjeta, fechaHora);
		Boleto boletoAnterior = movimientoAlta.traerUltimoBoleto(tarjeta.getIdTarjeta());
		Boleto nuevoBoleto = new Boleto(fechaHora,(Lectora)lectora,tramo.getSeccionViaje().getMonto(),tarjeta,tramo);
		
		if(redSubeEnCurso(lstBoletosUltimas2horas) && !esBoletoDeEntradaTren(boletoAnterior) && !lineaTransporteRepetidaEnRedSube(lstBoletosUltimas2horas, lectora.getTransporte()))
		{
			nuevoBoleto.setIntRedSube(lstBoletosUltimas2horas.get(lstBoletosUltimas2horas.size()-1).getIntRedSube()+1);
			nuevoBoleto.setMonto(nuevoBoleto.getMonto()-(nuevoBoleto.getMonto()*Funciones.calcularRedSube(nuevoBoleto.getIntRedSube())));
		}
		
		if(Funciones.tarjetaContieneTarifaSocial(tarjeta.getBeneficios(), tarifa))
			Funciones.calcularTarifaSocial(nuevoBoleto, tarifa);
		
		return nuevoBoleto;
	}
	
	public Boleto previsualizarBoleto(LectoraEstacion lectora, Tarjeta tarjeta, GregorianCalendar fechaHora)throws Exception
	{
		Boleto nuevoBoleto = null;
		List<Boleto> lstBoletosUltimas2horas = movimientoAlta.traerBoletosRedSube(tarjeta, fechaHora);
		Boleto boletoAnterior = movimientoAlta.traerUltimoBoleto(tarjeta.getIdTarjeta());
		TramoTrenYSubte tramo = tramosConsultas.traerTramoTrenYSubte(lectora.getEstacion().getIdEstacion());//Tramo Estacion - Null
		if(lectora.getEstacion().getTransporte().getTipoTransporte() == TipoTransporte.Tren)
			nuevoBoleto = crearBoletoTren(lectora, tarjeta, fechaHora, tramo, lstBoletosUltimas2horas, boletoAnterior);
		else//boleto de subte
			nuevoBoleto = crearBoletoSubte(lectora, tarjeta, fechaHora, tramo, lstBoletosUltimas2horas, boletoAnterior);
			
		//movimientoAlta.agregarBoleto(nuevoBoleto);
		//tarjeta.setMonto(tarjeta.getMonto()-nuevoBoleto.getMonto());
		//tarjetaAbm.modificarTarjeta(tarjeta);
		return nuevoBoleto;
	}
	
	public Boleto crearBoletoTren(LectoraEstacion lectora, Tarjeta tarjeta, GregorianCalendar fechaHora,TramoTrenYSubte tramo,List<Boleto> lstBoletosUltimas2horas,Boleto boletoAnterior)
	{
		
		TarifaSocial tarifa = tarjetaAbm.traerTarifaSocial();
		float montoDeEntrada = tramo.getSeccionViaje().getMonto();
		
		if(Funciones.tarjetaContieneTarifaSocial(tarjeta.getBeneficios(), tarifa)) {
			montoDeEntrada = montoDeEntrada * (100-tarifa.getPorcentajeDescuento()) / 100;
		}
		
		Boleto nuevoBoleto = new Boleto(fechaHora,(Lectora)lectora,montoDeEntrada,tarjeta,tramo);
		
		boolean esBoletoDeSalida = boletoAnterior!=null &&  Funciones.tiempoDeViajeValido(boletoAnterior.getFecha(), fechaHora) &&
				esMismoTransporteYDiferenteEstacion(boletoAnterior.getTramoTrenYSubte().getEstacionA(), lectora.getEstacion());
		
		if(esBoletoDeSalida)
		{			
			tramo = tramosConsultas.traerTramoTrenYSubte(boletoAnterior.getTramoTrenYSubte().getEstacionA().getIdEstacion(),lectora.getEstacion().getIdEstacion());
			nuevoBoleto.setTramoTrenYSubte(tramo);
			nuevoBoleto.setIntRedSube(boletoAnterior.getIntRedSube());
			if(Funciones.tarjetaContieneTarifaSocial(tarjeta.getBeneficios(), tarifa))
				Funciones.calcularTarifaSocialTren(nuevoBoleto,boletoAnterior.getMonto(), tarifa);
			else
				nuevoBoleto.setMonto(-(boletoAnterior.getMonto()-(tramo.getSeccionViaje().getMonto()-(tramo.getSeccionViaje().getMonto()*Funciones.calcularRedSube(nuevoBoleto.getIntRedSube())))));
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
		
		if(Funciones.tarjetaContieneTarifaSocial(tarjeta.getBeneficios(), tarifa))
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

	public List<Lectora> traerLectorasPorLinea(long idTransporte) 
	{
		return lectoraDao.traerLectorasPorLinea(idTransporte);
	}

	public List<Lectora> traerLectorasPorEstacion(Estacion estacion) 
	{
		return lectoraDao.traerLectorasPorEstacion(estacion.getIdEstacion());
	}

	public String stringDeListaLectoras(List<Lectora> lstLectora) 
	{
		String listaLectoras = "[";
		for (Lectora l:lstLectora) {
			listaLectoras += "\""+l.getNumeroSerieLectora()+"\",";
		}
		
		listaLectoras =listaLectoras.substring(0, listaLectoras.length()-1);
		return listaLectoras +="]";
	}


}
