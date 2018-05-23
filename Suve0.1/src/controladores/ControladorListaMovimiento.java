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
import negocio.Funciones;

import java.util.List;

/**
 * Servlet implementation class ControladorListaMovimiento
 */
@WebServlet("/ControladorListaMovimiento")
public class ControladorListaMovimiento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorListaMovimiento() {
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
		
		BuscarMovimientos(request, response);
	}
	
	private void BuscarMovimientos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {
			MovimientoDao mdao = new MovimientoDao();
			
			List<Movimiento> listmov = null;
			System.out.println(request.getParameter("tarjeta"));
			if(request.getParameter("tarjeta").equals("")) {
				//Imprime los movimientos Completos
				listmov = mdao.traerMovimientos();
			} 
			else{
				//Imprime los movimientos de una tarjeta
				TarjetaDao tardao = new TarjetaDao();
				listmov = mdao.traerMovimientosPorTarjeta(tardao.traerTarjeta(Integer.parseInt(request.getParameter("tarjeta"))).getIdTarjeta());
				System.out.println("la tarjeta que buscamos es:" + (long)Integer.parseInt(request.getParameter("tarjeta")) +"el size: " + listmov.size());
			}
			
			response.setStatus(200);
			PrintWriter salida = response.getWriter();
			salida.println( "<!DOCTYPE 4.01 Transitional//EN\">" );
			salida.println( "<HTML>" );
			salida.println( " <HEAD>" );
			salida.println( " <TITLE>Sistema Suve</TITLE>" );
			salida.println( " </HEAD>" );
			salida.println( " <BODY>" );
			salida.println( " <table border=\"1\" style=\"width:75%\">" );
			salida.println( " <tr>" );
			salida.println( " <th>IDMovimiento</th>" );
			salida.println( " <th>Transporte</th> " );
			salida.println( " <th>Linea</th> ");
			salida.println( " <th>Estacion/Tramo</th> ");
			salida.println( " <th>Fecha</th> ");
			salida.println( " <th>Monto</th> ");
			salida.println( " <th>RedSube</th> ");
			salida.println( " <th>Descuentos</th> ");
			salida.println( " </tr> ");
			
			
			for(Movimiento m: listmov) {
				salida.println( " <tr>" );
				if(m instanceof Recarga) {
					salida.println( " <th>"+m.getIdMovimiento()+":Recarga</th>" );//Id Movimiento
					salida.println( " <th></th>" );//Transporte
				}
				
				else {
					salida.println("<th>"+m.getIdMovimiento()+":Boleto</th>");
					Lectora lec = m.getLectora();
					System.out.println("Es LecColetivo" + (m.getLectora() instanceof LectoraTrenYSubte));
					if(m.getLectora() instanceof LectoraColectivo) {
						System.out.println("QUE CARAJO:" +((LectoraColectivo)lec).getTransporte().getIdTransporte());
						salida.println( " <th>"+((LectoraColectivo)lec).getTransporte().getIdTransporte()+"</th> " );
					}
					System.out.println("Es LecTYS" + (m.getLectora() instanceof LectoraTrenYSubte));
					if(m.getLectora() instanceof LectoraTrenYSubte) {
						System.out.println("QUE CARAJO:" +((LectoraTrenYSubte)lec).getEstacion().getTransporte().getTipoTransporte());
						salida.println( " <th>"+((LectoraTrenYSubte)lec).getEstacion().getTransporte().getTipoTransporte()+"</th> " );
					}
				salida.println( " <th>"+Funciones.TraeFechaYHora(m.getFecha())+"</th> ");
				salida.println( " <th>"+m.getMonto()+"</th> ");
				salida.println( " </tr> ");
				}
			}
			salida.println( " </BODY>" );
			salida.println( "</HTML>" );
		} catch (Exception e) {
			response.sendError(500, "Las Lista no cargo por que es jodida");
		}

	}	
}


