package testModificaDatos;

import dao.*;
import datos.*;

public class testAgregaLectora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LectoraDao ldao = new LectoraDao();
		EstacionDao edao = new EstacionDao();
		TransporteDao tdao = new TransporteDao();
		ldao.agregar(new Lectora(edao.traerEstacion(1l), tdao.traerTransporte(1l)));
	}

}
