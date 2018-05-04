package testModificaDatos;
import java.util.GregorianCalendar;

import dao.*;
import datos.*;

public class testAgregaMovimiento {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Boleto b = new Boleto(m, fecha, monto, tarjeta, cerrado, intRedSube, transporte)
		MovimientoDao mdao = new MovimientoDao();
		TarjetaDao tardao = new TarjetaDao();
		LectoraDao lecdao = new LectoraDao();
		Tarjeta t = tardao.traerTarjeta(1l);
		Movimiento m = new Movimiento(new GregorianCalendar(), lecdao.traerLectora(1l),142, t);
		mdao.agregar(m);
		System.out.println("Vamo don carlo!!!!!" );
		
	}
}
