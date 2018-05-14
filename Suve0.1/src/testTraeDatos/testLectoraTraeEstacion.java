package testTraeDatos;

import dao.*;
import datos.*;

public class testLectoraTraeEstacion {
	public static void main(String[] args) {
		LectoraDao lecdao = new LectoraDao();
		LectoraEstacion l = (LectoraEstacion) lecdao.traerLectora(1l);
		if(l instanceof LectoraEstacion)
			System.out.println("Bien");
		System.out.println(l.getEstacion().getTransporte());
	}
}
