package datos;

public class Transporte {
	private long idTransporte;
	private String linea;
	private TipoTransporte tipoTransporte;
	
	
	public Transporte() {}

	public Transporte(String linea, TipoTransporte tipoTransporte) {
		super();
		this.linea = linea;
		this.tipoTransporte = tipoTransporte;
	}

	public long getIdTransporte() {
		return idTransporte;
	}

	public void setIdTransporte(long idTransporte) {
		this.idTransporte = idTransporte;
	}

	public String getLinea() {
		return linea;
	}

	public void setLinea(String linea) {
		this.linea = linea;
	}

	public TipoTransporte getTipoTransporte() {
		return tipoTransporte;
	}

	public void setTipoTransporte(TipoTransporte tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}

	@Override
	public String toString() {
		return "Transporte [id=" + idTransporte + ", linea=" + linea + ", tipoTransporte=" + tipoTransporte + "]";
	}
	
	public boolean equals(Transporte transporte) {
		return idTransporte == transporte.getIdTransporte() && linea.equals(transporte.getLinea()) && tipoTransporte == transporte.getTipoTransporte();
	}
	
}
