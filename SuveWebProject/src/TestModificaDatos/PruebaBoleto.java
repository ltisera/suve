package TestModificaDatos;
import java.util.GregorianCalendar;

import dao.MovimientoDao;
import dao.UsuarioDao;
import datos.*;

public class PruebaBoleto {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MovimientoDao mundao = new MovimientoDao();
		Boleto b1 = new Boleto(false,
							new Transporte("a"),
							1,
							new GregorianCalendar(),
							10f,
							new Tarjeta(),
							new Tramo());
		Recarga r1 = new Recarga(new GregorianCalendar(),43f,new Tarjeta(),false);
		mundao.agregar(r1);
		mundao.agregar(b1);
		
	}
}