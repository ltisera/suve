package testTraeDatos;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import dao.*;
import datos.*;
import negocio.*;

public class TestDETEST {

	public static void main(String[] args) {
		MovimientoDao mdao = new MovimientoDao();
		 System.out.println( mdao.traerRecargaEstudiantil());

	}
}
