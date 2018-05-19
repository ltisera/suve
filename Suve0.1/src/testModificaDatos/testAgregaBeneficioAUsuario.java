package testModificaDatos;

import dao.BeneficioDao;
import dao.UsuarioDao;
import datos.Beneficio;
import datos.Usuario;
import java.util.Set;
public class testAgregaBeneficioAUsuario {
	public static void main(String[] args) {
		UsuarioDao udao = new UsuarioDao();
		BeneficioDao bdao = new BeneficioDao();
		
		Usuario u = udao.traerUsuario(5l);
		u.getBeneficios().add(bdao.traerBeneficio(3l));
		
		udao.actualizar(u);
		
	}
}
