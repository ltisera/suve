package datos;

public class Beneficio {
	private long idBeneficio;
	private String nombre;
	
	
	public Beneficio() {}
	public Beneficio(String nombre) {
		super();
		this.nombre = nombre;
	}

	
	public long getIdBeneficio() {
		return idBeneficio;
	}
	protected void setIdBeneficio(long idBeneficio) {
		this.idBeneficio = idBeneficio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	@Override
	public String toString() {
		return "Beneficio [idBeneficio=" + idBeneficio + ", nombre=" + nombre + "]";
	}
}
