package datos;

import java.util.GregorianCalendar;

public class Boleto {
	protected long idBoleto;
	private GregorianCalendar fecha;
	private float precio;
	private boolean cerrado;
	private Transporte transporte;
	private Tarjeta tarjeta;
	public Boleto() {
		super();
	}
	public Boleto(GregorianCalendar fecha, float precio, boolean cerrado, Transporte transporte, Tarjeta tarjeta) {
		super();
		this.fecha = fecha;
		this.precio = precio;
		this.cerrado = cerrado;
		this.transporte = transporte;
		this.tarjeta = tarjeta;
	}
	public long getIdBoleto() {
		return idBoleto;
	}
	protected void setIdBoleto(long idBoleto) {
		this.idBoleto = idBoleto;
	}
	public GregorianCalendar getFecha() {
		return fecha;
	}
	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public boolean isCerrado() {
		return cerrado;
	}
	public void setCerrado(boolean cerrado) {
		this.cerrado = cerrado;
	}
	public Transporte getTransporte() {
		return transporte;
	}
	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}
	public Tarjeta getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
	@Override
	public String toString() {
		return "Boleto [idBoleto=" + idBoleto + ", fechaHora=" + fecha + ", precio=" + precio + ", cerrado="
				+ cerrado + ", transporte=" + transporte + ", tarjeta=" + tarjeta + "]";
	}
}
