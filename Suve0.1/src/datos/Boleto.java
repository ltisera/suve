package datos;

import java.util.GregorianCalendar;

public class Boleto extends Movimiento{
	private int intRedSube;
	private TramoTrenYSubte tramoTrenYSubte;
	private TramoColectivo tramoColectivo;
	
	public Boleto() {}
	
	//Constructor De colectivo (con red suce con parametro)
	public Boleto(GregorianCalendar fecha, Lectora lectora, float monto, Tarjeta tarjeta, int intRedSube, TramoColectivo tramoColectivo) {
		super(fecha, lectora, monto, tarjeta);
		this.intRedSube = intRedSube;
		this.tramoColectivo = tramoColectivo;
	}
	//Constructor De colectivo (sin red suce con parametro)
	public Boleto(GregorianCalendar fecha, Lectora lectora, float monto, Tarjeta tarjeta, TramoColectivo tramoColectivo) {
		super(fecha, lectora, monto, tarjeta);
		this.intRedSube=1;
		this.tramoColectivo = tramoColectivo;
	}
	//Constructor de Tren
	public Boleto(GregorianCalendar fecha, Lectora lectora, float monto, Tarjeta tarjeta, TramoTrenYSubte tramoTrenYSubte) {
		super(fecha, lectora, monto, tarjeta);
		this.intRedSube = 1;
		this.tramoTrenYSubte = tramoTrenYSubte;
	}
	
	public int getIntRedSube() {
		return intRedSube;
	}
	public void setIntRedSube(int intRedSube) {
		this.intRedSube = intRedSube;
	}
	public TramoTrenYSubte getTramoTrenYSubte() {
		return tramoTrenYSubte;
	}
	public void setTramoTrenYSubte(TramoTrenYSubte tramoTrenYSubte) {
		this.tramoTrenYSubte = tramoTrenYSubte;
	}
	public TramoColectivo getTramoColectivo() {
		return tramoColectivo;
	}
	public void setTramoColectivo(TramoColectivo tramoColectivo) {
		this.tramoColectivo = tramoColectivo;
	}
	@Override
	public String toString() {
		return "Boleto [" + super.toString() + " red sube=" + intRedSube + "]";
	}
	
	public boolean equals(Boleto boleto) {
		return super.equals(boleto) && intRedSube == boleto.getIntRedSube();
	}
}
