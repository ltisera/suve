package testModificaDatos;

import dao.*;
import datos.*;
public class testTraerBoleto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovimientoDao mdao = new MovimientoDao();
		Boleto b = mdao.traerBoleto(2);
		System.out.println("Traje el Boleto: " + b.getIdMovimiento() + " y me costo: " + b.getMonto() + " Viaje en: " );
		System.out.println("Fuaaa ta caro loco!!!");
	}

}
