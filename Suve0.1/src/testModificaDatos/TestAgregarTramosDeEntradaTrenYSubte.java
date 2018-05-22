package testModificaDatos;

import java.util.List;

import dao.EstacionDao;
import dao.SeccionViajeDao;
import dao.TramoTrenYSubteDao;
import datos.Estacion;
import datos.SeccionViaje;
import datos.TipoTransporte;
import datos.TramoTrenYSubte;

public class TestAgregarTramosDeEntradaTrenYSubte {

	public static void main(String[] args) 
	{
		TramoTrenYSubteDao tdao = new TramoTrenYSubteDao();
		EstacionDao edao = new EstacionDao();
		SeccionViajeDao sdao = new SeccionViajeDao();
		
		List<Estacion> estacionesTren = edao.traerEstacionPorTipoTransporte(TipoTransporte.Tren);
		List<Estacion> estacionesSubte = edao.traerEstacionPorTipoTransporte(TipoTransporte.Subte);
		
		
		for(Estacion et: estacionesTren)
				tdao.agregar(new TramoTrenYSubte(et,null,sdao.traerSeccionViaje(4l)));	
		
		for(Estacion es: estacionesSubte)
				tdao.agregar(new TramoTrenYSubte(es,null,sdao.traerSeccionViaje(1l)));
		

	}

}
