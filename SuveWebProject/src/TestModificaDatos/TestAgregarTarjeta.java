package TestModificaDatos;

import dao.TarjetaDao;
import datos.Tarjeta;
import dao.UsuarioDao;
import datos.Usuario;

public class TestAgregarTarjeta {
	public static void main(String[] args) {
		
		TarjetaDao tdao = new TarjetaDao();
		tdao.agregar(new Tarjeta(78.5f,new Usuario("Lucas", "TOMAAA", 33, "wesa@gmail.com", "Chupala")));
	}
}
