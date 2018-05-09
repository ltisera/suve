package testTraeDatos;

import java.util.List;

import dao.*;
import datos.*;

public class testTraerBoletoCompleto {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovimientoDao mdao = new MovimientoDao();
		TarjetaDao tdao = new TarjetaDao();
		List<Tarjeta> lt = tdao.traerTarjeta();
		for(Tarjeta t: lt) {
			System.out.println(t);
		}
	}
}
