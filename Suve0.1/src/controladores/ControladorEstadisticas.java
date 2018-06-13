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
import datos.Estacion;
import datos.TipoTransporte;
import datos.TramoColectivo;
import datos.Transporte;
import negocio.EstacionABM;
import negocio.Funciones;
import negocio.MovimientoABM;
import negocio.TramoABM;
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
		
		Transporte t = tabm.traerTransporte(request.getParameter("tipoLinea"));
		List<Boleto> lb = mabm.viajesRealizados(fechaDesde, fechaHasta, t);
		EstacionABM eabm = new EstacionABM();
		TramoABM tramoabm = new TramoABM();
		
		List<TramoColectivo> ltramo = null;

		List<Estacion> lest = null;
		int[] estEstaciones= null;
		
		if(t.getTipoTransporte() != TipoTransporte.Colectivo) {
			lest = eabm.traerEstacionPorTransporte(t.getIdTransporte());
			estEstaciones = new int[lest.size()];
		}else {
			ltramo = tramoabm.traerTramoColectivo();
			estEstaciones = new int[ltramo.size()];
		}
		
		for(int i = 0 ;i<estEstaciones.length ;i++) {
			estEstaciones[i]=0;
		}
		
		String salidaJson ="[";
		for(Boleto b:lb) {
			salidaJson += "{\"fechaHora\":\"" + Funciones.TraeFechaYHora(b.getFecha()) +"\",";
			salidaJson += "\"numTarjeta\":\"" + b.getTarjeta().getNumeroSerieTarjeta()+"\",";
			salidaJson += "\"intRedSube\":\"" + b.getIntRedSube()+"\",";
			if(b.getTramoColectivo() !=null) {
				salidaJson += "\"tramo\":\"" + b.getTramoColectivo()+"\",";
				salidaJson += "\"estadisticaTramo\":\"" + b.getTramoColectivo().getIdTramoColectivo()+"\",";
				salidaJson += "\"nombreTramo\":\"" + b.getTramoColectivo()+"\",";
				for(int i = 0; i < ltramo.size(); i++) {
					if(ltramo.get(i).equals(b.getTramoColectivo())) {
						estEstaciones[i] +=1;
					}
					
				}
				
			} else {
				salidaJson += "\"tramo\":\"" + b.getTramoTrenYSubte()+"\",";
				if(b.getTramoTrenYSubte().getEstacionB()==null) {
					salidaJson += "\"estadisticaTramo\":\"" + b.getTramoTrenYSubte().getEstacionA().getIdEstacion()+"\",";
					salidaJson += "\"nombreTramo\":\"" + b.getTramoTrenYSubte().getEstacionA().getNombre()+"\",";
					for(int i = 0; i < lest.size(); i++) {
						if(lest.get(i).equals(b.getTramoTrenYSubte().getEstacionA())) {
							estEstaciones[i] +=1;
						}
						
					}
					
					
				}
			}
			salidaJson += "\"monto\":\"" + b.getMonto()+"\"},";
		}
		
		String salidaArray = "[";
		for(int i = 0 ;i<estEstaciones.length ;i++) {
			salidaArray += estEstaciones[i]+",";
		}
			
		
		salidaArray = salidaArray.substring(0, salidaArray.length()-1);
		salidaArray += "]},";
		salidaJson += "{\"arrayEST\":" + salidaArray;
		
		String salidaLista="{\"arrayNombres\":[";
		
		if(t.getTipoTransporte() != TipoTransporte.Colectivo) {
			for(Estacion e:lest) {
				salidaLista +="\""+e.getNombre()+"\",";
			}
		} else {
			for(TramoColectivo e:ltramo) {
				salidaLista +="\""+e.toString()+"\",";
			}
		}
		salidaLista = salidaLista.substring(0, salidaLista.length()-1);
		salidaLista += "]}";
		salidaJson += salidaLista;
		salidaJson += "]";
		salida.println(salidaJson);
		System.out.println(salidaJson);
		
		response.setStatus(200);
	}
}

