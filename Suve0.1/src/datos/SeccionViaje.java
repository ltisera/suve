package datos;

public class SeccionViaje {
	private long idSeccionViaje;
	private String nombre;
	private float monto;
	
	public SeccionViaje() {}
	public SeccionViaje(String nombre, float monto) {
		super();
		this.nombre = nombre;
		this.monto = monto;
	}
	public long getIdSeccionViaje() {
		return idSeccionViaje;
	}
	protected void setIdSeccionViaje(long idSeccionViaje) {
		this.idSeccionViaje = idSeccionViaje;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	@Override
	public String toString() {
		return "SeccionViaje [idSeccionViaje=" + idSeccionViaje + ", nombre=" + nombre + ", monto=" + monto + "]";
	}
	
	
}
