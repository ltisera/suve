package datos;

import java.util.Set;

import funciones.Funciones;
/**
 * 
 * @author Equipo 1
 * @version 0.9 casi final
 * Tarjeta
 * <p> Clase encargada de modelar los DATOS de la tarjeta SUVE</p>
 */
public class Tarjeta {
	private long idTarjeta;
	private float monto;
	private boolean activa;
	private Usuario usuario;
	private Set<Movimiento> movimientos;
	private Set<Beneficio> beneficios;
	
	public Tarjeta() {}
	
	public Tarjeta(float monto) {
		super();
		this.monto = monto;
		this.activa = false;
		
	}
	
	public Tarjeta(float monto, Usuario usuario) {
		super();
		this.monto = monto;
		this.activa = false;
		this.usuario = usuario;
	}
	public long getIdTarjeta() {
		return idTarjeta;
	}
	protected void setIdTarjeta(long idTarjeta) {
		this.idTarjeta = idTarjeta;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public boolean isActiva() {
		return activa;
	}
	public void setActiva(boolean activa) {
		this.activa = activa;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	
	public Set<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(Set<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	public Set<Beneficio> getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(Set<Beneficio> beneficios) {
		this.beneficios = beneficios;
	}

	@Override
	public String toString() {
		String estado = "Inactiva";
		if (activa == true)
			estado = "Activa";
		String string = "Tarjeta [id=" + idTarjeta + ", $" + monto + ", " + estado;
		if (Funciones.isObjetoInicializado(this.getUsuario()))
			string += ", " + usuario;
		return string + "]";
	}
	
	public boolean equals(Tarjeta tarjeta) {
		boolean equals = false;
		if(idTarjeta == tarjeta.getIdTarjeta() && monto == tarjeta.getMonto() && activa == tarjeta.isActiva()) {
			equals = true;
			if (Funciones.isObjetoInicializado(this.getUsuario()) && Funciones.isObjetoInicializado(tarjeta.getUsuario()))
				equals = usuario.equals(tarjeta.getUsuario());
		}
		return equals;
	}
}
