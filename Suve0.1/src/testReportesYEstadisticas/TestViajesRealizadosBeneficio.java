package testReportesYEstadisticas;

import java.util.GregorianCalendar;
import java.util.List;

import datos.Boleto;
import negocio.MovimientoABM;
import negocio.TarjetaABM;

public class TestViajesRealizadosBeneficio {

	public static void main(String[] args) 
	{
		MovimientoABM movimientoABM = new MovimientoABM();
		TarjetaABM tarjetaABM = new TarjetaABM();
		
		GregorianCalendar fechaDesde = new GregorianCalendar(2018,2,5,2,40,00);
		GregorianCalendar fechaHasta = new GregorianCalendar(2018,2,7,22,15,00);
		
		List<Boleto> lstBoletos = movimientoABM.viajesRealizados(fechaDesde, fechaHasta, tarjetaABM.traerBoletoEstudiantil());
		
		for(Boleto b: lstBoletos)
			System.out.println(b);

	}

}
