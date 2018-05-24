package testModificaDatos;

import java.util.GregorianCalendar;

import dao.BeneficioDao;
import dao.EstacionDao;
import dao.LectoraDao;
import dao.SeccionViajeDao;
import dao.TramoTrenYSubteDao;
import dao.TransporteDao;
import negocio.AdminDeLectoras;
import negocio.TarjetaABM;
import datos.Transporte;
import datos.Estacion;
import datos.Lectora;
import datos.LectoraEstacion;
import datos.SeccionViaje;
import datos.TarifaSocial;
import datos.Tarjeta;
import datos.TipoTransporte;
import datos.TramoTrenYSubte;
import datos.Beneficio;

public class TestAgregarBoletoSubte {

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
		
		
		/*
		beneficioDao.agregar(new TarifaSocial("Tarfia Social", 55f));
		tdao.agregar(new Transporte("Subte C", TipoTransporte.Subte));
		estDao.agregar(new Estacion(tdao.traerTransporte(3l), "Constitucion (subte)"));
		dao.agregar(new LectoraTrenYSubte(estDao.traerEstacion(2l), 101202));
		sdao.agregar(new SeccionViaje("Seccion Subte",11));
		tcdao.agregar(new TramoTrenYSubte(dao.traerLectoraTrenYSubte(101202).getEstacion(), null, sdao.traerSeccionViaje(2l)));
		*/
		/*
		Tarjeta tarjeta = tabm.traerTarjetaConBeneficios(109);
		tarjeta.setActiva(true);
		tarjeta.getBeneficios().add(tabm.traerTarifaSocial());
		tabm.modificarTarjeta(tarjeta);
		*/
		System.out.println("\n\nSaldo = "+tabm.traerTarjetaConBeneficios(109).getMonto()+"\n");
		
		System.out.println("\nAgregar boleto de Subte con la tarjeta 109\n");
		
		try 
		{
			admLectora.agregarBoleto(101202, tabm.traerTarjetaConBeneficios(109), new GregorianCalendar());
		} catch (Exception e) 
		{
			System.out.println(e);
		}
		
		System.out.println("\n\nSaldo = "+tabm.traerTarjetaConBeneficios(109).getMonto()+"\n");
		
	}

}
