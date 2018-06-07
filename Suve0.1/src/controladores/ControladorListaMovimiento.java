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
import negocio.MovimientoABM;

import java.util.List;
import java.util.Set;

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
		PrintWriter salida = response.getWriter();
		try {
			MovimientoABM movimientoABM = new MovimientoABM();
			
			List<Movimiento> listmov = null;
			TarjetaDao tardao = new TarjetaDao();
			if(request.getParameter("tarjeta").equals("")) {
				//Imprime los movimientos Completos
				listmov = movimientoABM.traerMovimientoCompleto();
			} 
			else{
				//Imprime los movimientos de una tarjeta
				listmov = movimientoABM.traerMovimientoCompletoPorTarjeta(tardao.traerIdTarjeta(Integer.parseInt(request.getParameter("tarjeta"))));			
			}
			response.setStatus(200);
			salida.println( "<!DOCTYPE 4.01 Transitional//EN\">" );
			salida.println( "<HTML>" );
			salida.println( " <HEAD>" );
			salida.println( " <TITLE>Sistema Suve</TITLE>" );
			salida.println( " </HEAD>" );
			salida.println( " <BODY>" );
			salida.println( " <table border=\"1\" style=\"width:75%\">" );
			salida.println( " <tr>" );
			salida.println( " <th>Fecha</th> ");
			if(request.getParameter("tarjeta").equals(""))
				salida.println( " <th>Tarjeta</th>" );
			salida.println( " <th>IDMovimiento</th>" );
			salida.println( " <th>Transporte</th> " );
			salida.println( " <th>Linea</th> ");
			salida.println( " <th>Estacion</th> ");
			salida.println( " <th>Monto</th> ");
			salida.println( " <th>RedSube</th> ");
			salida.println( " <th>Descuentos</th> ");
			salida.println( " </tr> ");
			for(Movimiento m: listmov) {
				salida.println( " <tr>" );
				//Fecha
				salida.println( " <th>"+Funciones.TraeFechaYHora(m.getFecha())+"</th> ");
				//IDTarjeta
				if(request.getParameter("tarjeta").equals("")) {
					salida.println( " <th>"+m.getTarjeta().getNumeroSerieTarjeta()+"</th>" );
				}
				//IDMovimiento
				if(m instanceof Recarga) {
					salida.println( " <th>"+m.getIdMovimiento()+":Recarga</th>" );
				}
				else {
					salida.println("<th>"+m.getIdMovimiento()+":Boleto</th>");
				}
				Lectora lec = m.getLectora();
				if(m.getLectora() instanceof LectoraColectivo) {
					//Transporte
					salida.println( " <th>"+((LectoraColectivo)lec).getTransporte().getTipoTransporte()+"</th> " );
					//Linea
					salida.println( " <th>"+((LectoraColectivo)lec).getTransporte().getLinea()+"</th> " );
					//Estacion/Tramo
					salida.println( " <th>"+((Boleto)m).getTramoColectivo().toString()+"</th> " );
				}
				if(m.getLectora() instanceof LectoraEstacion) {
					//Transporte
					salida.println( " <th>"+((LectoraEstacion)lec).getEstacion().getTransporte().getTipoTransporte()+"</th> " );
					//Linea
					salida.println( " <th>"+((LectoraEstacion)lec).getEstacion().getTransporte().getLinea()+"</th> " );
					//Estacion/Tramo
					salida.println( " <th>"+((LectoraEstacion)lec).getEstacion().getNombre()+"</th> " );

				}
				//Monto
				salida.println( " <th>"+m.getMonto()+"</th> ");
				//RedSube y beneficios
				if(m instanceof Boleto) {
					salida.println( " <th>"+((Boleto)m).getIntRedSube()+"</th> ");
					salida.print( " <th>");
					Set<Beneficio> lbene = m.getTarjeta().getBeneficios();
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
		} catch (Exception e) {
			response.sendError(500);
			salida.println(e.getMessage());
		}

	}	
}


