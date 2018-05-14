package datos;

public class LectoraAutonoma extends Lectora{
	private String ubicacion;
	private Estacion estacion;
	
	public LectoraAutonoma() {}

	public LectoraAutonoma(String ubicacion) {
		super();
		this.ubicacion = ubicacion;
	}

	public LectoraAutonoma(Estacion estacion) {
		super();
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
