package testModificaDatos;

import dao.*;
import datos.*;


public class testAgregaTransporte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TransporteDao transdao = new TransporteDao(); 
		
		transdao.agregar(new Transporte("Vamo el Roca", TipoTransporte.Tren));
		
	}

}
