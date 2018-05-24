package testLucas;
import dao.*;
import datos.*;
import java.util.List;
public class testPorqueNoAndaLectora {

	
	public static void main(String[] args) {
		MovimientoDao movdao = new MovimientoDao();
		
		/*
		LectoraDao lecdao = new LectoraDao();
		LectoraColectivo landa = (LectoraColectivo)lecdao.traerLectora(1005l);
		
		System.out.println("Anda"+ landa.getTransporte().getIdTransporte());
		System.out.println("Anda"+ landa.getTransporte().getLinea());
		
		
		System.out.println("NAnda"+ ((LectoraColectivo)l).getTransporte().getIdTransporte());
		System.out.println("NAnda"+ ((LectoraColectivo)l).getTransporte().getLinea());
		*/
		
		
		List<Movimiento> lmov = movdao.traerMovimientosPorTarjetaConCase(19l);
		for(Movimiento m:lmov) {
			
			System.out.println("UN BUCLE");
			if(m.getLectora() instanceof LectoraColectivo) {
				System.out.println("Colectivo");
				System.out.println(m.getLectora());
				System.out.println(m.getLectora().getIdLectora());
				System.out.println(((LectoraColectivo)m.getLectora()).getTransporte().getIdTransporte());
				System.out.println(((LectoraColectivo)m.getLectora()).getTransporte().getLinea());
				System.out.println(((LectoraColectivo)m.getLectora()));
				//System.out.println(((LectoraColectivo)m.getLectora()).getTransporte());
				
				
			} else if(m.getLectora() instanceof LectoraEstacion) {
				System.out.println("TREN");
				System.out.println("El ID: "+ ((LectoraEstacion)m.getLectora()).getEstacion().getIdEstacion());
				System.out.println("La est:" + ((LectoraEstacion)m.getLectora()).getEstacion().getTransporte());
			} else {
				System.out.println("La pu que te pa");
			}
		}

		
	}
}
