package datos;

import java.util.GregorianCalendar;

public class Boleto extends Movimiento{
	private boolean cerrado;
	private Transporte transporte;
	private int intRedSube;
	private Tramo tramo;
	
	//Constructores
	public Boleto() {}

	
	public Boleto(boolean cerrado, Transporte transporte, int intRedSube,GregorianCalendar fecha, float monto, Tarjeta tarjeta, Tramo tramo) {
		// TODO Auto-generated constructor stub
		super(fecha, monto, tarjeta);
		this.cerrado = cerrado;
		this.transporte = transporte;
		this.intRedSube = intRedSube;
		this.tramo = tramo;
	
	}


	public boolean isCerrado() {
		return cerrado;
	}


	public void setCerrado(boolean cerrado) {
		this.cerrado = cerrado;
	}


	public Transporte getTransporte() {
		return transporte;
	}


	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}


	public int getIntRedSube() {
		return intRedSube;
	}


	public void setIntRedSube(int intRedSube) {
		this.intRedSube = intRedSube;
	}


	public Tramo getTramo() {
		return tramo;
	}


	public void setTramo(Tramo tramo) {
		this.tramo = tramo;
	}


	@Override
	public String toString() {
		return "Boleto [cerrado=" + cerrado + ", transporte=" + transporte + ", intRedSube=" + intRedSube + ", tramo="
				+ tramo + "]";
	}
	
	
	
	

}
