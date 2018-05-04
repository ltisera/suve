package testModificaDatos;
import dao.*;
import datos.*;

public class testAgregaEstacion {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EstacionDao edao = new EstacionDao();
		TransporteDao tdao = new TransporteDao();
		Transporte t = tdao.traerTransporte(1l);
		System.out.println("EL T: " + t.getLinea() + "id:" + t.getIdTransporte());
		Estacion e = new Estacion(t, "Glew");
		edao.agregar(e);
	}

}
