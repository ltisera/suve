package datos;

public class TarifaSocial extends Beneficio{
	private float porcentajeDescuento;

	
	public TarifaSocial() {
		super();
	}

	public TarifaSocial(String nombre, float porcentajeDescuento) {
		super(nombre);
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public float getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(float porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}
	
	
}
