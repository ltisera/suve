package TestModificaDatos;

import dao.UsuarioDao;
import dao.TarjetaDao;
import datos.Usuario;
import datos.Tarjeta;

public class testPruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UsuarioDao udao = new UsuarioDao();
		
		TarjetaDao tdao = new TarjetaDao();
		
		Usuario user = new Usuario("Camila","Mathov",40946043,"cmathov@gmail.com","1234");
		Tarjeta tarj = new Tarjeta(0,user);
		
		udao.agregar(user);
		tdao.agregar(tarj);
		System.out.println("Agregamo piola!");
		System.out.println(udao.traerUsuario((long)1).toString());
	}

}
