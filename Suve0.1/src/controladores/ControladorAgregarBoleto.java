package controladores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;

import datos.Boleto;
import datos.Tarjeta;

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
		
		float montoSD =0;
		float montoCobrado = b.getMonto();
		System.out.println("MIRA MI MONTO: " + b.getMonto() + " Y Red SUBE:" +b.getPorcentajeRedSube()+"%");
		LectoraABM unalec = new LectoraABM();
		Boleto bAnterior = unalec.traerBoletoAnterio(t);
		
		if(b.getMonto()>0) {
			montoSD = montoCobrado / ((100 - b.getPorcentajeRedSube())/100);
			
			//Calcula el precio del boleto sin los descuentos
			
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
			salida.println("<div id=\"divEstadoBoletoSup\">");
			salida.println("<label id=\"lblCalculaBoleto\"><br>");
			salida.println("Valor del boleto sin red sube: "+b.getMonto()+"$<br>");
			salida.println("Red Sube actual: "+b.getPorcentajeRedSube()+"%");
			salida.println("<br>Porcentaje Tarifa social: "+"HQVQLP"+"<br>");
			salida.println("</label>");
			salida.println("</div>");
			salida.println("<div id=\"divEstadoBoletoInf\">");
			salida.println("<div id=\"divMostrarBoleto1\">");
			salida.println("<div>Valor Sin Descuento</div>");
			salida.println("<div>"+montoSD+"</div>");
			salida.println("</div>");
			salida.println("<div id=\"divMostrarBoleto2\">");
			salida.println("<div>Valor Final</div>");
			salida.println("<div>"+b.getMonto()+"</div>");
			salida.println("</div>");
			salida.println("<div id=\"divMostrarBoleto3\">");
			salida.println("<div>Relleno</div>");
			salida.println("<div>100pE</div>");
			salida.println("</div>");
			salida.println("</div>");
			salida.println("");
		}
		else 
		{
			float valorFinal = bAnterior.getMonto()+b.getMonto();
			montoSD = valorFinal / ((100 - b.getPorcentajeRedSube())/100);
			
			salida.println("<div id=\"divEstadoBoletoSup\">");
			salida.println("<label id=\"lblCalculaBoleto\"><br>");
			salida.println("ESTO ES DEVOLUCION<br>");
			salida.println("Valor del boleto sin red sube: "+montoSD+"$<br>");
			salida.println("Red Sube actual: "+b.getPorcentajeRedSube()+"%");
			salida.println("<br>Porcentaje Tarifa social: "+"HQVQLP"+"<br>");
			salida.println("</label>");
			salida.println("</div>");
			salida.println("<div id=\"divEstadoBoletoInf\">");
			salida.println("<div id=\"divMostrarBoleto1\">");
			salida.println("<div>Valor Sin Descuento</div>");
			salida.println("<div>"+montoSD+"</div>");
			salida.println("</div>");
			salida.println("<div id=\"divMostrarBoleto2\">");
			salida.println("<div>Valor Final</div>");
			salida.println("<div>"+valorFinal+"</div>");
			salida.println("</div>");
			salida.println("<div id=\"divMostrarBoleto3\">");
			salida.println("<div>Relleno</div>");
			salida.println("<div>100pE</div>");
			salida.println("</div>");
			salida.println("</div>");
			salida.println("");
		}
	}
	

}
