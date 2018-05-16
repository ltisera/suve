package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.LectoraDao;
import datos.Boleto;
import datos.LectoraColectivo;
import datos.Tarjeta;
import datos.TramoColectivo;

public class AdminDeLectoras 
{
	LectoraDao lectoraDao = new LectoraDao();
	TarjetaABM tarjetaAbm = new TarjetaABM();
	MovimientoAlta movimientoAlta = new MovimientoAlta();
	
	//agrega un boleto de colectivo
	public void agregarBoleto(int numeroSerieLectora, Tarjeta tarjeta, GregorianCalendar fechaHora, TramoColectivo tramo) throws Exception
	{
		if(!tarjeta.isActiva()) throw new Exception("ERROR: tarjeta inactiva.");
		LectoraColectivo lectora = traerLectoraColectivo(numeroSerieLectora);
		Boleto nuevoBoleto = new Boleto(fechaHora,lectora,tramo.getSeccionViaje().getMonto(),tarjeta,tramo);
		
		Funciones.calcularRedSube(movimientoAlta.traerBoletosRedSube(tarjeta), nuevoBoleto);
		if(tarjeta.getBeneficios().contains(tarjetaAbm.traerTarifaSocial()))
			Funciones.calcularTarifaSocial(nuevoBoleto, tarjetaAbm.traerTarifaSocial());
		if(tarjeta.getMonto() - nuevoBoleto.getMonto() > -25) throw new Exception("ERROR: saldo insuficiente");
		movimientoAlta.agregarBoleto(nuevoBoleto);
		tarjeta.setMonto(tarjeta.getMonto()-nuevoBoleto.getMonto());
		tarjetaAbm.modificarTarjeta(tarjeta);
				
	}
	
	public LectoraColectivo traerLectoraColectivo(int numeroSerieLectora)
	{
		return lectoraDao.traerLectoraColectivo(numeroSerieLectora);
	}
}
