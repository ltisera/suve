package testTraeDatos;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import dao.*;
import datos.*;
import negocio.*;

public class TestDETEST {

	public static void main(String[] args) {
		LectoraDao lecdao = new LectoraDao();
		List<LectoraColectivo> lstleccol = lecdao.traerLectoraColectivo();
		List<LectoraEstacion> lstlecest = lecdao.traerLectoraEstacion();
		for(long i =0;i < 40;i++) {
			if((int) (Math.random() * 2) == 0){
				Lectora lec1 = lstleccol.get(((int)(Math.random()*lstleccol.size())+1));
				System.out.println(lec1);
			}
			else {
				Lectora lec1 = lstlecest.get(((int)Math.random()*lstlecest.size())+1);
				//System.out.println(lec1);
			}

		}

	}
}
