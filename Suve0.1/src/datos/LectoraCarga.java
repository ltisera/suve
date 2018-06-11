package datos;

public class LectoraCarga extends Lectora{
	private String ubicacion;
	private Estacion estacion;
	
	public LectoraCarga() {}

	public LectoraCarga(String ubicacion, int numeroSerieLectora) {
		super(numeroSerieLectora);
		this.ubicacion = ubicacion;
	}

	public LectoraCarga(Estacion estacion, int numeroSerieLectora) {
		super(numeroSerieLectora);
		this.estacion = estacion;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Estacion getEstacion() {
		return estacion;
	}

	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}
	
	
	
}
