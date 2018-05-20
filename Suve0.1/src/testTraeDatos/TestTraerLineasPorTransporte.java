package testTraeDatos;

import java.util.List;

import dao.TransporteDao;
import datos.TipoTransporte;
import datos.Transporte;

public class TestTraerLineasPorTransporte {

	public static void main(String[] args) 
	{
		
		TransporteDao tdao = new TransporteDao();
		/*
		tdao.agregar(new Transporte("160", TipoTransporte.Colectivo));
		tdao.agregar(new Transporte("79", TipoTransporte.Colectivo));
		tdao.agregar(new Transporte("299", TipoTransporte.Colectivo));
		tdao.agregar(new Transporte("Subte B", TipoTransporte.Subte));
		tdao.agregar(new Transporte("Subte A", TipoTransporte.Subte));
		tdao.agregar(new Transporte("Sarmiento", TipoTransporte.Tren));
		*/
		
		List<Transporte> colectivos = tdao.traerLineasPorTransporte(TipoTransporte.Colectivo);
		List<Transporte> trenes = tdao.traerLineasPorTransporte(TipoTransporte.Tren);
		List<Transporte> subtes = tdao.traerLineasPorTransporte(TipoTransporte.Subte);
		
		System.out.println(TipoTransporte.Colectivo+" "+TipoTransporte.Tren+" "+TipoTransporte.Subte);
		
		System.out.println("Lineas de colectivo:\n");
		for(Transporte c: colectivos) System.out.println(c);
		
		System.out.println("\n\nLineas de tren:\n");
		for(Transporte t: trenes) System.out.println(t);
		
		System.out.println("\n\nLineas de Subte:\n");
		for(Transporte s: subtes) System.out.println(s);
		
		
	}

}
