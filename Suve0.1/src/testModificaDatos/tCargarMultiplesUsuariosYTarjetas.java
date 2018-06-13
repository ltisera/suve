package testModificaDatos;

import dao.*;
import datos.*;

public class tCargarMultiplesUsuariosYTarjetas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UsuarioDao udao = new UsuarioDao();
		TarjetaDao tardao = new TarjetaDao();
		
		for(int i = 1; i < 20; i++){
			Usuario u = new Usuario("Soy Juancito"+i, "Pepe Garcia", 80000000+i, "tengomail"+i+"@gmail.com", "1234", TipoUsuario.Pasajero);
			udao.agregar(u);
			float monto = (float) Math.random() * 100;
			Tarjeta t = new Tarjeta(monto, u,100+i);
			t.setActiva(true);
			tardao.agregar(t);
			
		}
	}

}
