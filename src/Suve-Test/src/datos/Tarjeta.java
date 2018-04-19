package datos;

import java.util.Set;

public class Tarjeta {
	private long idTarjeta;
	private float saldo;
	private boolean baja;
	private Usuario usuario;
	private Set<Boleto> boletos;
	
	
	public Tarjeta() {}
	public Tarjeta(float saldo, Usuario usuario) {
		super();
		this.saldo = saldo;
		this.baja = false;
		this.usuario = usuario;
	}
	
	
	public long getIdTarjeta() {
		return idTarjeta;
	}
	protected void setIdTarjeta(long idTarjeta) {
		this.idTarjeta = idTarjeta;
	}
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public boolean isBaja() {
		return baja;
	}
	public void setBaja(boolean baja) {
		this.baja = baja;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Set<Beneficio> getBeneficios() {
		return usuario.getBeneficios();
	}
	public void setBeneficios(Set<Beneficio> beneficios) {
		this.usuario.setBeneficios(beneficios);
	}
	public Set<Boleto> getBoletos() {
		return boletos;
	}
	public void setBoletos(Set<Boleto> boletos) {
		this.boletos = boletos;
	}
	
	
	@Override
	public String toString() {
		String estado = "Inactiva";
		if (baja == false)
			estado = "Activa";
		return "Tarjeta [" + idTarjeta + ", $" + saldo + ", " + estado + "]";
	}
}
