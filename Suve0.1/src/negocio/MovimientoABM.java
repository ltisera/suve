package negocio;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import dao.MovimientoDao;
import datos.Beneficio;
import datos.Boleto;
import datos.Movimiento;
import datos.Recarga;
import datos.Tarjeta;
import datos.TipoTransporte;
import datos.Transporte;

public class MovimientoABM 
{
	MovimientoDao movdao = new MovimientoDao();
	public void agregarBoleto(Boleto boleto)
	{
		movdao.agregar(boleto);
	}
	
	public void agregarRecarga(Recarga recarga)
	{
		movdao.agregar(recarga);
	}
	
	
	public List<Boleto> traerBoletosRedSube(Tarjeta tarjeta, GregorianCalendar fechaActual)
	{
		List<Boleto> lstb = movdao.traerBoletosRedSubeColectivo(tarjeta.getIdTarjeta(), fechaActual);
		lstb.addAll(movdao.traerBoletosRedSubeTrenYSubte(tarjeta.getIdTarjeta(), fechaActual));
		Collections.sort(lstb);
		return lstb;
	}

	//No trae solo ultimo boleto de tren(?
	public Boleto traerUltimoBoleto(long idTarjeta) 
	{
		return movdao.traerUltimoBoleto(idTarjeta);
	}
	
	public Movimiento traerUltimoMovimiento() 
	{
		return movdao.traerUltimoMovimiento();
	}
	
	public Recarga traerRecargaEstudiantil() {
		return movdao.traerRecargaEstudiantil();
	}
	
	public boolean esFechaValida(GregorianCalendar fechaNuevoBoleto) {
		boolean valido = false;
		Movimiento m = this.traerUltimoMovimiento();
		
		if( m == null) {
			valido = true;
		}
		else {
			
			if(fechaNuevoBoleto.compareTo(m.getFecha())>=0) {
				valido = true;
			}
		}
		return valido;
	}
	
	public Movimiento traerMovimiento(long idMovimiento)
	{
		return movdao.traerMovimiento(idMovimiento);
	}

	public List<Movimiento> traerMovimientoCompleto() 
	{
		return movdao.traerMovimientoCompleto();
	}

	public List<Movimiento> traerMovimientoCompletoPorTarjeta(long idTarjeta) {
		return movdao.traerMovimientoCompletoPorTarjeta(idTarjeta);
	}
	
	public List<Boleto> viajesRealizados(GregorianCalendar fechaDesde, GregorianCalendar fechaHasta, TipoTransporte tipoTransporte)
	{
		List<Boleto> lstViajesRealizados = new ArrayList<Boleto>();
		if(tipoTransporte == TipoTransporte.Colectivo)
			lstViajesRealizados = movdao.viajesRealizadosEnColectivo(fechaDesde, fechaHasta);
		else
			lstViajesRealizados = movdao.viajesRealizadosEnTrenOSubte(fechaDesde, fechaHasta, tipoTransporte);
		return lstViajesRealizados;
	}
	
	public List<Boleto> viajesRealizados(GregorianCalendar fechaDesde, GregorianCalendar fechaHasta, Transporte transporte)
	{
		List<Boleto> lstViajesRealizados = new ArrayList<Boleto>();
		if(transporte.getTipoTransporte() == TipoTransporte.Colectivo)
			lstViajesRealizados = movdao.viajesRealizadosEnLineaColectivo(fechaDesde, fechaHasta, transporte.getIdTransporte());
		if(transporte.getTipoTransporte() == TipoTransporte.Subte)
			lstViajesRealizados = movdao.viajesRealizadosEnLineaTrenOSubteEntrada(fechaDesde, fechaHasta, transporte.getIdTransporte());
		if(transporte.getTipoTransporte() == TipoTransporte.Tren)
		{
			lstViajesRealizados = movdao.viajesRealizadosEnLineaTrenOSubteEntrada(fechaDesde, fechaHasta, transporte.getIdTransporte());
			lstViajesRealizados.addAll(movdao.viajesRealizadosEnLineaTrenSalida(fechaDesde, fechaHasta, transporte.getIdTransporte()));
			Collections.sort(lstViajesRealizados);
		}
		return lstViajesRealizados;
	}
	
	public List<Boleto> viajesRealizados(GregorianCalendar fechaDesde, GregorianCalendar fechaHasta, Beneficio beneficio)
	{
		return movdao.viajesRealizados(fechaDesde, fechaHasta, beneficio.getIdBeneficio());
	}
	
	public List<Boleto> viajesRealizadosConRedSube(GregorianCalendar fechaDesde, GregorianCalendar fechaHasta)
	{
		return movdao.viajesRealizadosConRedSube(fechaDesde, fechaHasta);
	}
}
