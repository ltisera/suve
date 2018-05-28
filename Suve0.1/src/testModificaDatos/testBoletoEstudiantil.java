package testModificaDatos;

import java.util.Calendar;

import dao.BeneficioDao;
import datos.Beneficio;
import datos.BoletoEstudiantil;
import negocio.Funciones;

public class testBoletoEstudiantil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BeneficioDao bendao = new BeneficioDao();
		BoletoEstudiantil bolebene = (BoletoEstudiantil)bendao.traerBeneficio(2l);
		//System.out.println(bolebene.getIntervalo().get(Calendar.YEAR));
	}

}
