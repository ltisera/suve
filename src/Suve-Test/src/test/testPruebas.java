package test;

import dao.UsuarioDao;
import dao.TarjetaDao;
import datos.Usuario;
import datos.Tarjeta;

public class testPruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UsuarioDao udao = new UsuarioDao();
		TarjetaDao tdao = new TarjetaDao();
		
		Usuario user = new Usuario("Mathov","Camila",40946043,"cmathov@gmail.com","1234",false);
		Tarjeta tarj = new Tarjeta(0,false,false,user);
		
		udao.agregar(user);
		tdao.agregar(tarj);
	}

}
