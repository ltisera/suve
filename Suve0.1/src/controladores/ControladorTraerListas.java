package controladores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.TransientPropertyValueException;

import dao.*;
import datos.*;

import java.util.ArrayList;
import java.util.List;
/**
 * Servlet implementation class ControladorTraerListas
 */
@WebServlet("/ControladorTraerListas")
public class ControladorTraerListas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorTraerListas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traerLista(request, response);
	}
	
	protected void traerLista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("application/json");
		if(request.getParameter("lista").equals("Linea")) {
			traerListaLinea(request, response);
		}
		if(request.getParameter("lista").equals("Estaciones")) {
			if(request.getParameter("transporte").equals("Colectivo")) {
				traerListaTramos(request, response);
			}
			else {
				traerListaEstaciones(request, response);
			}
		}
		if(request.getParameter("lista").equals("Lectoras")) {
			traerListaLectoras(request, response);
		}
		if(request.getParameter("lista").equals("Tarjetas")) {
			traerListaTarjetas(request, response);
		}
		
	}

	protected void traerListaLinea(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			response.setStatus(200);
			response.setContentType("application/json");
			PrintWriter salida = response.getWriter();
			
			TransporteDao tdao = new TransporteDao();
			TipoTransporte tipo = null;
			if(request.getParameter("transporte").equals("Colectivo")) {
				tipo = TipoTransporte.Colectivo;
			}
			if(request.getParameter("transporte").equals("Tren")) {
				tipo = TipoTransporte.Tren;
			}
			if(request.getParameter("transporte").equals("Subte")) {
				tipo = TipoTransporte.Subte;
			}
			
			
			List<Transporte> lt = tdao.traerLineasPorTransporte(tipo);
			String objetoJ = "[";
			for (Transporte t:lt) {
				objetoJ += "\""+t.getLinea()+"\",";
			}
			objetoJ = objetoJ.substring(0, objetoJ.length()-1);
			objetoJ +="]";
			salida.println(objetoJ);
			System.out.println(objetoJ);
			System.out.println("tipoTransporte:" + request.getParameter("transporte") + "\nLista: " + lt);
		
		} catch (Exception e){
			response.sendError(500, "El ID del boleto no fue encontrado" );
		}
		
	}
	protected void traerListaEstaciones(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			response.setStatus(200);
			response.setContentType("application/json");
			PrintWriter salida = response.getWriter();
			
			EstacionDao edao = new EstacionDao();
			TransporteDao tdao = new TransporteDao();
			List<Estacion> le = edao.traerEstacionPorTransporte(tdao.traerTransporte(request.getParameter("linea")).getIdTransporte());
			
			String objetoJ = "[";
			for (Estacion e:le) {
				objetoJ += "\""+e.getNombre()+"\",";
			}
			
			objetoJ = objetoJ.substring(0, objetoJ.length()-1);
			objetoJ +="]";
			salida.println(objetoJ);
			System.out.println(objetoJ);
			System.out.println("Linea:" + request.getParameter("linea") + "\nLista: " + le);
		
		} catch (Exception e){
			response.sendError(500, "El ID del boleto no fue encontrado" );
		}
		
	}
	protected void traerListaTarjetas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			response.setStatus(200);
			response.setContentType("application/json");
			PrintWriter salida = response.getWriter();
			//Esto es un obj Jason?
			TarjetaDao tardao = new TarjetaDao();
			List<Tarjeta> lt= tardao.traerTarjeta();
			
			String miResponse ="";
			miResponse ="[";
			
			for(Tarjeta s:lt) {
				miResponse += "\"" + s.getNumeroSerieTarjeta() + "\",";
			}
			miResponse = miResponse.substring(0, miResponse.length()-1);
			miResponse += "]";
			
			//salida.println( "[\"manzaa\",\"pera\",\"frutilsda\"]" );
			System.out.println(miResponse);
			salida.println( miResponse);
			//Esto No es jason?
		
		} catch (Exception e){
			response.sendError(500, "Error Traer Lista Tarjeta" );
		}
		
	}
	protected void traerListaTramos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			response.setStatus(200);
			response.setContentType("application/json");
			PrintWriter salida = response.getWriter();
			
			TramoColectivoDao tdao = new TramoColectivoDao();
			List<TramoColectivo> list = tdao.traerTramoColectivo();
			
			String objetoJ = "[";
			for (TramoColectivo t:list) {
				objetoJ += "\""+t+"\",";
			}
			
			objetoJ = objetoJ.substring(0, objetoJ.length()-1);
			objetoJ +="]";
			salida.println(objetoJ);
			System.out.println(objetoJ);
			System.out.println("Linea:" + request.getParameter("linea") + "\nLista: " + list);
		
		} catch (Exception e){
			response.sendError(500, "El ID del boleto no fue encontrado" );
		}
		
	}
	protected void traerListaLectoras(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			response.setStatus(200);
			response.setContentType("application/json");
			PrintWriter salida = response.getWriter();
			
			LectoraDao lecdao = new LectoraDao();
			List<Lectora> list = null;
			if(request.getParameter("transporte").equals("Colectivo")) {
				TransporteDao tdao = new TransporteDao();
				System.out.println("VAMO A IMPRIMI");
				Transporte t = tdao.traerTransporte(request.getParameter("linea"));
				list = lecdao.traerLectorasPorLinea(t.getIdTransporte());
				System.out.println("La lista:" + list);
			}
			else {
				EstacionDao edao = new EstacionDao();
				Estacion e = edao.traerEstacion(request.getParameter("estacion"));
				list = lecdao.traerLectorasPorEstacion(e.getIdEstacion());
			}
			
			String objetoJ = "[";
			for (Lectora t:list) {
				objetoJ += "\""+t.getNumeroSerieLectora()+"\",";
			}
			
			objetoJ = objetoJ.substring(0, objetoJ.length()-1);
			objetoJ +="]";
			salida.println(objetoJ);
			System.out.println(objetoJ);
			System.out.println("Estacion:" + request.getParameter("estacion") + "\nLista: " + list);
		
		} catch (Exception e){
			response.sendError(500, "Algo paso no se que" );
		}
		
	}
		
}
