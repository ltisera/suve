package datos;

public class TramoTrenYSubte {
	private long idTramoTrenYSubte;
	private Estacion estacionA;
	private Estacion estacionB;
	private SeccionViaje seccionViaje;
	
	public TramoTrenYSubte() {}
	public TramoTrenYSubte(Estacion estacionA, Estacion estacionB, SeccionViaje seccionViaje) {
		super();
		this.estacionA = estacionA;
		this.estacionB = estacionB;
		this.seccionViaje = seccionViaje;
	}
	public long getIdTramoTrenYSubte() {
		return idTramoTrenYSubte;
	}
	protected void setIdTramoTrenYSubte(long idTramoYSubte) {
		this.idTramoTrenYSubte = idTramoYSubte;
	}
	public Estacion getEstacionA() {
		return estacionA;
	}
	public void setEstacionA(Estacion estacionA) {
		this.estacionA = estacionA;
	}
	public Estacion getEstacionB() {
		return estacionB;
	}
	public void setEstacionB(Estacion estacionB) {
		this.estacionB = estacionB;
	}
	public SeccionViaje getSeccionViaje() {
		return seccionViaje;
	}
	public void setSeccionViaje(SeccionViaje seccionViaje) {
		this.seccionViaje = seccionViaje;
	}
	
	
}
