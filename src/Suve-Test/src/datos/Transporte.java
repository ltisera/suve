package datos;

public class Transporte {
	private long idTransporte;
	private String linea;
	
	
	public Transporte() {}
	public Transporte(String linea) {
		super();
		this.linea = linea;
	}
	
	
	public long getIdTransporte() {
		return idTransporte;
	}
	protected void setIdTransporte(long idTransporte) {
		this.idTransporte = idTransporte;
	}
	public String getLinea() {
		return linea;
	}
	public void setLinea(String linea) {
		this.linea = linea;
	}
	
	
	@Override
	public String toString() {
		return "Transporte [idTransporte=" + idTransporte + ", linea=" + linea + "]";
	}
}
