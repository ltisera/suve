package datos;

public class LectoraEstacion extends Lectora{
	private Estacion estacion;
	
	public LectoraEstacion() {}
	public LectoraEstacion(Estacion estacion) {
		super();
		this.estacion = estacion;
	}
	
	public Estacion getEstacion() {
		return estacion;
	}
	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}
	
}
