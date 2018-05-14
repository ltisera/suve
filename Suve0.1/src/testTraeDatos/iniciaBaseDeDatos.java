package testTraeDatos;

import java.util.List;

import datos.Movimiento;
import testModificaDatos.tCargarMultiplesUsuariosYTarjetas;
import testModificaDatos.testAgregaEstacion;
import testModificaDatos.testAgregaLectora;
import testModificaDatos.testAgregaTransporte;
import testModificaDatos.testCargarMovimientosEnBaseDeDatos;

public class iniciaBaseDeDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testAgregaTransporte.main(args);
		testAgregaEstacion.main(args);
		testAgregaLectora.main(args);
		tCargarMultiplesUsuariosYTarjetas.main(args);
		testCargarMovimientosEnBaseDeDatos.main(args);
		System.out.println("Base inicializada");
	}

}
