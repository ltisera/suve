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

import dao.TransporteDao;
import datos.Boleto;
import datos.TipoTransporte;
import negocio.Funciones;
import negocio.MovimientoABM;
import negocio.TransporteABM;

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
		if(request.getParameter("tipoReporte").equals("Reporte Tipo Transporte")) {
			reporteTipoTransporte(request, response);
		}
		if(request.getParameter("tipoReporte").equals("Reporte Linea Transporte")) {
			reporteLineaTransporte(request, response);
		}
			
	}

	protected void reporteTipoTransporte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		List<Boleto> lb = mabm.viajesRealizados(fechaDesde, fechaHasta, tipoTransporte);
		String salidaJson ="[";
		for(Boleto b:lb) {
			salidaJson += "{\"fechaHora\":\"" + Funciones.TraeFechaYHora(b.getFecha()) +"\",";
			salidaJson += "\"numTarjeta\":\"" + b.getTarjeta().getNumeroSerieTarjeta()+"\",";
			salidaJson += "\"intRedSube\":\"" + b.getIntRedSube()+"\",";
			salidaJson += "\"monto\":\"" + b.getMonto()+"\"},";
		}
		salidaJson = salidaJson.substring(0, salidaJson.length()-1);
		salidaJson += "]";
		salida.println(salidaJson);
		response.setStatus(200);
	}
	
	protected void reporteLineaTransporte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
MovimientoABM mabm = new MovimientoABM();
		
		response.setContentType("application/json");
		PrintWriter salida = response.getWriter();
		
		System.out.println("ACA TOY1");
		int fdYear = Integer.parseInt(request.getParameter("fechaDesde").split("-")[0]);
		int fdMonth = Integer.parseInt(request.getParameter("fechaDesde").split("-")[1]);
		int fdDate = Integer.parseInt(request.getParameter("fechaDesde").split("-")[2]);
		
		int fhYear = Integer.parseInt(request.getParameter("fechaHasta").split("-")[0]);
		int fhMonth = Integer.parseInt(request.getParameter("fechaHasta").split("-")[1]);
		int fhDate = Integer.parseInt(request.getParameter("fechaHasta").split("-")[2]);
		
		GregorianCalendar fechaDesde = new GregorianCalendar(fdYear, fdMonth-1, fdDate);
		GregorianCalendar fechaHasta = new GregorianCalendar(fhYear, fhMonth-1, fhDate);
		
		
		TransporteABM tabm = new TransporteABM();
		
		List<Boleto> lb = mabm.viajesRealizados(fechaDesde, fechaHasta, tabm.traerTransporte(request.getParameter("tipoLinea")));
		String salidaJson ="[";
		for(Boleto b:lb) {
			salidaJson += "{\"fechaHora\":\"" + Funciones.TraeFechaYHora(b.getFecha()) +"\",";
			salidaJson += "\"numTarjeta\":\"" + b.getTarjeta().getNumeroSerieTarjeta()+"\",";
			salidaJson += "\"intRedSube\":\"" + b.getIntRedSube()+"\",";
			if(b.getTramoColectivo() !=null) {
				salidaJson += "\"tramo\":\"" + b.getTramoColectivo()+"\",";
			} else {
				salidaJson += "\"tramo\":\"" + b.getTramoTrenYSubte()+"\",";
			}
			salidaJson += "\"monto\":\"" + b.getMonto()+"\"},";
		}
		salidaJson = salidaJson.substring(0, salidaJson.length()-1);
		salidaJson += "]";
		salida.println(salidaJson);
		response.setStatus(200);
	}
}

