package datos;

public class Usuario {
	protected long idUsuario;
	private String nombre;
	private String apellido;
	private int dni;
	private String mail;
	private String password;
	protected boolean permisoAdmin;
	
	public Usuario() {
		super();
	}
	
	public Usuario(String nombre, String apellido, int dni, String mail, String password, boolean permisoAdmin) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.mail = mail;
		this.password = password;
		this.permisoAdmin = permisoAdmin;
	}
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isPermisoAdmin() {
		return permisoAdmin;
	}
	public void setPermisoAdmin(boolean permisoAdmin) {
		this.permisoAdmin = permisoAdmin;
	}
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", mail=" + mail + ", password=" + password + ", permisoAdmin=" + permisoAdmin + "]";
	}
	
}
