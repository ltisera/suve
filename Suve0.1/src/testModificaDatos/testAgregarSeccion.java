package testModificaDatos;
import dao.*;
import datos.*;

public class testAgregarSeccion {
	public static void main(String[] args) {
		SeccionViajeDao secdao = new SeccionViajeDao();
		
		secdao.agregar(new SeccionViaje("Seccion Maxima Tren", 7.5f, TipoTransporte.Tren));
		secdao.agregar(new SeccionViaje("Seccion 1 Tren", 1.5f, TipoTransporte.Tren));
		secdao.agregar(new SeccionViaje("Seccion 2 Tren", 3.5f, TipoTransporte.Tren));
		secdao.agregar(new SeccionViaje("Seccion 3 Tren", 5.5f, TipoTransporte.Tren));
		
	}
}
