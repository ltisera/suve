package testTraeDatos;

import negocio.MovimientoAlta;

public class TestTraerUltimoBoleto {

	public static void main(String[] args) 
	{
		MovimientoAlta movA = new MovimientoAlta();
		System.out.println(movA.traerUltimoBoleto(11l));

	}

}
