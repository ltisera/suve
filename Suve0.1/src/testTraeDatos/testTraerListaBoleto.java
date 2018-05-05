package testTraeDatos;

import java.util.List;

import dao.MovimientoDao;
import datos.Boleto;

public class testTraerListaBoleto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovimientoDao mdao = new MovimientoDao();
		List<Boleto> lb = mdao.traerBoleto(); 
		System.out.println("PUTO");
		for(Boleto b:lb) {
			System.out.println("Boleto: " + b.getIdMovimiento() + " Monto: " + b.getMonto());
		}
		System.out.println("CONTOSTRING");
		for(Boleto b:lb) {
			System.out.println(b.toString());
		}
		
	}

}
