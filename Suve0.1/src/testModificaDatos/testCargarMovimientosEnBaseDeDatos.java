package testModificaDatos;

import java.util.GregorianCalendar;

import dao.*;
import datos.*;

public class testCargarMovimientosEnBaseDeDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovimientoDao movdao = new MovimientoDao();
		LectoraDao lecdao = new LectoraDao();
		TarjetaDao tardao = new TarjetaDao();
		Lectora lalectora = lecdao.traerLectora(1l);
		for(long ntar = 1; ntar <= 19; ntar++)
		{
			Tarjeta latarjet = tardao.traerTarjeta(ntar);
			for(long i =0;i < 40;i++) {
				int monto = (int) (Math.random() * 100) + 1;
				if((int) (Math.random() * 2) == 0){
					movdao.agregar(new Boleto(new GregorianCalendar(), lalectora, monto, latarjet, 0, null));
					//System.out.println("boleto");
				}
				else {
					movdao.agregar(new Recarga(new GregorianCalendar(), lalectora, monto, latarjet, false));
					//System.out.println("recarga");
				}
				
			
			}
		}
		
		

	}

}
