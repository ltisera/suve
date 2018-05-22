package controladores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import dao.*;
import datos.*;
import negocio.*;

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
		procesaSolicitud(request, response);
	}
	
	
	
	protected void procesaSolicitud(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int numSerieTarjeta = Integer.parseInt(request.getParameter("numSerieTarjeta"));
		int numSerieLectora =Integer.parseInt(request.getParameter("numSerieLectora"));
		TarjetaDao tardao = new TarjetaDao();
		
		AdminDeLectoras manejador = new AdminDeLectoras();
		
		GregorianCalendar fechaHora = new GregorianCalendar(Integer.parseInt(request.getParameter("fanio")), 
															Integer.parseInt(request.getParameter("fmes")), 
															Integer.parseInt(request.getParameter("fdia")), 
															Integer.parseInt(request.getParameter("fhora")), 
															Integer.parseInt(request.getParameter("fminuto")), 
															Integer.parseInt(request.getParameter("fsegundo")));
		
		if(request.getParameter("tipoTransporte").equals("Colectivo")) {
			//En estacion voy a tener el tramo
			TramoColectivoDao tdao = new TramoColectivoDao();
			List<TramoColectivo> list = tdao.traerTramoColectivo();
			TramoColectivo tramo = null;
			for(TramoColectivo ttemp:list) {
				System.out.println(ttemp.toString());
				if( request.getParameter("estacion").equals(ttemp.toString())){
					tramo = ttemp;
				}
			}
			if(tramo==null) {
				System.out.println("Taradooo EHhh");
			}
			else {
				try {
					System.out.println("Agrego un boleto de colectivo");
					manejador.agregarBoleto(numSerieLectora,tardao.traerTarjeta(numSerieTarjeta), fechaHora, tramo);
				} catch (Exception e) {
					System.out.println("Puto " + e);
				}
			}
		}
		else {
			try {
				System.out.println("Agrego unboleto de TS");
				manejador.agregarBoleto(numSerieLectora,tardao.traerTarjeta(numSerieTarjeta), fechaHora);
			} catch (Exception e){
				System.out.println(e);
			}
		}
		
		
		System.out.println(Funciones.TraeFechaYHora(fechaHora));
	}
	
	

}
