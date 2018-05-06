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
		TransporteDao transdao = new TransporteDao();
		
		Lectora lalectora = lecdao.traerLectora(1l);
		Transporte eltransporte = transdao.traerTransporte(1l);
		for(long ntar = 1; ntar <= 22; ntar++)
		{
			Tarjeta latarjet = tardao.traerTarjeta(ntar);
			for(long i =0;i < 40;i++) {
				int monto = (int) (Math.random() * 100) + 1;
				if((int) (Math.random() * 2) == 0){
					Boleto b = new Boleto(new GregorianCalendar(), lalectora, monto, latarjet, false, 0);
					movdao.agregar(b);
					System.out.println("boleto");
				}
				else {
					Recarga r = new Recarga(new GregorianCalendar(), lalectora, monto, latarjet, false);
					movdao.agregar(r);
					System.out.println("recarga");
				}
				
			
			}
		}
		
		

	}

}
