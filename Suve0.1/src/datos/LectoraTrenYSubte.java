package datos;

public class LectoraTrenYSubte extends Lectora{
	private boolean realizaCarga;
	private Estacion estacion;
	
	public LectoraTrenYSubte() {}
	public LectoraTrenYSubte(boolean realizaCarga, Estacion estacion) {
		super();
		this.realizaCarga = realizaCarga;
		this.estacion = estacion;
	}
	public boolean isRealizaCarga() {
		return realizaCarga;
	}
	public void setRealizaCarga(boolean realizaCarga) {
		this.realizaCarga = realizaCarga;
	}
	public Estacion getEstacion() {
		return estacion;
	}
	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}
	
}
