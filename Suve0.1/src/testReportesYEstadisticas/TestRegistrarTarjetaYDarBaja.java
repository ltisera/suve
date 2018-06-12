package testReportesYEstadisticas;

import dao.TarjetaDao;
import negocio.TarjetaABM;
import negocio.UsuarioABM;

public class TestRegistrarTarjetaYDarBaja {

	public static void main(String[] args) 
	{
		UsuarioABM usuarioABM = new UsuarioABM();
		TarjetaABM tarjetaABM = new TarjetaABM();
		TarjetaDao tarjetaDao = new TarjetaDao();
		
		/*
		System.out.println("\n dar de baja la tarjeta: "+tarjetaABM.traerTarjeta(108));
		
		try
		{
			tarjetaABM.darBaja(tarjetaABM.traerTarjeta(108));
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		System.out.println("\nTarjeta dada de baja: "+tarjetaABM.traerTarjeta(108));
		*/
		
		System.out.println("Ultima tarjeta activa del usuario: "+tarjetaDao.traerTarjetaActiva(usuarioABM.traerUsuario(80000018).getIdUsuario()));
		
		System.out.println("\nUsuario: "+usuarioABM.traerUsuario(80000018)+"\nRegistra la tarjeta: "+tarjetaABM.traerTarjeta(123));
		
		try
		{
			tarjetaABM.registrarTarjeta(tarjetaABM.traerTarjeta(123), usuarioABM.traerUsuario(80000018));
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		System.out.println("\nUsuario: "+usuarioABM.traerUsuario(80000018)+"\nRegistra la tarjeta: "+tarjetaABM.traerTarjeta(123));
		
	
		
		System.out.println(tarjetaDao.traerTarjetaActiva(usuarioABM.traerUsuario(80000018).getIdUsuario()));
	}

}
