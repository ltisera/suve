package testModificaDatos;

import datos.*;
import dao.*;

public class testAgregaBeneficio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeneficioDao bendao = new BeneficioDao();
		long ts = bendao.agregar(new TarifaSocial("Tarifa Social", 55));
		long be = bendao.agregar(new BoletoEstudiantil("Boleto Estudiantil", 30, 300));
		
		TarjetaDao tardao = new TarjetaDao();
		for(long i = 1; i < 9;i++) {
			Tarjeta t = tardao.traerTarjetaConBeneficios(i);
			t.getBeneficios().add(bendao.traerBeneficio(ts));
			tardao.actualizar(t);
		}
		for(long i = 4; i < 11;i++) {
			Tarjeta t = tardao.traerTarjetaConBeneficios(i);
			t.getBeneficios().add(bendao.traerBeneficio(be));
			tardao.actualizar(t);
		}
	}

}