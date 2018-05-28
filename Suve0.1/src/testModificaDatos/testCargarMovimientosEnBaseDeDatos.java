package testModificaDatos;

import java.util.GregorianCalendar;

import dao.*;
import datos.*;
import negocio.AdminDeLectoras;
import java.util.List;

import org.hibernate.HibernateException;

public class testCargarMovimientosEnBaseDeDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminDeLectoras manejador = new AdminDeLectoras();
		MovimientoDao movdao = new MovimientoDao();
		LectoraDao lecdao = new LectoraDao();
		TarjetaDao tardao = new TarjetaDao();
		TramoColectivoDao tramodao = new TramoColectivoDao();
		List<Lectora> lalectora = lecdao.traerLectora();
		TramoColectivo tramo = tramodao.traerTramoColectivo(1l);
		for(long ntar = 1; ntar <= 19; ntar++)
		{
			Tarjeta latarjet = tardao.traerTarjeta(ntar);
			for(long i =0;i < 40;i++) {
				int monto = (int) (Math.random() * 100) + 1;
				Lectora lec1 = lalectora.get((int)Math.random()*lalectora.size());
				if((int) (Math.random() * 2) == 0){
					if(lec1 instanceof LectoraEstacion) {
						try {
							manejador.agregarBoleto((LectoraEstacion)lec1, latarjet, new GregorianCalendar());
						}catch(Exception e) {
							
						}
					}
					if(lec1 instanceof LectoraColectivo){
						TramoColectivoDao tramdao = new TramoColectivoDao();
						try {
							manejador.agregarBoleto((LectoraColectivo)lec1, latarjet, new GregorianCalendar(), tramdao.traerTramoColectivo(2l));
						} catch (Exception e) {
							
						}
					}

				}
				else {
					movdao.agregar(new Recarga(new GregorianCalendar(), lec1, monto, latarjet, false));
					//System.out.println("recarga");
				}
				
			
			}
		}
		
		

	}

}
