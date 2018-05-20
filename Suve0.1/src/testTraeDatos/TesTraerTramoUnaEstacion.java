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
		
		Estacion estacionA = estDao.traerEstacion(1l);
		Estacion estacionB = estDao.traerEstacion(2l);
		
		
		
		
		TramoTrenYSubte tramo = tc.traerTramoUnaEstacion(estacionA.getIdEstacion());
		System.out.println(estacionA);
		System.out.println(estacionB);
		System.out.println(tramo);
		tramo = tc.traerTramoTrenYSubte(estacionA.getIdEstacion(), estacionB.getIdEstacion());
	}

}
