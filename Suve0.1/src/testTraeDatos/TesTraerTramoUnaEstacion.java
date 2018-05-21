package testTraeDatos;

import dao.EstacionDao;
import dao.LectoraDao;
import dao.SeccionViajeDao;
import dao.TramoTrenYSubteDao;
import datos.Estacion;
import datos.TramoTrenYSubte;
import negocio.TramosConsultas;

public class TesTraerTramoUnaEstacion {

	public static void main(String[] args) 
	{
		TramosConsultas tc = new TramosConsultas();
		EstacionDao estDao = new EstacionDao();
		TramoTrenYSubteDao tcdao = new TramoTrenYSubteDao();
		LectoraDao dao = new LectoraDao();
		SeccionViajeDao sdao = new SeccionViajeDao();
		
		Estacion estacionA = estDao.traerEstacion(3l);
		Estacion estacionB = estDao.traerEstacion(3l);
		
		//tcdao.agregar(new TramoTrenYSubte(estacionA,null,sdao.traerSeccionViaje(3l)));
		
		
		//TramoTrenYSubte tramo = tc.traerTramoTrenYSubte(estacionB, estacionA);
		TramoTrenYSubte tramo = tc.traerTramoUnaEstacion(estacionA.getIdEstacion());
		System.out.println("BIEN");
		//System.out.println(tramo);
		System.out.println("Esto te sale el tobole: " + tramo);
		//tramo = tc.traerTramoTrenYSubte(estacionA.getIdEstacion(), estacionB.getIdEstacion());
	}

}
