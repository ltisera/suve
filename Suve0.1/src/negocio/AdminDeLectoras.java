package negocio;

import dao.LectoraDao;

public class AdminDeLectoras 
{
	LectoraDao lectoraDao = new LectoraDao();
	
	public LectoraColectivo traerLectoraColectivo(int numeroSerieLectora)
	{
		return lectoraDao.traerLectoraColectivo(numeroSerieLectora);
	}
	
}
