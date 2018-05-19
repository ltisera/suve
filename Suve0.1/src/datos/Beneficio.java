package datos;

import java.util.Set;

public class Beneficio {
	private long idBeneficio;
	private String nombre;
	private Set<Usuario> usuarios;
	private Set<Tarjeta> tarjetas;
	
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


	public Set<Usuario> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}


	public Set<Tarjeta> getTarjetas() {
		return tarjetas;
	}


	public void setTarjetas(Set<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}
	
	public boolean equals(Beneficio beneficio)
	{
		return idBeneficio == beneficio.getIdBeneficio();
	}
	
}
