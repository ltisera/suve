package negocio;

import dao.TarjetaDao;
import datos.Tarjeta;

public class TerminalAutonomo 
{
	
	public static float consultarSaldo(long idTarjeta)throws Exception//Si la tarjeta no existe o no esta activa, no realiza la consulta.
	{
		TarjetaDao tdao = new TarjetaDao();
		Tarjeta tarjeta = tdao.traerTarjeta(idTarjeta);
		if(tarjeta==null || !tarjeta.isActiva()) throw new Exception("ERROR: la tarjeta no esta activa o no es una tarjeta SUBE.");
		return tarjeta.getSaldo();
	}
	

}
