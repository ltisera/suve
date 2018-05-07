package testTraeDatos;

import java.util.List;

import dao.MovimientoDao;
import datos.Movimiento;
import datos.Recarga;
import datos.Boleto;
import datos.Lectora;
public class testTraerMovYLec {
	public static void main(String[] args) {
		MovimientoDao mdao = new MovimientoDao();
		List<Movimiento> lm = mdao.traerMovimientoCompleto();
		for(Movimiento m:lm) {
			System.out.println(m);
		}
	}
	
}
