package datos;

import java.util.Set;

public class Lectora {
	private long idLectora;
	private Set<Movimiento> movimientos;
	
	public Lectora() {}
	public long getIdLectora() {
		return idLectora;
	}
	protected void setIdLectora(long idLectora) {
		this.idLectora = idLectora;
	}
	public Set<Movimiento> getMovimientos() {
		return movimientos;
	}
	public void setMovimientos(Set<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}
	@Override
	public String toString() {
		return "Lectora [id=" + idLectora + "]";
	}
	
	public boolean equals(Lectora lectora) {
		return idLectora == lectora.getIdLectora();
	}
	
}
