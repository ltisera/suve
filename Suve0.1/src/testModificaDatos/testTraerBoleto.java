package testModificaDatos;

import dao.*;
import datos.*;
public class testTraerBoleto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("ESTE TEST");
		MovimientoDao mdao = new MovimientoDao();
		Boleto b = mdao.traerBoleto(7l);
		if (b != null)
		{
			System.out.println("Traje el Boleto: " + b.getIdMovimiento() + " y me costo: " + b.getMonto() + " Viaje en: " );
			System.out.println("Fuaaa ta caro loco!!!");
			System.out.println("Cuantos REDSUBE pegue: " + b.getIntRedSube());
		}
		else
			System.out.println(b);
	}

}
