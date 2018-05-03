package testModificaDatos;
import java.util.GregorianCalendar;

import dao.*;
import datos.*;

public class testAgregaMovimiento {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovimientoDao mdao = new MovimientoDao();
		TarjetaDao tardao = new TarjetaDao();
		Tarjeta t = tardao.traerTarjeta(1l);
		Movimiento m = new Movimiento(new GregorianCalendar(), 142, t);
		mdao.agregar(m);
		System.out.println("Vamo don carlo!!!!!" );
		
	}
}
