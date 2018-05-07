package datos;

import funciones.Funciones;

public class Estacion {
	private long idEstacion;
	private Transporte transporte;
	private String nombre;
	
	public Estacion() {}
	public Estacion(Transporte transporte, String nombre) {
		super();
		this.transporte = transporte;
		this.nombre = nombre;
	}


	public long getIdEstacion() {
		return idEstacion;
	}


	public void setIdEstacion(long idEstacion) {
		this.idEstacion = idEstacion;
	}


	public Transporte getTransporte() {
		return transporte;
	}


	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		String string = "Estacion [id=" + idEstacion + ", nombre=" + nombre ;
		if (Funciones.isObjetoInicializado(this.getTransporte()))
			string += ", " + transporte;
		return string + "]";
	}
	
	public boolean equals(Estacion estacion) {
		boolean equals = false;
		if (idEstacion == estacion.getIdEstacion() && nombre.equals(estacion.getNombre())) {
			equals = true;
			if(Funciones.isObjetoInicializado(this.getTransporte()) && Funciones.isObjetoInicializado(estacion.getTransporte()))
				equals = transporte.equals(estacion.getTransporte());
		}
		return equals;
	}
	
}
