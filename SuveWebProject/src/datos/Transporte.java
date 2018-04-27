package datos;

public class Transporte {
	private long idTransporte;
	private String linea;
	private TipoTransporte tipoTransporte;
	
	
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
	
	
	public TipoTransporte getTipoTransporte() {
		return tipoTransporte;
	}
	public void setTipoTransporte(TipoTransporte tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}
	@Override
	public String toString() {
		return "Transporte [idTransporte=" + idTransporte + ", linea=" + linea +" tipo=" + tipoTransporte +"]";
	}
}
