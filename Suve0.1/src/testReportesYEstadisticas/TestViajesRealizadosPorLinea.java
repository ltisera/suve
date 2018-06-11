package testReportesYEstadisticas;

import java.util.GregorianCalendar;
import java.util.List;

import dao.TransporteDao;
import datos.Boleto;
import negocio.Funciones;
import negocio.MovimientoABM;
import negocio.TransporteABM;

public class TestViajesRealizadosPorLinea {

	public static void main(String[] args) 
	{

		MovimientoABM movABM = new MovimientoABM();
		TransporteABM transporteABM = new TransporteABM();
		TransporteDao transDao = new TransporteDao();
		
		GregorianCalendar fechaDesde = new GregorianCalendar(2018,2,5,2,40,00);
		GregorianCalendar fechaHasta = new GregorianCalendar(2018,2,7,22,15,00);
		
		List<Boleto> lstViajesRealizados = movABM.viajesRealizados(fechaDesde, fechaHasta, transporteABM.traerTransporte("281"));
		
		System.out.println("Viajes realizados en La linea 281(colectivo) desde "+Funciones.TraeFechaYHora(fechaDesde)+" hasta "+Funciones.TraeFechaYHora(fechaHasta)+":\n");
		
		for(Boleto b: lstViajesRealizados)
			System.out.println(b);
		
		lstViajesRealizados = movABM.viajesRealizados(fechaDesde, fechaHasta, transporteABM.traerTransporte("Roca"));
		
		System.out.println("\nViajes realizados en La linea Roca(tren) desde "+Funciones.TraeFechaYHora(fechaDesde)+" hasta "+Funciones.TraeFechaYHora(fechaHasta)+":\n");
		
		for(Boleto b: lstViajesRealizados)
			System.out.println(b);
		
		lstViajesRealizados = movABM.viajesRealizados(fechaDesde, fechaHasta, transporteABM.traerTransporte("Linea C"));
		
		System.out.println("\nViajes realizados en La linea C(subte) desde "+Funciones.TraeFechaYHora(fechaDesde)+" hasta "+Funciones.TraeFechaYHora(fechaHasta)+":\n");
		
		for(Boleto b: lstViajesRealizados)
			System.out.println(b);

	}

}
