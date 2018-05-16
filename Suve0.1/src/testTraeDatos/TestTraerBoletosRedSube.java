package testTraeDatos;

import java.util.Calendar;
import java.util.GregorianCalendar;

import java.util.List;
import datos.Boleto;
import negocio.MovimientoAlta;
import negocio.TarjetaABM;

public class TestTraerBoletosRedSube {

	public static void main(String[] args) 
	{
		TarjetaABM tabm = new TarjetaABM();
		MovimientoAlta movA = new MovimientoAlta();
		GregorianCalendar fecha = new GregorianCalendar();
		//fecha.add(Calendar.HOUR, -1);
		List<Boleto> lstb = movA.traerBoletosRedSube(tabm.traerTarjeta(101), fecha);
		System.out.println(lstb.size());
		for(Boleto b: lstb){
			System.out.println(b.toString());
		}
		
		

	}

}
