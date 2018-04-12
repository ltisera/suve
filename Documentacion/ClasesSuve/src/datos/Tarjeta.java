package datos;

public class Tarjeta {
	protected long idTarjeta;
	private float saldo;
	private boolean tarifaSocial;
	private boolean boletoEstudiantil;
	private Usuario usuario;
	public Tarjeta() {
		super();
	}
	public Tarjeta(float saldo, boolean tarifaSocial, boolean boletoEstudiantil, Usuario usuario) {
		super();
		this.saldo = saldo;
		this.tarifaSocial = tarifaSocial;
		this.boletoEstudiantil = boletoEstudiantil;
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
	public boolean isTarifaSocial() {
		return tarifaSocial;
	}
	public void setTarifaSocial(boolean tarifaSocial) {
		this.tarifaSocial = tarifaSocial;
	}
	public boolean isBoletoEstudiantil() {
		return boletoEstudiantil;
	}
	public void setBoletoEstudiantil(boolean boletoEstudiantil) {
		this.boletoEstudiantil = boletoEstudiantil;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "Tarjeta [idTarjeta=" + idTarjeta + ", saldo=" + saldo + ", tarifaSocial=" + tarifaSocial
				+ ", boletoEstudiantil=" + boletoEstudiantil + ", usuario=" + usuario + "]";
	}
}
