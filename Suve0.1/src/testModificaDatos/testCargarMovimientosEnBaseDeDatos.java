package testModificaDatos;

import java.util.Calendar;
import java.util.GregorianCalendar;

import dao.*;
import datos.*;
import negocio.LectoraABM;
import java.util.List;

public class testCargarMovimientosEnBaseDeDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LectoraABM manejador = new LectoraABM();
		MovimientoDao movdao = new MovimientoDao();
		LectoraDao lecdao = new LectoraDao();
		TarjetaDao tardao = new TarjetaDao();
		TramoColectivoDao tramodao = new TramoColectivoDao();
		List<TramoColectivo> lsttramo = tramodao.traerTramoColectivo();
		List<LectoraColectivo> lstleccol = lecdao.traerLectoraColectivo();
		List<LectoraEstacion> lstlecest = lecdao.traerLectoraEstacion();
		int avance = 0;
		GregorianCalendar fecha = new GregorianCalendar();
		fecha.add(Calendar.MONTH, -3);
		
		for(long ntar = 1; ntar <= 19; ntar++)
		{
			
			Tarjeta latarjet = tardao.traerTarjeta(tardao.traerTarjeta(ntar).getNumeroSerieTarjeta());
			for(long i =0;i < 40;i++) {
				fecha.add(Calendar.MINUTE, avance);
				if(((int) (Math.random() * 7) != 0)){
					try {
						if((int) (Math.random() * 2) == 0){
							LectoraEstacion lec1 = lstlecest.get((int) (Math.random()*lstlecest.size()));
							manejador.agregarBoleto(lec1, latarjet, fecha);
							lec1 = null;
						}
						else {
							LectoraColectivo lec1 = lstleccol.get((int) (Math.random()*lstleccol.size()));
							TramoColectivo tramo = lsttramo.get(((int)(Math.random()*4)));
							manejador.agregarBoleto(lec1, latarjet, fecha, tramo);
							lec1 = null;
							tramo = null;
						}
					}catch(Exception e) {
						//...
					}
				}
				else {
					Lectora lec1 = lstlecest.get((int) (Math.random()*lstlecest.size()));
					long id = movdao.agregar(new Recarga(fecha, lec1, (float) (Math.random() * 100) + 20, latarjet, false));
					latarjet.setMonto(latarjet.getMonto()+movdao.traerMovimiento(id).getMonto());
					tardao.actualizar(latarjet);
					lec1 = null;
				}
				avance = ((int) (Math.random() * 60) +5);
			}
		}



	}

}
