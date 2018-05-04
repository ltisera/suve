package testModificaDatos;

import java.util.GregorianCalendar;

import dao.*;
import datos.*;

public class testAgregarRecarga {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovimientoDao mdao = new MovimientoDao();
		LectoraDao lecdao = new LectoraDao();
		TarjetaDao tardao = new TarjetaDao();
		Recarga r = new Recarga(new GregorianCalendar(), lecdao.traerLectora(1l), 100.0f, tardao.traerTarjeta(1l), false);
		mdao.agregar(r);
	}

}
