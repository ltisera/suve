package TestModificaDatos;

import dao.*;
import datos.*;

public class TestAgregaTransporte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TransporteDao transDao = new TransporteDao();
		Transporte t = new Transporte();
		//t.setLinea("Roquita");
		//t.setTipoTransporte(TipoTransporte.Tren);
		
		t = transDao.traerTransporte(1l);
		
		System.out.println(t.getTipoTransporte() == TipoTransporte.Tren);
		
		

	}

}
