package controladores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

import dao.*;
import datos.*;


/**
 * Servlet implementation class ControladorAgregarBoleto
 */
@WebServlet("/ControladorAgregarBoleto")
public class ControladorAgregarBoleto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorAgregarBoleto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		procesaSolicitud(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("pedirLista"));
		if(!request.getParameter("pedirLista").equals("da")){
			procesaSolicitud(request, response);
		}
		else {
			response.setStatus(200);
			response.setContentType("application/json");
			PrintWriter salida = response.getWriter();
			//Esto es un obj Jason?
			List<String> asd = new ArrayList();
			asd.add("fruta");
			asd.add("verdua");
			asd.add("fvsvd");
			asd.add("23d");
			asd.add("PAYASOd");
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
			
		}
	}
	protected void procesaSolicitud(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int numTarjeta = Integer.parseInt(request.getParameter("numTarjeta"));
		System.out.println(numTarjeta);
		
		
		System.out.println((request.getParameter("tipoTransporte")));
		
	}
	
	

}
