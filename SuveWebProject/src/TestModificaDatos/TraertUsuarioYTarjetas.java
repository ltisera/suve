package TestModificaDatos;

import dao.TarjetaDao;
import datos.Tarjeta;
import dao.UsuarioDao;
import datos.Usuario;

public class TraertUsuarioYTarjetas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UsuarioDao udao = new UsuarioDao();
		
		Usuario user1 = udao.traerUsuarioYTarjeta((long)1);
		System.out.println("Usser name: " + user1.getNombre());
		System.out.println("Tarjetas de " + user1.getNombre());
		System.out.println(user1.getTarjetas().toString());
	}

}
