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
import javassist.expr.Instanceof;
import negocio.Funciones;
import sun.security.jca.GetInstance.Instance;

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
			List<Movimiento> listmov = mdao.traerMovimientos();
			response.setStatus(200);
			PrintWriter salida = response.getWriter();
			salida.println( "<!DOCTYPE 4.01 Transitional//EN\">" );
			salida.println( "<HTML>" );
			salida.println( " <HEAD>" );
			salida.println( " <TITLE>Sistema Francés</TITLE>" );
			salida.println( " </HEAD>" );
			salida.println( " <BODY>" );
			salida.println( " <table border=\"1\" style=\"width:75%\">" );
			salida.println( " <tr>" );
			salida.println( " <th>Tipo de movimiento</th>" );
			salida.println( " <th>IDMovimiento</th> " );
			salida.println( " <th>Fecha y Hora</th> ");
			salida.println( " <th>Monto</th> ");
			salida.println( " </tr> ");
			
			for(Movimiento m: listmov) {
				salida.println( " <tr>" );
				if(m instanceof Recarga)
					salida.println( " <th>Recarga</th>" );
				else
					salida.println("<th>Movimiento</th>");
				salida.println( " <th>"+m.getIdMovimiento()+"</th> " );
				salida.println( " <th>"+Funciones.TraeFechaYHora(m.getFecha())+"</th> ");
				salida.println( " <th>"+m.getMonto()+"</th> ");
				salida.println( " </tr> ");
			}
			
			salida.println( " </BODY>" );
			salida.println( "</HTML>" );
		} catch (Exception e) {
			response.sendError(500, "Las Lista no cargo por que es jodida");
		}

		
	}

}
