package testModificaDatos;

import dao.*;
import datos.*;
public class testTraerRecarga {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovimientoDao mdao = new MovimientoDao();
		Recarga b = mdao.traerRecarga(1);
		if (b != null)
			System.out.println("Traje la Recarga: " + b.getIdMovimiento() + " y cargue: " + b.getMonto());
		else
			System.out.println(b);
	}

}
