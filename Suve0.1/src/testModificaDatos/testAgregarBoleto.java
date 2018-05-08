package testModificaDatos;
import java.util.GregorianCalendar;

import dao.*;
import datos.*;

public class testAgregarBoleto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovimientoDao mdao = new MovimientoDao();
		TarjetaDao tardao = new TarjetaDao();
		LectoraDao lecdao = new LectoraDao();
		Boleto b = new Boleto(new GregorianCalendar(), lecdao.traerLectora(1l), 713.5f, tardao.traerTarjeta(1l), 1, null);
		mdao.agregar(b);
	}

}
