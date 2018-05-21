package datos;

public class TramoColectivo {
	private long idTramoColectivo;
	private float kMin;
	private float kMax;
	private SeccionViaje seccionViaje;
	
	public TramoColectivo() {}
	public TramoColectivo(float kMin, float kMax, SeccionViaje seccionViaje) {
		super();
		this.kMin = kMin;
		this.kMax = kMax;
		this.seccionViaje = seccionViaje;
	}
	public long getIdTramoColectivo() {
		return idTramoColectivo;
	}
	protected void setIdTramoColectivo(long idTramoColectivo) {
		this.idTramoColectivo = idTramoColectivo;
	}
	public float getkMin() {
		return kMin;
	}
	public void setkMin(float kMin) {
		this.kMin = kMin;
	}
	public float getkMax() {
		return kMax;
	}
	public void setkMax(float kMax) {
		this.kMax = kMax;
	}
	public SeccionViaje getSeccionViaje() {
		return seccionViaje;
	}
	public void setSeccionViaje(SeccionViaje seccionViaje) {
		this.seccionViaje = seccionViaje;
	}
	@Override
	public String toString() {
		String string = kMin + "km - " + kMax + "km";
		if (kMax <= 0)
			string = "+"+ kMin + "km";
		return string;
	}
}
