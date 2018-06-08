package testReportesYEstadisticas;

import java.util.GregorianCalendar;
import java.util.List;

import datos.Boleto;
import datos.TipoTransporte;
import negocio.Funciones;
import negocio.MovimientoABM;
public class TestViajesRealizadosPorTipoTransporte 
{

	public static void main(String[] args) 
	{
		MovimientoABM movimientoABM = new MovimientoABM();
		
		GregorianCalendar fechaDesde = new GregorianCalendar(2018,2,5,2,40,00);
		GregorianCalendar fechaHasta = new GregorianCalendar(2018,2,7,22,15,00);
		
		List<Boleto> lstViajesRealizados = movimientoABM.viajesRealizados(fechaDesde, fechaHasta, TipoTransporte.Colectivo);
		
		System.out.println("Viajes realizados en Colectvo desde "+Funciones.TraeFechaYHora(fechaDesde)+" hasta "+Funciones.TraeFechaYHora(fechaHasta)+":\n");
		
		for(Boleto b: lstViajesRealizados)
			System.out.println(b);
		
		lstViajesRealizados = movimientoABM.viajesRealizados(fechaDesde, fechaHasta, TipoTransporte.Tren);
		
		System.out.println("\nViajes realizados en Tren desde "+Funciones.TraeFechaYHora(fechaDesde)+" hasta "+Funciones.TraeFechaYHora(fechaHasta)+":\n");
		
		for(Boleto b: lstViajesRealizados)
			System.out.println(b);
		
		lstViajesRealizados = movimientoABM.viajesRealizados(fechaDesde, fechaHasta, TipoTransporte.Subte);
		
		System.out.println("\nViajes realizados en Subte desde "+Funciones.TraeFechaYHora(fechaDesde)+" hasta "+Funciones.TraeFechaYHora(fechaHasta)+":\n");
		
		for(Boleto b: lstViajesRealizados)
			System.out.println(b);

	}

}
