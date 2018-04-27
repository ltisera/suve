package test;

import negocio.Administrador;
import datos.Tarjeta;
import dao.UsuarioDao;
public class TestAdminAgregaTarjeta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UsuarioDao udao = new UsuarioDao();
		System.out.println(udao.traerUsuario((long)1).getTarjetas());
		System.out.println("PUNCH");
		Tarjeta sube123 = new Tarjeta(10,udao.traerUsuario((long)1));
		
		Administrador.asignarTarjeta(udao.traerUsuario((long)1),sube123);
	}

}
