package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Boleto;
import datos.TipoTransporte;
import negocio.Funciones;
import negocio.MovimientoABM;

/**
 * Servlet implementation class ControladorEstadisticas
 */
@WebServlet("/ControladorEstadisticas")
public class ControladorEstadisticas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorEstadisticas() {
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
		procesarSolicitud(request, response);
	}
	
	protected void procesarSolicitud(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovimientoABM mabm = new MovimientoABM();
		
		response.setContentType("application/json");
		PrintWriter salida = response.getWriter();
		
		
		int fdYear = Integer.parseInt(request.getParameter("fechaDesde").split("-")[0]);
		int fdMonth = Integer.parseInt(request.getParameter("fechaDesde").split("-")[1]);
		int fdDate = Integer.parseInt(request.getParameter("fechaDesde").split("-")[2]);
		
		int fhYear = Integer.parseInt(request.getParameter("fechaHasta").split("-")[0]);
		int fhMonth = Integer.parseInt(request.getParameter("fechaHasta").split("-")[1]);
		int fhDate = Integer.parseInt(request.getParameter("fechaHasta").split("-")[2]);
		
		GregorianCalendar fechaDesde = new GregorianCalendar(fdYear, fdMonth-1, fdDate);
		GregorianCalendar fechaHasta = new GregorianCalendar(fhYear, fhMonth-1, fhDate);
		TipoTransporte tipoTransporte = null;
		if(request.getParameter("tipoTransporte").equals("Tren")) {
			tipoTransporte = TipoTransporte.Tren;
		}
		if(request.getParameter("tipoTransporte").equals("Colectivo")) {
			tipoTransporte = TipoTransporte.Colectivo;
		}
		if(request.getParameter("tipoTransporte").equals("Subte")) {
			tipoTransporte = TipoTransporte.Subte;
		}
		System.out.println("GC1: " + Funciones.TraeFechaYHora(fechaDesde));
		System.out.println("GC2: " + Funciones.TraeFechaYHora(fechaHasta));
		System.out.println("TipoTransporte: " + tipoTransporte);
		
		List<Boleto> lb = mabm.viajesRealizados(fechaDesde, fechaHasta, tipoTransporte);
		System.out.println(lb);
		String salidaJson ="[";
		for(Boleto b:lb) {
			salidaJson += "{\"fechaHora\":\"" + Funciones.TraeFechaYHora(b.getFecha()) +"\",";
			salidaJson += "\"numTarjeta\":\"" + b.getTarjeta().getNumeroSerieTarjeta()+"\",";
			salidaJson += "\"monto\":\"" + b.getMonto()+"\"},";
		}
		salidaJson = salidaJson.substring(0, salidaJson.length()-1);
		salidaJson += "]";
		salida.println(salidaJson);
		System.out.println("Salida Json:" + salidaJson);
		response.setStatus(200);
	}

}

