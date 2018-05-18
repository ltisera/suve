package controladores;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

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
		System.out.println(request.getParameter("pedirLista"));
		if(!request.getParameter("pedirLista").equals("da")){
			procesaSolicitud(request, response);
		}
		else {
			response.setStatus(200);
			PrintWriter salida = response.getWriter();
			List<String> lalista = new ArrayList<>();
			lalista.add("Roca");
			lalista.add("LineaC");
			lalista.add("506");
			
			
			salida.println("var opcion = document.createElement(\"option\");\r\n" + 
					"				opcion.text = \"Banana\";\r\n" + 
					"			    $(\"#inpTipoTransporte\").append(opcion);");
			
			System.out.println("Ahora Falta mandar la lista");
		}
	}
	protected void procesaSolicitud(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int numTarjeta = Integer.parseInt(request.getParameter("numTarjeta"));
		System.out.println(numTarjeta);
		
		
		System.out.println((request.getParameter("tipoTransporte")));
		
	}
	
	

}
