package datos;

import java.util.GregorianCalendar;

public class Boleto extends Movimiento{
	private boolean cerrado;
	private int intRedSube;
	
	
	
	
	public Boleto() {
		super();
	}
	public Boleto(GregorianCalendar fecha, Lectora lectora, float monto, Tarjeta tarjeta, boolean cerrado,
			int intRedSube) {
		super(fecha, lectora, monto, tarjeta);
		this.cerrado = cerrado;
		this.intRedSube = intRedSube;
	}
	public boolean isCerrado() {
		return cerrado;
	}
	public void setCerrado(boolean cerrado) {
		this.cerrado = cerrado;
	}
	public int getIntRedSube() {
		return intRedSube;
	}
	public void setIntRedSube(int intRedSube) {
		this.intRedSube = intRedSube;
	}
	@Override
	public String toString() {
		return "Boleto [cerrado=" + cerrado + ", intRedSube=" + intRedSube + "]";
	}

	
}
