package testModificaDatos;
import dao.*;
import datos.LectoraCarga;
public class testCrearLectoraCarga {
	public static void main(String[] args) {
		EstacionDao edao = new EstacionDao();
		LectoraDao lecdao = new LectoraDao();
		
		lecdao.agregar(new LectoraCarga(edao.traerEstacion("Burzaco"),2));
		lecdao.agregar(new LectoraCarga(edao.traerEstacion("Adrogue"),3));
	}
}
