package datos;

public class LectoraTrenYSubte extends Lectora{
	private Estacion estacion;
	
	public LectoraTrenYSubte() {}
	public LectoraTrenYSubte(Estacion estacion, int numeroSerieLectora) {
		super(numeroSerieLectora);
		this.estacion = estacion;

	}
	public Estacion getEstacion() {
		return estacion;
	}
	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}

}
