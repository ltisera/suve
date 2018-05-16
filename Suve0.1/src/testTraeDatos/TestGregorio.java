package testTraeDatos;

import java.util.GregorianCalendar;
import funciones.*;
import negocio.Funciones;
public class TestGregorio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(Funciones.TraeFechaYHora(gc));
	}

}
