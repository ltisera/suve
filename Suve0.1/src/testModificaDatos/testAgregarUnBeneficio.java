package testModificaDatos;

import java.util.GregorianCalendar;

import dao.*;
import datos.*;
public class testAgregarUnBeneficio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeneficioDao bendao = new BeneficioDao();
		BoletoEstudiantil be = new BoletoEstudiantil("ElcAmilaso", new GregorianCalendar(), 300f);
		bendao.agregar(be);
		
	}

}
