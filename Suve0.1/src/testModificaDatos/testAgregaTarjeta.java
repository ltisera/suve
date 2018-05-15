package testModificaDatos;

import datos.*;
import dao.*;

public class testAgregaTarjeta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TarjetaDao tardao = new TarjetaDao();
		UsuarioDao udao = new UsuarioDao();
		Usuario u = new Usuario("La camseri", "Vfeiajera", 1215, "YOnoTegnoMail", "puto", TipoUsuario.Administrador);
		u.setTipoUsuario(TipoUsuario.Pasajero);
		udao.agregar(u);
		tardao.agregar(new Tarjeta(10,u,1001));
		System.out.println("Kabloom");
	}

}
