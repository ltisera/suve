package datos;

import java.util.GregorianCalendar;
import datos.Tarjeta;
/**
 * 
 * @author Equipo 1
 * @version 0.9 casi final
 * Movimiento
 * <p> Clase encargada de modelar los Movimientos de la tarjeta SUVE</p>
 */
public class Movimiento {
	private long idMovimiento;
	private GregorianCalendar fecha;
	private float monto;
	private Tarjeta tarjeta;
	
	///Constructores
	public Movimiento() {
		super();
	}

	public Movimiento(GregorianCalendar fecha, float monto, Tarjeta tarjeta) {
		super();
		this.fecha = fecha;
		this.monto = monto;
		this.tarjeta = tarjeta;
	}

	//Setters
	public long getIdMovimiento() {
		return idMovimiento;
	}

	protected void setIdMovimiento(long idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	//Tostring
	@Override
	public String toString() {
		return "Movimiento [idMovimiento=" + idMovimiento + ", fecha=" + fecha + ", monto=" + monto + ", tarjeta="
				+ tarjeta + "]";
	}
	
	
	
	
	
}
