package datos;

import java.util.Set;

public class Usuario {
	private long idUsuario;
	private String nombre;
	private String apellido;
	private int dni;
	private String mail;
	private String password;
	private TipoUsuario tipoUsuario;
	private Set<Tarjeta> tarjetas;
	private Set<Beneficio> beneficios;
	
	
	public Usuario() {}
	public Usuario(String nombre, String apellido, int dni, String mail, String password, TipoUsuario tipoUsuario) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.mail = mail;
		this.password = password;
		this.tipoUsuario = tipoUsuario;
	}
	
	
	public long getIdUsuario() {
		return idUsuario;
	}
	protected void setIdUsuario(long idUsuario) {
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
	public Set<Tarjeta> getTarjetas() {
		return tarjetas;
	}
	public void setTarjetas(Set<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}
	public Set<Beneficio> getBeneficios() {
		return beneficios;
	}
	public void setBeneficios(Set<Beneficio> beneficios) {
		this.beneficios = beneficios;
	}
	
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + idUsuario + ", dni=" + dni + " " + apellido + ", " + nombre + ", mail=" + mail + ", password=" + password + ", " + tipoUsuario + "]";
	}
	
	public boolean equals(Usuario usuario) {
		return idUsuario == usuario.getIdUsuario() && dni == usuario.getDni() && mail.equals(usuario.getMail()) && nombre.equals(usuario.getNombre()) && apellido.equals(usuario.getApellido()) && password.equals(usuario.getPassword()) && tipoUsuario == usuario.getTipoUsuario();
	}
}
