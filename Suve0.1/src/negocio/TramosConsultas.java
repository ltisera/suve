package negocio;

import dao.SeccionViajeDao;
import dao.TramoColectivoDao;
import dao.TramoTrenYSubteDao;
import datos.Estacion;
import datos.SeccionViaje;
import datos.TramoColectivo;
import datos.TramoTrenYSubte;

public class TramosConsultas 
{
	TramoColectivoDao daoColectivo = new TramoColectivoDao();
	TramoTrenYSubteDao daoTrenYSubte = new TramoTrenYSubteDao();
	SeccionViajeDao daoSeccion = new SeccionViajeDao();
	
	public TramoColectivo traerTramoColectivo(float kMin, float kMax)
	{
		return daoColectivo.traerTramoColectivo(kMin,kMax);
	}
	
	public TramoTrenYSubte traerTramoTrenYSubte(Estacion estacionA, Estacion estacionB)
	{
		return daoTrenYSubte.traerTramoTrenYSubte(estacionA,estacionB);
	}
	
	public TramoTrenYSubte traerTramoUnaEstacion(Estacion estacionA)
	{
		return daoTrenYSubte.traerTramoUnaEstacion(estacionA);
	}
	
/*
	public SeccionViaje traerSeccionSubte() 
	{
		return daoSeccion.traerSeccionSubte();
	}

	public SeccionViaje traerSeccionMaximaTren() 
	{
		return daoSeccion.traerSeccionMaximaTren();
	}
	*/
}
