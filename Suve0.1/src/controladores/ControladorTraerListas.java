package controladores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import datos.*;
import negocio.EstacionABM;
import negocio.Funciones;
import negocio.LectoraABM;
import negocio.MovimientoABM;
import negocio.TarjetaABM;
import negocio.TramoABM;
import negocio.TransporteABM;

import java.util.List;
import java.util.Set;
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
			System.out.println("generando lista de tarjetas");
			
			traerListaTarjetas(request, response);
		}
		if(request.getParameter("lista").equals("UltimosViajes")) {
			System.out.println("Leyendo Viajes de tarjeta");
			
			traerListaUltimosViajes(request, response);
		}
		
	}

	protected void traerListaLinea(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			response.setStatus(200);
			response.setContentType("application/json");
			PrintWriter salida = response.getWriter();
			
			TransporteABM transporteABM = new TransporteABM();
			List<Transporte> lstTransporte = null;
			if(request.getParameter("transporte").equals("Colectivo")) {
				lstTransporte = transporteABM.traerLineasPorTransporte(TipoTransporte.Colectivo);
			}
			if(request.getParameter("transporte").equals("Tren")) {
				lstTransporte = transporteABM.traerLineasPorTransporte(TipoTransporte.Tren);
			}
			if(request.getParameter("transporte").equals("Subte")) {
				lstTransporte = transporteABM.traerLineasPorTransporte(TipoTransporte.Subte);
			}
			

			salida.println(transporteABM.stringListaDeNombresDeLineas(lstTransporte));
		
		} catch (Exception e){
			response.sendError(500, "El ID del boleto no fue encontrado" );
		}
		
	}
	protected void traerListaEstaciones(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			response.setStatus(200);
			response.setContentType("application/json");
			PrintWriter salida = response.getWriter();
			
			EstacionABM estacionABM = new EstacionABM();
			TransporteABM transporteABM = new TransporteABM();
			List<Estacion> lstEstacion = estacionABM.traerEstacionPorTransporte(transporteABM.traerTransporte(request.getParameter("linea")).getIdTransporte());
			

			salida.println(estacionABM.stringListaNombresDeEstaciones(lstEstacion));
		
		} catch (Exception e){
			response.sendError(500, "El ID del boleto no fue encontrado" );
		}
		
	}
	protected void traerListaTarjetas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setStatus(200);
			response.setContentType("application/json");
			PrintWriter salida = response.getWriter();
			
			TarjetaABM tarjetaABM = new TarjetaABM();
			List<Tarjeta> lstTarjeta= tarjetaABM.traerTarjeta();
		
			
			salida.println(tarjetaABM.stringListaTarjetas(lstTarjeta));
		
		} catch (Exception e){
			response.sendError(500, "Error Traer Lista Tarjeta" );
		}
		
	}
	protected void traerListaTramos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			response.setStatus(200);
			response.setContentType("application/json");
			PrintWriter salida = response.getWriter();
			
			TramoABM tramoABM = new TramoABM();
			List<TramoColectivo> lstTramoColectivo = tramoABM.traerTramoColectivo();
			

			salida.println(tramoABM.stringDeListaTramoColectivo(lstTramoColectivo));
		
		} catch (Exception e){
			response.sendError(500, "El ID del boleto no fue encontrado" );
		}
		
	}
	protected void traerListaLectoras(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			response.setStatus(200);
			response.setContentType("application/json");
			PrintWriter salida = response.getWriter();
			TransporteABM transporteABM = new TransporteABM();
			LectoraABM lectoraABM = new LectoraABM();
			List<Lectora> lstLectora = null;
			if(request.getParameter("transporte").equals("Colectivo")) {
				lstLectora = lectoraABM.traerLectorasPorLinea(transporteABM.traerTransporte(request.getParameter("linea")).getIdTransporte());
			}
			else {
				EstacionABM estacionABM = new EstacionABM();
				lstLectora = lectoraABM.traerLectorasPorEstacion(estacionABM.traerEstacion(request.getParameter("estacion")));
			}
		
			salida.println(lectoraABM.stringDeListaLectoras(lstLectora));
		
		} catch (Exception e){
			response.sendError(500, "Algo paso no se que" );
		}
		
	}
	protected void traerListaUltimosViajes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setStatus(200);
			PrintWriter salida = response.getWriter();
			TarjetaABM tarjetaABM = new TarjetaABM();
			MovimientoABM movimientoABM = new MovimientoABM();
			
			Tarjeta tarjeta = tarjetaABM.traerTarjetaConBeneficios(Integer.parseInt(request.getParameter("tarjeta")));
			
			List<Movimiento> lstMovimiento = movimientoABM.traerMovimientoCompletoPorTarjeta(tarjeta.getIdTarjeta());
			
			salida.println( "<!DOCTYPE 4.01 Transitional//EN\">" );
			salida.println( "<HTML>" );
			salida.println( " <HEAD>" );
			salida.println( " <TITLE>Sistema Suve</TITLE>" );
			salida.println( " </HEAD>" );
			salida.println( " <BODY>" );
			salida.println( " <table border=\"1\" style=\"width:75%\">" );
			if(tarjeta.getMonto() >= 0) {
				salida.println( " Saldo de la tarjeta: <label class=\"lblMontoVerde\">"+ tarjeta.getMonto() +"</label> " );
			} else {
				salida.println( " Saldo de la tarjeta: <label class=\"lblMontoRojo\">"+ tarjeta.getMonto() +"</label> " );
			}
			
				
			salida.println( " <tr>" );
			salida.println( " <th class=\"fila\">Fecha</th> " );
			salida.println( " <th class=\"fila\">Estacion</th> ");
			salida.println( " <th class=\"fila\"> Monto </th> ");
			salida.println( " <th class=\"fila\">R.S.</th> ");
			salida.println( " <th class=\"fila\">Descuentos</th> ");
			salida.println( " </tr> ");
			for(Movimiento m:lstMovimiento) {
				Lectora lec = m.getLectora();
				salida.println( " <th class=\"lblFecha\">"+Funciones.TraeFechaYHora(m.getFecha())+"</th> " );
				if(m.getLectora() instanceof LectoraColectivo) {
					salida.println( " <th>"+"Linea " +((LectoraColectivo) m.getLectora()).getTransporte().getLinea()+"</th> " );
				}
				else if(m.getLectora() instanceof LectoraEstacion) {
					salida.println( " <th>"+((LectoraEstacion)lec).getEstacion().getNombre()+"</th> " );
				}
				else if(m.getLectora() instanceof LectoraCarga) {
					salida.println( " <th>"+((LectoraCarga)lec).getEstacion().getNombre()+"</th> " );
				}
				if(m.getMonto()>=0 && m instanceof Boleto) {
					salida.println( " <th class=\"lblMontoRojo\">"+m.getMonto()+"</th> ");
				} else {
					salida.println( " <th class=\"lblMontoVerde\">"+m.getMonto()+"</th> ");
				}
				if(m instanceof Boleto) {
					salida.println( " <th>"+((Boleto)m).getIntRedSube()+"</th> ");
					salida.print( " <th class=\"lblFecha\">");

					Set<Beneficio> lbene = tarjeta.getBeneficios();
					if (lbene.size() > 0) {
						for(Beneficio b:lbene) {
							salida.print(b.getNombre()+" ");
						}
					}
					else {
						salida.print("---");
					}
					salida.print("</th> ");
				}
				else {
					salida.println( " <th>---</th> ");
					if(((Recarga)m).isEsBoletoEstudiantil())
						salida.println( " <th>Recarga de Boleto Estudiantil</th> ");
					else
						salida.println( " <th>---</th> ");
				}
				salida.println( " </tr> ");
			}
			salida.println( " </BODY>" );
			salida.println( "</HTML>" );
			
		} catch (Exception e){
			response.sendError(500, "Algo paso fdfsdf" );
		}
	}
}
