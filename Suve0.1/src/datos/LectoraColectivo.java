package datos;

public class LectoraColectivo extends Lectora{
	private Transporte transporte;

	public LectoraColectivo() {}
	public LectoraColectivo(Transporte transporte) {
		super();
		this.transporte = transporte;
	}

	public Transporte getTransporte() {
		return transporte;
	}

	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}

}
