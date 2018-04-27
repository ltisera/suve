package test;

import negocio.Administrador;
import datos.Tarjeta;
import dao.UsuarioDao;
import dao.TarjetaDao;
public class TestAsignarTarjeta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UsuarioDao udao = new UsuarioDao();
		TarjetaDao tdao = new TarjetaDao();
		Tarjeta sube123 = new Tarjeta((float) 174.5);

		//La tarjeta No esta en el sistema
		
		Administrador.asignarTarjeta(udao.traerUsuario((long)1),sube123);
	}

}
