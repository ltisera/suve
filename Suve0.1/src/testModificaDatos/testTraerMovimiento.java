package testModificaDatos;

import dao.*;
import datos.*;
import funciones.Funciones;
public class testTraerMovimiento {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovimientoDao mdao = new MovimientoDao();
		Movimiento m = mdao.traerMovimientoCompleto(3);
		TarjetaDao tdao = new TarjetaDao();
		Tarjeta t = tdao.traerTarjeta(1l);
		System.out.println("Movimiento= " + Funciones.isObjetoInicializado(m));
		System.out.println("Tarjeta= " + Funciones.isObjetoInicializado(m.getTarjeta()));
		System.out.println("Usuario= " + Funciones.isObjetoInicializado(m.getTarjeta().getUsuario()));

		System.out.println(m);
		
		
	}

}
