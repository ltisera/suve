package negocio;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import dao.BeneficioDao;
import dao.TarjetaDao;
import datos.Beneficio;
import datos.BoletoEstudiantil;
import datos.Lectora;
import datos.Recarga;
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
		return tarjetaDao.traerTarjetaConBeneficios(); //Sin usuario
	}
	public boolean tarjetaContieneBoletoEstudiantil(Tarjeta t) 
	{
		boolean contiene = false;
		for(Beneficio b: t.getBeneficios())
			if(b instanceof BoletoEstudiantil) contiene = true;
		return contiene;
	}
	
	public boolean cargarBoletoEstudiantil(GregorianCalendar fechaSistema) throws Exception {
		boolean cargaExitosa = false;
		MovimientoABM mov = new MovimientoABM();
		Recarga recargaEstudiantil = mov.traerRecargaEstudiantil();
		GregorianCalendar fechaProximaCarga = (GregorianCalendar) fechaSistema.clone();
		if(recargaEstudiantil != null) {
			fechaProximaCarga = recargaEstudiantil.getFecha(); //Consigo la ultima fecha en a que se cargo el boleto
			fechaProximaCarga.add(Calendar.DAY_OF_MONTH, this.traerBoletoEstudiantil().getIntervaloEnDias()); //le agrego los dias del intervalo para calcular cuando sera la proxima fecha a cargar			System.out.println(Funciones.TraeFechaYHora(fechaProximaCarga));
		}
		if(fechaSistema.compareTo(fechaProximaCarga)>=0) { // 0 Son iguales +0 la fecha del sistema es posterior a la de la proxima carga 
			LectoraABM adl = new LectoraABM();
			System.out.println("Cargando saldo estudiantil");
			//Que lectora usar?????
			Lectora l = adl.traerLectoraEstacion(3331000);
			for(Tarjeta t: this.traerTarjetaConBeneficios()) {
				if(this.tarjetaContieneBoletoEstudiantil(t)) {
					System.out.println("Tarjeta con Boleto Estudiantil");
					adl.agregarRecarga(l, t, fechaSistema, bolEstudiantil.getMonto(), true);
				}
			}
			cargaExitosa = true;
		}
		System.out.println("Cargado de saldo estudiantil Finalizado");
		return cargaExitosa;
	}

	public List<Tarjeta> traerTarjeta() 
	{
		return tarjetaDao.traerTarjeta();
	}

	public String stringListaTarjetas(List<Tarjeta> lstTarjeta) 
	{
		String listaTarjetas ="[";
		
		for(Tarjeta t:lstTarjeta) {
			listaTarjetas += "\"" + t.getNumeroSerieTarjeta() + "\",";
		}
		listaTarjetas = listaTarjetas.substring(0, listaTarjetas.length()-1);
		return listaTarjetas += "]";
	}
	
	public boolean tieneTarifaSocial(Tarjeta tar) 
	{
		boolean contieneTarifa = false;
		for(Beneficio b: tar.getBeneficios())
			if(b instanceof TarifaSocial) contieneTarifa = true;
		return contieneTarifa;
	}
}
