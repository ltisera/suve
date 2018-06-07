package controladores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.GregorianCalendar;

import negocio.TarjetaABM;

/**
 * Servlet implementation class ControladorCargarBoletoEstudiantil
 */
@WebServlet("/ControladorCargarBoletoEstudiantil")
public class ControladorCargarBoletoEstudiantil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorCargarBoletoEstudiantil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
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
		TarjetaABM tarjetaABM = new TarjetaABM();
		PrintWriter salida = response.getWriter();
		
		GregorianCalendar fechaHora = new GregorianCalendar(Integer.parseInt(request.getParameter("fanio")), 
															Integer.parseInt(request.getParameter("fmes")), 
															Integer.parseInt(request.getParameter("fdia")), 
															Integer.parseInt(request.getParameter("fhora")), 
															Integer.parseInt(request.getParameter("fminuto")), 
															Integer.parseInt(request.getParameter("fsegundo")));
		try {
			if(tarjetaABM.cargarBoletoEstudiantil(fechaHora)) {
				response.setStatus(200);
			}
			else {
				response.setStatus(500);
				salida.println("Aun no ha pasado la proxima fecha de carga");
			}
		}catch(Exception e) {
			response.setStatus(500);
			salida.println(e.getMessage());
		}
		
	}
}
