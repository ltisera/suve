package test;

import dao.TarjetaDao;
import datos.Tarjeta;
import negocio.TerminalAutonomo;

public class TestConsultaSaldoTerminalAutonomo {

	public static void main(String[] args) {
		
		TarjetaDao tdao = new TarjetaDao();
		Tarjeta t= tdao.traerTarjeta(1l);
		
		t.setActiva(true);
		
		tdao.actualizar(t);
		
		try
		{
			System.out.println("Consulta de saldo de tarjeta 1: "+TerminalAutonomo.consultarSaldo(1l));
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
