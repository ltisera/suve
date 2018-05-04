package datos;

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
	
	
	
}
