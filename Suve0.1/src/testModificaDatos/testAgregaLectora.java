package testModificaDatos;

import dao.*;
import datos.*;

public class testAgregaLectora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LectoraDao ldao = new LectoraDao();
		EstacionDao edao = new EstacionDao();
		ldao.agregar(new LectoraEstacion(edao.traerEstacion(1l),3331234));
	}

}
