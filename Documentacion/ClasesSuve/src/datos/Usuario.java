package datos;

public class Usuario {
	protected long idUsuario;
	private String apellido;
	private String nombre;
	private int dni;
	private String email;
	private String password;
	protected boolean permisosAdmin;
	public Usuario() {
		super();
	}
	public Usuario(String apellido, String nombre, int dni, String email, String password, boolean permisosAdmin) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
		this.email = email;
		this.password = password;
		this.permisosAdmin = permisosAdmin;
	}
	public long getIdUsuario() {
		return idUsuario;
	}
	protected void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isPermisosAdmin() {
		return permisosAdmin;
	}
	public void setPermisosAdmin(boolean permisosAdmin) {
		this.permisosAdmin = permisosAdmin;
	}
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", apellido=" + apellido + ", nombre=" + nombre + ", dni=" + dni
				+ ", email=" + email + ", password=" + password + ", permisosAdmin=" + permisosAdmin + "]";
	}
}
