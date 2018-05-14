package datos;

public class Transporte {
	private String linea;
	public Transporte() {
		super();
	}
	public Transporte(String linea) {
		super();
		this.linea = linea;
	}
	public String getLinea() {
		return linea;
	}
	public void setLinea(String linea) {
		this.linea = linea;
	}
	@Override
	public String toString() {
		return "Transporte [linea=" + linea + "]";
	}
}
