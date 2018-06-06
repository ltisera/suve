package datos;

public class BoletoEstudiantil extends Beneficio{
	private int intervaloEnDias;
	private float monto;
	
	public BoletoEstudiantil() {}
	public BoletoEstudiantil(String nombre, int intervaloEnDias, float monto) {
		super(nombre);
		this.intervaloEnDias = intervaloEnDias;
		this.monto = monto;
	}
	public int getIntervaloEnDias() {
		return intervaloEnDias;
	}
	public void setIntervaloEnDias(int intervaloEnDias) {
		this.intervaloEnDias = intervaloEnDias;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}

	
	
}
