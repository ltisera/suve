package negocio;

import dao.UsuarioDao;
import datos.Usuario;

public class UsuarioABM {
	private UsuarioDao udao = new UsuarioDao();
	
	public Usuario traerUsuario(long id) {
		return udao.traerUsuario(id);
	}
	public Usuario traerUsuario(int dni) {
		return udao.traerUsuario(dni);
	}
	
	public Usuario comprobarPassword(String user, String pass) {
		Usuario u = this.traerUsuario(Integer.parseInt(user));
		if(u!=null && !u.getPassword().equals(pass)) {		
			//Si el usuario existe pero la contraseña es incorrecta devuelve un usuario nulo
			u = null;
		}
		return u;
	}
}
