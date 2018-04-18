package datos;

import java.util.Set;

public class Tarjeta {
	private long idTarjeta;
	private float saldo;
	private Usuario usuario;
	private Set<Beneficio> beneficios;
	private Set<Boleto> boletos;
	
	
	public Tarjeta() {}
	public Tarjeta(float saldo, Usuario usuario) {
		super();
		this.saldo = saldo;
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
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Set<Beneficio> getBeneficios() {
		return beneficios;
	}
	public void setBeneficios(Set<Beneficio> beneficios) {
		this.beneficios = beneficios;
	}
	public Set<Boleto> getBoletos() {
		return boletos;
	}
	public void setBoletos(Set<Boleto> boletos) {
		this.boletos = boletos;
	}
	
	
	@Override
	public String toString() {
		return "Tarjeta [idTarjeta=" + idTarjeta + ", saldo=" + saldo + ", usuario=" + usuario + "]";
	}
}
