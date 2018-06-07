package negocio;

import java.util.List;

import dao.EstacionDao;
import datos.Estacion;

public class EstacionABM 
{
	EstacionDao estacionDao = new EstacionDao();

	public List<Estacion> traerEstacionPorTransporte(long idTransporte) 
	{
		return estacionDao.traerEstacionPorTransporte(idTransporte);
	}

	public String stringListaNombresDeEstaciones(List<Estacion> lstEstacion) 
	{
		String listaNombres = "[";
		for (Estacion e:lstEstacion) {
			listaNombres += "\""+e.getNombre()+"\",";
		}
		
		listaNombres = listaNombres.substring(0, listaNombres.length()-1);
		return listaNombres +="]";
	}

	public Estacion traerEstacion(String estacion) 
	{
		return estacionDao.traerEstacion(estacion);
	}

	
	

}
