package negocio;

import dao.UsuarioDao;
import datos.TipoUsuario;
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
		Usuario u = null;
		if(!user.isEmpty() && !pass.isEmpty()) {
			//Si el usuario o contraseñas pasadas por parametros estan vacios no entra
			u = this.traerUsuario(Integer.parseInt(user));
			if(u!=null && !u.getPassword().equals(pass)) {		
				//Si el usuario existe pero la contraseña es incorrecta devuelve un usuario nulo
				u = null;
			}
		}
		return u;
	}
	
	public void crearUsuario(String nombre, String apellido, int dni, String mail, String password, TipoUsuario tipoUsuario) {
		udao.agregar(new Usuario(nombre, apellido, dni, mail, password, tipoUsuario));
	}
}
