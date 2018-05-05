package testModificaDatos;

import dao.*;
import datos.*;
public class testTraerMovimiento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovimientoDao mdao = new MovimientoDao();
		Movimiento b = mdao.traerMovimiento(2);
		System.out.println("Traje el Movimiento: " + b.getIdMovimiento() + " y me costo: " + b.getMonto());
	}

}
