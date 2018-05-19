package datos;

import java.util.Set;

public class Lectora {
	private long idLectora;
	private int numeroSerieLectora;
	private Set<Movimiento> movimientos;
	
	public Lectora() {}
	public Lectora(int numeroSerieLectora)
	{
		this.numeroSerieLectora = numeroSerieLectora;
	}
	
	public long getIdLectora() {
		return idLectora;
	}
	protected void setIdLectora(long idLectora) {
		this.idLectora = idLectora;
	}
	public int getNumeroSerieLectora() {
		return numeroSerieLectora;
	}
	public void setNumeroSerieLectora(int numeroSerieLectora) {
		this.numeroSerieLectora = numeroSerieLectora;
	}
	public Set<Movimiento> getMovimientos() {
		return movimientos;
	}
	public void setMovimientos(Set<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	
	@Override
	public String toString() {
		return "Lectora [idLectora=" + idLectora + ", numeroSerieLectora=" + numeroSerieLectora + ", movimientos="
				+ movimientos + "]";
	}
	public boolean equals(Lectora lectora) {
		return idLectora == lectora.getIdLectora();
	}
	
}
