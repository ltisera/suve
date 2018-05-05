package testModificaDatos;
import dao.UsuarioDao;
import datos.TipoUsuario;
import datos.Usuario;
public class testAgregaUsuarioS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Que onda");
		UsuarioDao udao = new UsuarioDao();
		Usuario u = new Usuario("La cami", "Viajera", 1213, "noTegnoMail", "puto", TipoUsuario.Administrador);
		u.setTipoUsuario(TipoUsuario.Pasajero);
		udao.agregar(u);
		System.out.println("Que onda");
	}

}
