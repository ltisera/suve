package testTraeDatos;

import java.util.Calendar;
import java.util.GregorianCalendar;

import java.util.List;
import java.util.Collections;
import dao.MovimientoDao;
import datos.Boleto;
import negocio.MovimientoAlta;
import negocio.TarjetaABM;

public class TestTraerBoletosRedSube {

	public static void main(String[] args) 
	{
		TarjetaABM tabm = new TarjetaABM();
		MovimientoAlta movA = new MovimientoAlta();
		MovimientoDao movDao = new MovimientoDao();
		GregorianCalendar fecha = new GregorianCalendar();
		//fecha.add(Calendar.HOUR, -1);
		//List<Boleto> lstb = movA.traerBoletosRedSube(tabm.traerTarjeta(102), fecha);
		
		List<Boleto> lstbTYS = movDao.traerBoletosRedSubeTrenYSubte(tabm.traerTarjeta(109).getIdTarjeta(), fecha);
		List<Boleto> lstbC = movDao.traerBoletosRedSubeColectivo(tabm.traerTarjeta(109).getIdTarjeta(), fecha);
		
		
		System.out.println("\nLISTA DE TREN Y SUBTE\n");
		for(Boleto b: lstbTYS){
			System.out.println(b.toString());
		}
		
		System.out.println("\nLISTA DE COLECTIVO\n");
		
		for(Boleto b: lstbC){
			System.out.println(b.toString());
		}
		
		
		
		lstbTYS.addAll(lstbC);
		
		System.out.println("\nLISTAS SUMADAS SIN ORDENAR\n");
		
		for(Boleto b: lstbTYS){
			System.out.println(b.toString());
		}
		
		Collections.sort(lstbTYS);
		

		System.out.println("\nLISTAS SUMADAS ORDENADAS\n");
		
		for(Boleto b: lstbTYS){
			System.out.println(b.toString());
		}
		
		

	}

}
