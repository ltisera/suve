package controladores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;

import java.util.GregorianCalendar;
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
	
	
	
	protected void procesaSolicitud(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int numSerieTarjeta = Integer.parseInt(request.getParameter("numSerieTarjeta"));
		int numSerieLectora =Integer.parseInt(request.getParameter("numSerieLectora"));
		TarjetaABM tarjetaABM = new TarjetaABM();
		LectoraABM lectoraABM = new LectoraABM();
		TramoABM tramoABM = new TramoABM();
		
		PrintWriter salida = response.getWriter();
		
		GregorianCalendar fechaHora = new GregorianCalendar(Integer.parseInt(request.getParameter("fanio")), 
															Integer.parseInt(request.getParameter("fmes")), 
															Integer.parseInt(request.getParameter("fdia")), 
															Integer.parseInt(request.getParameter("fhora")), 
															Integer.parseInt(request.getParameter("fminuto")), 
															Integer.parseInt(request.getParameter("fsegundo")));
		
		if(request.getParameter("tipoTransporte").equals("Colectivo")) 
		{
			try 
			{
				lectoraABM.agregarBoleto(lectoraABM.traerLectoraColectivo(numSerieLectora),tarjetaABM.traerTarjetaConBeneficios(numSerieTarjeta), fechaHora, tramoABM.traerTramoColectivo(request.getParameter("estacion")));
				response.setStatus(200);

			} 
			catch (Exception e) 
			{
				response.setStatus(500);
				salida.println(e.getMessage());
			}
		}
		else 
		{
			try 
			{
				lectoraABM.agregarBoleto(lectoraABM.traerLectoraEstacion(numSerieLectora),tarjetaABM.traerTarjetaConBeneficios(numSerieTarjeta), fechaHora);
				response.setStatus(200);
			}
			catch (Exception e)
			{
				response.setStatus(500);
				salida.println(e.getMessage());
			}
		}
	}
	
	

}
