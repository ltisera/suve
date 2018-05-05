package datos;

import java.util.GregorianCalendar;

public class Recarga extends Movimiento{
	
	private boolean saldoPendiente;

		
	public Recarga() {}

	public Recarga(GregorianCalendar fecha, Lectora lectora, float monto, Tarjeta tarjeta, boolean saldoPendiente) {
		super(fecha, lectora, monto, tarjeta);
		this.saldoPendiente = saldoPendiente;
	}

	public boolean isSaldoPendiente() {
		return saldoPendiente;
	}

	public void setSaldoPendiente(boolean saldoPendiente) {
		this.saldoPendiente = saldoPendiente;
	}

	
}
