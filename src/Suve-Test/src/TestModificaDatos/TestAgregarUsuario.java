package TestModificaDatos;
import datos.Usuario;
import dao.UsuarioDao;

public class TestAgregarUsuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UsuarioDao udao = new UsuarioDao();
		Usuario u = new Usuario("Lucs", "apellido", 31794602, "email1", "1234");
		udao.agregar(u);

	}

}
