package negocio;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Collections;

import dao.MovimientoDao;
import datos.Boleto;
import datos.Tarjeta;

public class MovimientoAlta 
{
	MovimientoDao movdao = new MovimientoDao();
	public void agregarBoleto(Boleto boleto)
	{
		movdao.agregar(boleto);
	}
	
	public List<Boleto> traerBoletosRedSube(Tarjeta tarjeta, GregorianCalendar fechaActual)
	{
		List<Boleto> lstb = movdao.traerBoletosRedSubeColectivo(tarjeta.getIdTarjeta(), fechaActual);
		lstb.addAll(movdao.traerBoletosRedSubeTrenYSubte(tarjeta.getIdTarjeta(), fechaActual));
		Collections.sort(lstb);
		return lstb;
	}

	public Boleto traerUltimoBoleto(long idTarjeta) 
	{
		return movdao.traerUltimoBoleto(idTarjeta);
	}
}
