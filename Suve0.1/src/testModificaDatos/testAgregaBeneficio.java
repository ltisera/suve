package testModificaDatos;

import datos.*;
import dao.*;

public class testAgregaBeneficio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeneficioDao bendao = new BeneficioDao();
		bendao.agregar(new TarifaSocial("Tf Soc", 55));
		TarjetaDao tardao = new TarjetaDao();
		Tarjeta t = tardao.traerTarjeta(6l);
		t.getBeneficios().add(bendao.traerBeneficio(1l));
		tardao.actualizar(t);
		System.out.println("Y con eso ya esta");
	}

}
