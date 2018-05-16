package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.*;
import datos.*;

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		BuscaBoleto(request, response);
		//response.getWriter().append("Decime si anda papu!!!!: ").append(request.getContextPath());
	}
	
	private void BuscaBoleto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {
			MovimientoDao mdao = new MovimientoDao();
			long idBoleto = (long) Integer.parseInt(request.getParameter("boleto"));
			Boleto b = mdao.traerBoleto(idBoleto);
			response.setStatus(200);
			PrintWriter salida = response.getWriter();
			salida.println( "<!DOCTYPE 4.01 Transitional//EN\">" );
			salida.println( "<HTML>" );
			salida.println( " <HEAD>" );
			salida.println( " <TITLE>Sistema Francés</TITLE>" );
			salida.println( " </HEAD>" );
			salida.println( " <BODY>" );
			salida.println( " idBoleto: " +b.getIdMovimiento()+ "<BR>" );
			salida.println( " monto: " +b.getMonto()+ "<BR>" );
			salida.println( " fecha : " +negocio.Funciones.TraeFechaYHora(b.getFecha())+ "<BR>" );
			salida.println( " </BODY>" );
			salida.println( "</HTML>" );
			/* CODIGO QUE BUSCA LA LISTA DE Boletines
			MovimientoDao mdao =new MovimientoDao();
			long idBoleto = (long) Integer.parseInt(request.getParameter("boleto"));
			List<Boleto> lb = mdao.traerBoleto();
			PrintWriter salida = response.getWriter();
			
			for(Boleto b:lb) {
				salida.println(" **********SOY OTRO BOLETO********* ");
				salida.println(" idBoleto: "+b.getIdMovimiento());
				salida.println(" Te costo: "+b.getMonto());
				salida.println(" La lectora fue: "+b.getLectora().getIdLectora());
				
			}
			*/
			
		} catch (Exception e){
			response.sendError(500, "El ID del boleto no fue encontrado" );
		}
		
	}

}
