package datos;

import java.util.GregorianCalendar;

public class Boleto extends Movimiento{
	private boolean cerrado;
	private int intRedSube;
	private Transporte transporte;
	
	
	
	
	public Boleto() {
		super();
	}
	public Boleto(GregorianCalendar fecha, Lectora lectora, float monto, Tarjeta tarjeta, boolean cerrado,
			int intRedSube, Transporte transporte) {
		super(fecha, lectora, monto, tarjeta);
		this.cerrado = cerrado;
		this.intRedSube = intRedSube;
		this.transporte = transporte;
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
	public Transporte getTransporte() {
		return transporte;
	}
	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}
	@Override
	public String toString() {
		return "Boleto [cerrado=" + cerrado + ", intRedSube=" + intRedSube + "]";
	}
	
	public String toStringCompleto() {
		return "Boleto [cerrado=" + cerrado + ", intRedSube=" + intRedSube + ", transporte=" + transporte + "]";
	}
	
	
}
