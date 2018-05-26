package testTraeDatos;
import java.util.GregorianCalendar;

import dao.*;
import datos.*;
import negocio.*;

public class TestDETEST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminDeLectoras adm = new AdminDeLectoras();
		System.out.println("DALE MAN");
		TarjetaDao tdao = new TarjetaDao();
		LectoraDao lecdao = new LectoraDao();
		EstacionDao edao = new EstacionDao();
		
		TransporteDao transdao = new TransporteDao();
		TramoColectivoDao tramdao = new TramoColectivoDao();
		
		Tarjeta t = tdao.traerTarjeta(6l);
		
		System.out.println("Monto de t: " + t.getMonto());
		/*
		try {
			adm.agregarBoleto(lecdao.traerLectorasPorLinea(transdao.traerTransporte("271").getIdTransporte()).get(1).getNumeroSerieLectora()  , t, new GregorianCalendar(), tramdao.traerTramoColectivo(2l));
		}catch (Exception e){
			System.out.println(e);
		}
		
		System.out.println("ACA SE BAJO DEL BONDY");
		*/
		/*
		//Colectivo2
		try {
			adm.agregarBoleto(lecdao.traerLectorasPorLinea(transdao.traerTransporte("800").getIdTransporte()).get(1).getNumeroSerieLectora()  , t, new GregorianCalendar(), tramdao.traerTramoColectivo(2l));
		}catch (Exception e){
			System.out.println(e);
		}
		System.out.println("ACA SE BAJO DEL BONDY 2");
		*/
		//SUBTE
		/*
		Estacion edesubida = edao.traerEstacion("Independencia");
		try {
			adm.agregarBoleto(lecdao.traerLectorasPorEstacion(edesubida.getIdEstacion()).get(1).getNumeroSerieLectora(), t, new GregorianCalendar());
		}catch (Exception e){
			System.out.println(e);
		}
		*/
		
		//TREN
		
		Estacion edebajada = edao.traerEstacion("Glew");
		try {
			adm.agregarBoleto((LectoraEstacion)lecdao.traerLectorasPorEstacion(edebajada.getIdEstacion()).get(1), t, new GregorianCalendar());
		}catch (Exception e){
			System.out.println(e);
		}
		
		System.out.println("Monto de t: " + t.getMonto());
		
	}
		

}
