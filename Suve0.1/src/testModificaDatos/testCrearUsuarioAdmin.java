package testModificaDatos;
import datos.TipoUsuario;
import negocio.*;
public class testCrearUsuarioAdmin {
	public static void main(String[] args) {
		UsuarioABM uabm = new UsuarioABM();
		uabm.crearUsuario("Lucas", "Tisera", 1234, "notego@gmail.com", "1234", TipoUsuario.Administrador);
	}
}
