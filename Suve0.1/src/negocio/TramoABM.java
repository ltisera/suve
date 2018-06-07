package negocio;

import java.util.List;

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
	
	public TramoColectivo traerTramoColectivo(String nombreTramo)
	{
		List<TramoColectivo> lstTramoColectivo = daoColectivo.traerTramoColectivo();
		TramoColectivo tramo = null;
		for(TramoColectivo tramoColectivo: lstTramoColectivo) 
		{
			if( nombreTramo.equals(tramoColectivo.toString()))
				tramo = tramoColectivo;
		}
		return tramo;
	}
	public List<TramoColectivo> traerTramoColectivo() 
	{
		return daoColectivo.traerTramoColectivo();
	}
	public String stringDeListaTramoColectivo(List<TramoColectivo> lstTramoColectivo) 
	{
		String listaTramos = "[";
		for (TramoColectivo t:lstTramoColectivo) {
			listaTramos += "\""+t+"\",";
		}
		
		listaTramos = listaTramos.substring(0, listaTramos.length()-1);
		return listaTramos +="]";
	}

}
