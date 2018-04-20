package TestModificaDatos;

import datos.Usuario;
import dao.UsuarioDao;

public class TestActualizarUsuario {
	public static void main(String[] args) {
		UsuarioDao udao = new UsuarioDao();
		Usuario u = udao.traerUsuario((long)2);
		udao.actualizar(u);
		
	}
}
