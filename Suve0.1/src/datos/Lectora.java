package datos;

import funciones.Funciones;

public class Lectora {
	private long idLectora;
	private Estacion estacion;
	private Transporte transporte;
	
	public Lectora() {}
	public Lectora(Estacion estacion, Transporte transporte) {
		super();
		this.estacion = estacion;
		this.transporte = transporte;
	}
	public long getIdLectora() {
		return idLectora;
	}
	protected void setIdLectora(long idLectora) {
		this.idLectora = idLectora;
	}
	public Estacion getEstacion() {
		return estacion;
	}
	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}
	public Transporte getTransporte() {
		return transporte;
	}
	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}
	@Override
	public String toString() {
		String string = "Lectora [id=" + idLectora;
		String strEstacion = null;
		if (Funciones.isObjetoInicializado(this.getEstacion()))
			strEstacion += ", " + estacion;
		if (Funciones.isObjetoInicializado(this.getTransporte())) {
			if(strEstacion == null || (strEstacion != null && !estacion.getTransporte().equals(transporte)))
				strEstacion += ", " + transporte;
		}
		if (strEstacion != null)
			string += strEstacion;
		return string + "]";
	}
	
	public boolean equals(Lectora lectora) {
		boolean equals = false;
		if (idLectora == lectora.getIdLectora()) {
			equals = true;
			if(Funciones.isObjetoInicializado(this.getTransporte()) && Funciones.isObjetoInicializado(lectora.getTransporte()))
				equals = transporte.equals(lectora.getTransporte());
			if(equals && Funciones.isObjetoInicializado(this.getEstacion()) && Funciones.isObjetoInicializado(lectora.getEstacion()))
				equals = estacion.equals(lectora.getEstacion());
		}
		return equals;
	}
	
}
