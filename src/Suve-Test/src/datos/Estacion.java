package datos;

public class Estacion {
	protected long idEstacion;
	private Transporte transporte;
	private String nombre;
	private int kilometro;
	public Estacion() {
		super();
	}
	public Estacion(Transporte transporte, String nombre, int kilometro) {
		super();
		this.transporte = transporte;
		this.nombre = nombre;
		this.kilometro = kilometro;
	}
	public long getIdEstacion() {
		return idEstacion;
	}
	protected void setIdEstacion(long idEstacion) {
		this.idEstacion = idEstacion;
	}
	public Transporte getTransporte() {
		return transporte;
	}
	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getKilometro() {
		return kilometro;
	}
	public void setKilometro(int kilometro) {
		this.kilometro = kilometro;
	}
	@Override
	public String toString() {
		return "Estacion [idEstacion=" + idEstacion + ", transporte=" + transporte + ", nombre=" + nombre
				+ ", kilometro=" + kilometro + "]";
	}
}
