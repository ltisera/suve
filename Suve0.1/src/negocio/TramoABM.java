package negocio;

import dao.TramoColectivoDao;
import dao.TramoTrenYSubteDao;
import datos.TramoColectivo;
import datos.TramoTrenYSubte;

public class TramoABM 
{
	TramoColectivoDao daoColectivo = new TramoColectivoDao();
	TramoTrenYSubteDao daoTrenYSubte = new TramoTrenYSubteDao();
	
	public TramoColectivo traerTramoColectivo(float kMin, float kMax)
	{
		return daoColectivo.traerTramoColectivo(kMin,kMax);
	}
	public TramoTrenYSubte traerTramoTrenYSubte(long idEstacionA, long idEstacionB)
	{
		return daoTrenYSubte.traerTramoTrenYSubte(idEstacionA, idEstacionB);
	}
	
	public TramoTrenYSubte traerTramoTrenYSubte(long idEstacionA)
	{
		return daoTrenYSubte.traerTramoTrenYSubte(idEstacionA);
	}

}
