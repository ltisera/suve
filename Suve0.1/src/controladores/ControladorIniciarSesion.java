package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.TipoUsuario;
import datos.Usuario;
import negocio.UsuarioABM;

public class ControladorIniciarSesion extends HttpServlet{

	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procesaSolicitud(request, response);
	}
	
	protected void procesaSolicitud(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String user =request.getParameter("user");
		String pass =request.getParameter("pass");
		UsuarioABM uabm = new UsuarioABM();
		Usuario u = uabm.comprobarPassword(user, pass);
		
		response.setContentType("application/json");
		String salidaJson="{";
		
		if(u!=null) {
			
			PrintWriter salida = response.getWriter();
			if(u.getTipoUsuario() == TipoUsuario.Administrador) {
				salidaJson +="\"tipo\":" + "\"administrador\",";
			}
			if(u.getTipoUsuario() == TipoUsuario.Pasajero) {
				salidaJson +="\"tipo\":" + "\"pasajero\",";
			}
			salidaJson += "\"idUsuario\":" + "\""+u.getIdUsuario()+"\",";
			salidaJson += "\"nombre\":" + "\""+u.getNombre()+"\",";
			salidaJson += "\"apellido\":" + "\""+u.getApellido()+"\"}";
			salida.println(salidaJson);
			
			response.setStatus(200);//Usuario y contraseña correctos
		}
		else {
			response.setStatus(500);//Usuario y/o contraseña incorrectos
		}
	}
}
