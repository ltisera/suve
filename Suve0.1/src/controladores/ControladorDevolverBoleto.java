package controladores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import datos.*;
import negocio.MovimientoABM;

/**
 * Servlet implementation class DevolverBoleto
 */
@WebServlet("/DevolverBoleto")
public class ControladorDevolverBoleto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorDevolverBoleto() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BuscaBoleto(request, response);
	}
	
	private void BuscaBoleto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {
			MovimientoABM movimientoABM = new MovimientoABM();
			long idBoleto = (long) Integer.parseInt(request.getParameter("boleto"));
			Boleto boleto = (Boleto) movimientoABM.traerMovimiento(idBoleto);
			response.setStatus(200);
			PrintWriter salida = response.getWriter();
			salida.println( "<!DOCTYPE 4.01 Transitional//EN\">" );
			salida.println( "<HTML>" );
			salida.println( " <HEAD>" );
			salida.println( " <TITLE>Sistema Suve</TITLE>" );
			salida.println( " </HEAD>" );
			salida.println( " <BODY>" );
			salida.println( " idBoleto: " +boleto.getIdMovimiento()+ "<BR>" );
			salida.println( " monto: " +boleto.getMonto()+ "<BR>" );
			salida.println( " fecha : " +negocio.Funciones.TraeFechaYHora(boleto.getFecha())+ "<BR>" );
			salida.println( " </BODY>" );
			salida.println( "</HTML>" );
			
		} catch (Exception e){
			response.sendError(500, "El ID del boleto no fue encontrado" );
		}
		
	}

}
