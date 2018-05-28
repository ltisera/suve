package testModificaDatos;

import datos.*;

import java.util.List;

import dao.*;

public class testAgregaBeneficio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeneficioDao bendao = new BeneficioDao();
		bendao.agregar(new TarifaSocial("Tf Soc", 55));
		bendao.agregar(new BoletoEstudiantil("Boleto Estudiantil", 30, 300));
		
		TarjetaDao tardao = new TarjetaDao();
		for(long i = 1; i < 9;i++) {
			Tarjeta t = tardao.traerTarjetaConBeneficios(tardao.traerTarjeta(i).getNumeroSerieTarjeta());
			t.getBeneficios().add(bendao.traerBeneficio(1l));
			tardao.actualizar(t);
		}
		for(long i = 4; i < 11;i++) {
			Tarjeta t = tardao.traerTarjetaConBeneficios(tardao.traerTarjeta(i).getNumeroSerieTarjeta());
			t.getBeneficios().add(bendao.traerBeneficio(2l));
			tardao.actualizar(t);
		}
		System.out.println("Y con eso ya esta");
	}

}