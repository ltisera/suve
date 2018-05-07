package datos;

import java.util.GregorianCalendar;

import funciones.Funciones;

public class Movimiento {
	private long idMovimiento;
	private GregorianCalendar fecha;
	private float monto;
	private Tarjeta tarjeta;
	private Lectora lectora;
	
	public Movimiento() {}
	public Movimiento(GregorianCalendar fecha, Lectora lectora, float monto, Tarjeta tarjeta) {
		super();
		this.lectora = lectora;
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
	@Override
	public String toString() {
		String string = "id=" + idMovimiento + " " + Funciones.TraeFechaYHora(fecha) + " $" + monto;
		if (Funciones.isObjetoInicializado(this.getTarjeta()))
			string = string + " " + tarjeta;
		if (Funciones.isObjetoInicializado(this.getLectora()))
			string = string + " " + lectora;
		return string;
	}
	
	public boolean equals(Movimiento movimiento) {
		boolean equals = false;
		if (idMovimiento == movimiento.getIdMovimiento() && fecha.compareTo(movimiento.getFecha()) == 0 && monto == movimiento.getMonto()) {
			equals = true;
			if(Funciones.isObjetoInicializado(this.getTarjeta()) && Funciones.isObjetoInicializado(movimiento.getTarjeta()))
				equals = tarjeta.equals(movimiento.getTarjeta());
			if(equals && Funciones.isObjetoInicializado(this.getLectora()) && Funciones.isObjetoInicializado(movimiento.getLectora()))
				equals = lectora.equals(movimiento.getLectora());
		}
		return equals;
	}
}
