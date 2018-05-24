package testModificaDatos;

import java.util.GregorianCalendar;

import dao.BeneficioDao;
import dao.EstacionDao;
import dao.LectoraDao;
import dao.SeccionViajeDao;
import dao.TramoTrenYSubteDao;
import dao.TransporteDao;
import datos.Estacion;
import datos.LectoraEstacion;
import datos.SeccionViaje;
import datos.Tarjeta;
import datos.TramoTrenYSubte;
import negocio.AdminDeLectoras;
import negocio.TarjetaABM;

public class TestAgregarBoletoTren {

	public static void main(String[] args) 
	{
		AdminDeLectoras admLectora = new AdminDeLectoras();
		TransporteDao tdao = new TransporteDao();
		EstacionDao estDao = new EstacionDao();
		BeneficioDao beneficioDao = new BeneficioDao();
		LectoraDao dao = new LectoraDao();
		SeccionViajeDao sdao = new SeccionViajeDao();
		TramoTrenYSubteDao tcdao = new TramoTrenYSubteDao();
		TarjetaABM tabm = new TarjetaABM();
		
		Tarjeta tarjeta = tabm.traerTarjetaConBeneficios(117);
		tarjeta.setActiva(true);
		tabm.modificarTarjeta(tarjeta);
		
		System.out.println("\n\nSaldo = "+tabm.traerTarjetaConBeneficios(117).getMonto()+"\n");
		
		System.out.println("\nBoleto Tren de ENTRADA en Banfield(lectora 101202) con la tarjeta 117\n");
		
		try 
		{
			admLectora.agregarBoleto(101202, tabm.traerTarjetaConBeneficios(117), new GregorianCalendar());
		} catch (Exception e) 
		{
			System.out.println(e);
		}
		
		System.out.println("\n\nSaldo = "+tabm.traerTarjetaConBeneficios(117).getMonto()+"\n");
		
		System.out.println("\nBoleto Tren de SALIDA en Glew(lectora 3331234) con la tarjeta 117\n");
		
		try 
		{
			admLectora.agregarBoleto(3331234, tabm.traerTarjetaConBeneficios(117), new GregorianCalendar());
		} catch (Exception e) 
		{
			System.out.println(e);
		}
		
		System.out.println("\n\nSaldo = "+tabm.traerTarjetaConBeneficios(117).getMonto()+"\n");
		
	}

}
