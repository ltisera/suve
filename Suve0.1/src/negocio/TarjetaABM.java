package negocio;

import dao.BeneficioDao;
import dao.TarjetaDao;
import datos.TarifaSocial;
import datos.Tarjeta;

public class TarjetaABM 
{
	TarjetaDao tarjetaDao = new TarjetaDao();
	BeneficioDao beneficioDao = new BeneficioDao();
	
	public void modificarTarjeta(Tarjeta tarjeta)
	{
		tarjetaDao.actualizar(tarjeta);
	}
	
	public TarifaSocial traerTarifaSocial()
	{
		return beneficioDao.traerTarifaSocial();
	}
	
	public Tarjeta traerTarjeta(int numeroSerieTarjeta)
	{
		return tarjetaDao.traerTarjeta(numeroSerieTarjeta);
	}

	public Tarjeta traerTarjetaConBeneficios(int numeroSerieTarjeta) 
	{
		return tarjetaDao.traerTarjetaConBeneficios(numeroSerieTarjeta);
	}
}
