package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.MovimientoDao;
import datos.Boleto;
import datos.Tarjeta;

public class MovimientoAlta 
{
	MovimientoDao dao = new MovimientoDao();
	public void agregarBoleto(Boleto boleto)
	{
		dao.agregar(boleto);
	}
	
	public List<Boleto> traerBoletosRedSube(Tarjeta tarjeta, GregorianCalendar fecha2)
	{
		return dao.trerBoletosRedSube(tarjeta.getIdTarjeta(), fecha2);
	}
}
