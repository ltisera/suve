package test;

import dao.TarjetaDao;
import datos.Tarjeta;
import dao.UsuarioDao;
import datos.Usuario;

public class TestAgregarTarjeta {
	public static void main(String[] args) {
		
		TarjetaDao tdao = new TarjetaDao();
		UsuarioDao udao = new UsuarioDao();
		Tarjeta t1 = new Tarjeta();
		t1.setSaldo((float)100.50);
		
		Usuario pass = udao.traerUsuario((long)1);
		
		t1.setUsuario(pass);
		
		tdao.agregar(t1);
		
		
	}
}
