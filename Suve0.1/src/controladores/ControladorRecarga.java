package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import negocio.LectoraABM;

public class ControladorRecarga extends HttpServlet{

	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesaSolicitud(request, response);
	}
	
	protected void procesaSolicitud(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int numSerieTarjeta = Integer.parseInt(request.getParameter("numSerieTarjeta"));
		float monto = Integer.parseInt(request.getParameter("monto"));
		int numSerieLectora = Integer.parseInt(request.getParameter("numSerieLectora"));
		GregorianCalendar fechaHora = new GregorianCalendar(Integer.parseInt(request.getParameter("fanio")), 
				Integer.parseInt(request.getParameter("fmes")), 
				Integer.parseInt(request.getParameter("fdia")), 
				Integer.parseInt(request.getParameter("fhora")), 
				Integer.parseInt(request.getParameter("fminuto")), 
				Integer.parseInt(request.getParameter("fsegundo")));


		LectoraABM labm = new LectoraABM();
		try {
			if(labm.agregarRecarga(numSerieLectora, numSerieTarjeta, fechaHora, monto, false) != null) {
				response.setStatus(200);//Recarga realizada
			}
			else {
				response.setStatus(500);//No se pudo generar la recarga
			}
		}catch(Exception e) {
			response.setStatus(500);//No se pudo generar la recarga
		}
	}
}
