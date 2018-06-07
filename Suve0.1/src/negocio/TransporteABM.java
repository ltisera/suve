package negocio;

import java.util.List;


import dao.TransporteDao;
import datos.TipoTransporte;
import datos.Transporte;

public class TransporteABM 
{
	TransporteDao transporteDao = new TransporteDao();

	public List<Transporte> traerLineasPorTransporte(TipoTransporte tipoTransporte) 
	{
		return transporteDao.traerLineasPorTransporte(tipoTransporte);
	}

	public String stringListaDeNombresDeLineas(List<Transporte> lstTransporte) 
	{
		String listaDeNombres = "[";
		for (Transporte t:lstTransporte) {
			listaDeNombres += "\""+t.getLinea()+"\",";
		}
		listaDeNombres = listaDeNombres.substring(0, listaDeNombres.length()-1);
		return listaDeNombres +="]";
	}

	public Transporte traerTransporte(String linea) 
	{
		return transporteDao.traerTransporte(linea);
	}

}
