package datos;

import java.util.GregorianCalendar;

public class Movimiento {
	private long idMovimiento;
	private GregorianCalendar fecha;
	private float monto;
	private Tarjeta tarjeta;
	private Lectora lectora;
	
	public Movimiento() {}
	public Movimiento(GregorianCalendar fecha, float monto, Tarjeta tarjeta) {
		super();
		this.fecha = fecha;
		this.monto = monto;
		this.tarjeta = tarjeta;
	}
	public long getIdMovimiento() {
		return idMovimiento;
	}
	protected void setIdMovimiento(long idMovimiento) {
		this.idMovimiento = idMovimiento;
	}
	public GregorianCalendar getFecha() {
		return fecha;
	}
	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public Tarjeta getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
	public Lectora getLectora() {
		return lectora;
	}
	public void setLectora(Lectora lectora) {
		this.lectora = lectora;
	}
	
	
	
}
