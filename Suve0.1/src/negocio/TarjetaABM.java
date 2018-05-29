package negocio;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import dao.BeneficioDao;
import dao.TarjetaDao;
import datos.Beneficio;
import datos.BoletoEstudiantil;
import datos.TarifaSocial;
import datos.Tarjeta;

public class TarjetaABM 
{
	TarjetaDao tarjetaDao = new TarjetaDao();
	BeneficioDao beneficioDao = new BeneficioDao();
	BoletoEstudiantil bolEstudiantil = beneficioDao.traerBoletoEstudiantil();
	TarifaSocial tarSocial = beneficioDao.traerTarifaSocial();
	
	public void modificarTarjeta(Tarjeta tarjeta)
	{
		tarjetaDao.actualizar(tarjeta);
	}
	
	public TarifaSocial traerTarifaSocial()
	{
		return tarSocial;
	}
	
	public BoletoEstudiantil traerBoletoEstudiantil()
	{
		return bolEstudiantil;
	}
	
	public Tarjeta traerTarjeta(int numeroSerieTarjeta)
	{
		return tarjetaDao.traerTarjeta(numeroSerieTarjeta);
	}

	public Tarjeta traerTarjetaConBeneficios(int numeroSerieTarjeta) 
	{
		return tarjetaDao.traerTarjetaConBeneficios(numeroSerieTarjeta);
	}
	public List<Tarjeta> traerTarjetaConBeneficios() 
	{
		return tarjetaDao.traerTarjetaCompleta();
	}
	
	public boolean cargarBoletoEstudiantil(GregorianCalendar fechaSistema) {
		boolean cargaExitosa = false;
		MovimientoAlta mov = new MovimientoAlta();
		GregorianCalendar fechaProximaCarga = mov.traerRecargaEstudiantil().getFecha(); //Consigo la ultima fecha en a que se cargo el boleto
		fechaProximaCarga.add(Calendar.DAY_OF_MONTH, this.traerBoletoEstudiantil().getIntervaloEnDias()); //le agrego los dias del intervalo para calcular cuando sera la proxima fecha a cargar
		if(fechaSistema.compareTo(fechaProximaCarga)>=0) { // 0 Son iguales +0 la fecha del sistema es posterior a la de la proxima carga 
			for(Tarjeta t: this.traerTarjetaConBeneficios()) {
				if(t.getBeneficios().contains(this.bolEstudiantil)) {
					t.setMonto(t.getMonto() + this.bolEstudiantil.getMonto());
					this.modificarTarjeta(t);
				}
			}
			cargaExitosa = true;
		}
		return cargaExitosa;
	}
}
