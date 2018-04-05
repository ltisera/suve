package datos;

public class Usuario {
	private long idUsuario ;
	private String apellido ;
	private String nombre ;
	private int dni ;

	public Usuario(){}

	public Usuario(String apellido, String nombre, int dni) {
		super ();
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
	}

	public long getIdUsuario() {
		return idUsuario;
	}
	
	protected void setIdUsuario( long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getApellido() {
		return apellido ;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getNombre() {
		return nombre ;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getDni() {
		return dni ;
	}
	
	public void setDni( int dni) {
		this.dni = dni;
	}

	public String toString(){
		return ( idUsuario + " " + apellido + " " + nombre + " DNI: " + dni);
	}	
}