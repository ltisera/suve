package controladores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;

import dao.BeneficioDao;
import datos.Boleto;
import datos.LectoraColectivo;
import datos.LectoraEstacion;
import datos.Tarjeta;
import datos.TipoTransporte;

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
			//Entra en caso de ser Colectivo
			try 
			{
				if(request.getParameter("operacion").equals("previsualizar")) {
					Boleto b = lectoraABM.previsualizarBoleto(lectoraABM.traerLectoraColectivo(numSerieLectora),tarjetaABM.traerTarjetaConBeneficios(numSerieTarjeta), fechaHora, tramoABM.traerTramoColectivo(request.getParameter("estacion")));
					procesaPrevisualizar(request, response, b, tarjetaABM.traerTarjetaConBeneficios(numSerieTarjeta));
				}
				if(request.getParameter("operacion").equals("agregar")) {
					lectoraABM.agregarBoleto(lectoraABM.traerLectoraColectivo(numSerieLectora),tarjetaABM.traerTarjetaConBeneficios(numSerieTarjeta), fechaHora, tramoABM.traerTramoColectivo(request.getParameter("estacion")));
				}
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
			//Entra en caso de ser Tren o Subte
			try 
			{
				if(request.getParameter("operacion").equals("previsualizar")) {
					Boleto b = lectoraABM.previsualizarBoleto(lectoraABM.traerLectoraEstacion(numSerieLectora),tarjetaABM.traerTarjetaConBeneficios(numSerieTarjeta), fechaHora);
					procesaPrevisualizar(request, response, b, tarjetaABM.traerTarjetaConBeneficios(numSerieTarjeta));
				}
				if(request.getParameter("operacion").equals("agregar")) {
					lectoraABM.agregarBoleto(lectoraABM.traerLectoraEstacion(numSerieLectora),tarjetaABM.traerTarjetaConBeneficios(numSerieTarjeta), fechaHora);
				}
				response.setStatus(200);
			}
			catch (Exception e)
			{
				response.setStatus(500);
				salida.println(e.getMessage());
			}
		}
	}
	
	protected void procesaPrevisualizar(HttpServletRequest request, HttpServletResponse response, Boleto b, Tarjeta t) throws ServletException, IOException{
		
		
		PrintWriter salida = response.getWriter();
		BeneficioDao bendao = new BeneficioDao();
		LectoraABM unalec = new LectoraABM();
		TarjetaABM tarabm = new TarjetaABM();
		TramoABM tramoabm = new TramoABM();
		Boleto bAnterior = unalec.traerBoletoAnterio(t);
		
		float montoCobrado = b.getMonto();
		float montoSINDESC = 0;
		boolean esSalida = false;
		
		if (b.getMonto()<0) {
			esSalida =true;
		}
		
		if(b.getLectora() instanceof LectoraEstacion) {
			if(esSalida) {
				montoCobrado = bAnterior.getMonto()+b.getMonto();		
			}
		}
		
		if(b.getLectora() instanceof LectoraEstacion) {
			montoSINDESC = b.getTramoTrenYSubte().getSeccionViaje().getMonto();
		}
		if(b.getLectora() instanceof LectoraColectivo) {
			montoSINDESC = b.getTramoColectivo().getSeccionViaje().getMonto();
		}
		
		
		salida.println("<div id=\"divEstadoBoletoSup\">");
		salida.println("<label id=\"lblCalculaBoleto\"><br>");
		if(esSalida) {
			salida.println("ESTO ES DEVOLUCION<br>");
		}
		salida.println("Valor del boleto sin red sube: "+montoSINDESC+"$<br>");
		salida.println("Red Sube actual: "+b.getPorcentajeRedSube()+"%");
		salida.println("<br>Porcentaje Tarifa social: "+bendao.traerTarifaSocial().getPorcentajeDescuento()+"%<br>");
		salida.println("</label>");
		salida.println("</div>");
		salida.println("<div id=\"divEstadoBoletoInf\">");
		salida.println("<div id=\"divMostrarBoleto1\">");
		salida.println("<div>Valor Sin Descuento</div>");
		salida.println("<div>"+montoSINDESC+"</div>");
		salida.println("</div>");
		salida.println("<div id=\"divMostrarBoleto2\">");
		salida.println("<div>Valor Final</div>");
		salida.println("<div>"+montoCobrado+"</div>");
		salida.println("</div>");
		/*salida.println("<div id=\"divMostrarBoleto3\">");
		salida.println("<div>Relleno</div>");
		salida.println("<div>100pE</div>");
		salida.println("</div>");*/
		salida.println("</div>");
		salida.println("");
	}
	

}
/***
*
<div id="divEstadoBoletoSup">
			<label id="lblCalculaBoleto">
				<br>
				Valor del boleto sin red sube: 000.10$<br>
				red Sube actual: 3(75%)<br>
				Porcentaje Tarifa social: --<br>

			</label>
		</div>
		<div id="divEstadoBoletoInf">
			<div id="divMostrarBoleto1">
				
				<div>Valor Sin Descuento</div>
				<div>100pE</div>
				
			</div>
			<div id="divMostrarBoleto2">
				<div>Valor Sin Descuento</div>
				<div>100pE</div>
			</div>
			<div id="divMostrarBoleto3">
				<div>Valor Sin Descuento</div>
				<div>100pE</div>
			</div>
		</div>
*/