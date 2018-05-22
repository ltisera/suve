package negocio;

import java.util.GregorianCalendar;
import java.util.List;

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
	
	public List<Boleto> traerBoletosRedSube(Tarjeta tarjeta, GregorianCalendar fecha2)
	{
		return movdao.trerBoletosRedSube(tarjeta.getIdTarjeta(), fecha2);
	}

	public Boleto traerUltimoBoleto(long idTarjeta) 
	{
		return movdao.traerUltimoBoleto(idTarjeta);
	}
}
