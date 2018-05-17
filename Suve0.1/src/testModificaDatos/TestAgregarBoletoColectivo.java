package testModificaDatos;

import java.util.GregorianCalendar;

import org.hibernate.HibernateException;

import dao.LectoraDao;
import dao.SeccionViajeDao;
import dao.TramoColectivoDao;
import dao.TransporteDao;
import datos.LectoraColectivo;
import datos.SeccionViaje;
import datos.Tarjeta;
import datos.TipoTransporte;
import datos.TramoColectivo;
import datos.Transporte;
import negocio.AdminDeLectoras;
import negocio.TarjetaABM;

public class TestAgregarBoletoColectivo {

	public static void main(String[] args) 
	{
		AdminDeLectoras admLectora = new AdminDeLectoras();
		TransporteDao tdao = new TransporteDao();
		LectoraDao dao = new LectoraDao();
		SeccionViajeDao sdao = new SeccionViajeDao();
		TramoColectivoDao tcdao = new TramoColectivoDao();
		TarjetaABM tabm = new TarjetaABM();
		/*
		tdao.agregar(new Transporte("74", TipoTransporte.Colectivo));
		dao.agregar(new LectoraColectivo(tdao.traerTransporte(2l), 100101));
		sdao.agregar(new SeccionViaje("Seccion 1 Colectivo",9));
		tcdao.agregar(new TramoColectivo(0, 3, sdao.traerSeccionViaje(1l)));
		
		*/
		System.out.println("Agregar boleto de colectivo con la tarjeta 106 (inactiva): \n");
		try 
		{
			admLectora.agregarBoleto(100101, tabm.traerTarjetaConBeneficios(106), new GregorianCalendar(), tcdao.traerTramoColectivo(1l));//traerTarjetaConBeneficios esta devolviendo null. La consulta no esta funcionando.
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("Agregar boleto de colectivo con la tarjeta 102 (activa pero sin beneficios): \n");
		
		Tarjeta tarjeta101 = tabm.traerTarjetaConBeneficios(103);
		System.out.println(tarjeta101);
		tarjeta101.setActiva(true);//activo la tarjeta 101
		tabm.modificarTarjeta(tarjeta101);
		
		
		try 
		{
			admLectora.agregarBoleto(100101, tarjeta101, new GregorianCalendar(), tcdao.traerTramoColectivo(1l));
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println(tarjeta101);
		
		

	}

}
