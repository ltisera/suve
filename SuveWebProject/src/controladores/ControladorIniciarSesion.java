package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import datos.Usuario;
import dao.UsuarioDao;

public class ControladorIniciarSesion extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		procesarPeticion(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException 
	{
		procesarPeticion(request, response);
	}

	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html;charset=UTF-8");
		try {
			int dni = Integer.parseInt(request.getParameter("dni"));
			String password = request.getParameter("password");
			
			String mensaje="Contraseña Incorrecta !!!";
			
			UsuarioDao dao = new UsuarioDao();//enves de usar el dao, hay que usar la clase de negocio, pero todavia no la creamos.
			Usuario usuario = dao.traerUsuario(dni);
			
			response.setStatus(200);
			if(usuario.getPassword().equalsIgnoreCase(password)) mensaje = "Sesion Iniciada!";
			
			
			PrintWriter salida = response.getWriter();
			salida.println("");
			salida.println("<!DOCTYPE 4.01 Transitional//EN\">");
			salida.println("<HTML>");
			salida.println(" <HEAD>");
			salida.println(" <TITLE>Sistema Suve</TITLE>");
			salida.println(" </HEAD>");
			salida.println(" <BODY>");
			salida.println(mensaje+"<BR>");
			salida.println("<A href=\"/SuveWebProject/usuario.html\">Volver...</A>");
			salida.println(" </BODY>");
			salida.println("</HTML>");
		}
		catch (Exception e) 
		{
			PrintWriter salida = response.getWriter();
			salida.println("");
			salida.println("<!DOCTYPE 4.01 Transitional//EN\">");
			salida.println("<HTML>");
			salida.println(" <HEAD>");
			salida.println(" <TITLE>Sistema Suve</TITLE>");
			salida.println(" </HEAD>");
			salida.println(" <BODY>");
			salida.println("No encontre el usuario salame"+"<BR>");
			salida.println("<A href=\"/SuveWebProject/usuario.html\">Volver...</A>");
			salida.println(" </BODY>");
			salida.println("</HTML>");
		}
	}
}
