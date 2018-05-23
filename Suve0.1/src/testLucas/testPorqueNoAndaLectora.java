package testLucas;
import dao.*;
import datos.*;
import java.util.List;
public class testPorqueNoAndaLectora {

	
	public static void main(String[] args) {
		MovimientoDao movdao = new MovimientoDao();
		LectoraDao lecdao = new LectoraDao();
		Lectora l = lecdao.traerLectora(19l);
		List<Movimiento> lmov = movdao.traerMovimientosPorTarjeta(19l);
		for(Movimiento m:lmov) {
			if(m.getLectora() instanceof LectoraColectivo) {
				System.out.println("Colectivo");
			} else if(m.getLectora() instanceof LectoraTrenYSubte) {
				System.out.println("TREN");
			} else {
				System.out.println("La pu que te pa");
			}
		}
		System.out.println(l);
		if(l instanceof LectoraTrenYSubte)
			System.out.println("TREN");
		if(l instanceof LectoraColectivo)
			System.out.println("Bondi");
		
	}
}
