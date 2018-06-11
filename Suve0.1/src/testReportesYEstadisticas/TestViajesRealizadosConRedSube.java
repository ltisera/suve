package testReportesYEstadisticas;

import java.util.GregorianCalendar;
import java.util.List;

import datos.Boleto;
import negocio.MovimientoABM;


public class TestViajesRealizadosConRedSube {

	public static void main(String[] args) 
	{
		MovimientoABM movimientoABM = new MovimientoABM();
		
		GregorianCalendar fechaDesde = new GregorianCalendar(2018,2,5,2,40,00);
		GregorianCalendar fechaHasta = new GregorianCalendar(2018,2,7,22,15,00);
		
		List<Boleto> lstBoletos = movimientoABM.viajesRealizadosConRedSube(fechaDesde, fechaHasta);
		
		for(Boleto b: lstBoletos)
			System.out.println(b);

	}

}
