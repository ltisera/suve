package controladores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.TipoUsuario;
import datos.Usuario;
import negocio.UsuarioABM;

/**
 * Servlet implementation class ControladorDatosUsuario
 */
@WebServlet("/ControladorDatosUsuario")
public class ControladorDatosUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorDatosUsuario() {
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
		String opera = request.getParameter("operacion");
		if(opera.equals("Alta")) {
			procesaAlta(request, response);
		}
		if(opera.equals("Baja")) {
			procesaBaja(request, response);
		}
		if(opera.equals("Datos")) {
			procesaDatos(request, response);
		}	
	}
	protected void procesaAlta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dni = Integer.parseInt(request.getParameter("dni"));
		int numSerieTarjeta = Integer.parseInt(request.getParameter("numSerieTarjeta"));	
	}
	protected void procesaBaja(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numSerieTarjeta = Integer.parseInt(request.getParameter("numSerieTarjeta"));	
	}
	protected void procesaDatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dni = Integer.parseInt(request.getParameter("dni"));
		UsuarioABM uabm = new UsuarioABM();
		Usuario u = uabm.traerUsuario(dni);
		if(u!=null) {
			response.setContentType("application/json");
			String salidaJson="{";	
			salidaJson += "\"apellido\":" + "\""+u.getApellido()+"\",";
			salidaJson += "\"nombre\":" + "\""+u.getNombre()+"\",";
			salidaJson += "\"dni\":" + "\""+u.getDni()+"\",";
			salidaJson += "\"mail\":" + "\""+u.getMail()+"\",";
			//Preguntar si la tarjeta esta vacia o no
			PrintWriter salida = response.getWriter();
			salida.println(salidaJson);
			
			response.setStatus(200);//Usuario obtenido
		}
		else {
			response.setStatus(500);//Problemas al obtener usuario
		}
	}
}
