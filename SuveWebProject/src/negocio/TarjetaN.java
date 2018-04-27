package negocio;
import datos.Boleto;
import datos.Estacion;
import datos.Transporte;
import datos.Tarjeta;
import datos.TipoTransporte;

import java.util.GregorianCalendar;

import dao.TarjetaDao;
import dao.BoletoDao;

public class TarjetaN {
	private TarjetaDao tardao;
	private BoletoDao boldao;
	public Boleto agregarViaje(Tarjeta tar, Transporte t, Estacion e, GregorianCalendar fecha) {
		Boleto b = null;
		if(tar != null && t != null && e != null && fecha != null){
			if(t.getTipoTransporte() == TipoTransporte.Tren) {
				Boleto ultimoBoleto;
				ultimoBoleto = boldao.traerBoleto(tar.getIdTarjeta());
			}
		
		}
		return b;
	}
}
