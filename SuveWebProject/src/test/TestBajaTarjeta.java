package test;

import dao.TarjetaDao;
import datos.Tarjeta;
import negocio.Administrador;

public class TestBajaTarjeta {

	public static void main(String[] args) 
	{
		/*
		TarjetaDao tdao = new TarjetaDao();
		Tarjeta t= tdao.traerTarjeta(1l);
		
		t.setActiva(true);
		
		tdao.actualizar(t);
		
		*/
		try {
			Administrador.bajaTarjeta(1l);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
