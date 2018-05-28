package datos;

import java.util.GregorianCalendar;

public class Recarga extends Movimiento{	
	private boolean esBoletoEstudiantil;

	public Recarga() {}

	public Recarga(GregorianCalendar fecha, Lectora lectora, float monto, Tarjeta tarjeta, boolean esBoletoEstudiantil) {
		super(fecha, lectora, monto, tarjeta);
		this.esBoletoEstudiantil = esBoletoEstudiantil;
	}

	public boolean isEsBoletoEstudiantil() {
		return esBoletoEstudiantil;
	}

	public void setEsBoletoEstudiantil(boolean esBoletoEstudiantil) {
		this.esBoletoEstudiantil = esBoletoEstudiantil;
	}

	@Override
	public String toString() {
		return "Recarga [" + super.toString() + " Boleto estudiantil=" + esBoletoEstudiantil + "]";
	}
	
	public boolean equals(Recarga recarga) {
		return super.equals(recarga) && esBoletoEstudiantil == recarga.isEsBoletoEstudiantil();
	}
}
