package datos;

import java.util.GregorianCalendar;

public class BoletoEstudiantil extends Beneficio{
	private GregorianCalendar intervalo;
	private float monto;
	
	
	public BoletoEstudiantil() {
		super();
	}
	public BoletoEstudiantil(String nombre, GregorianCalendar intervalo, float monto) {
		super(nombre);
		this.intervalo = intervalo;
		this.monto = monto;
	}
	public GregorianCalendar getIntervalo() {
		return intervalo;
	}
	public void setIntervalo(GregorianCalendar intervalo) {
		this.intervalo = intervalo;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}

	
	
}
