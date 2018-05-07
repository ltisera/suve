package testTraeDatos;

import dao.UsuarioDao;

public class testTraerUsuriao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UsuarioDao udao = new UsuarioDao();
		System.out.println(udao.traerUsuario());
	}

}
