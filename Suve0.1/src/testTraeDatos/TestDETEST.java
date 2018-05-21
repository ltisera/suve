package testTraeDatos;
import dao.*;
import datos.*;
public class TestDETEST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("DALE MAN");
		EstacionDao edao = new EstacionDao();
		System.out.println(edao.traerEstacionPorTransporte(1l));
		
	}

}
