package negocio;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.proxy.HibernateProxy;

import datos.TarifaSocial;
import datos.Boleto;

public class Funciones {
	public static String TraeFechaYHora(GregorianCalendar fecha) {
		return fecha.get(Calendar.DATE)+"/"+(fecha.get(Calendar.MONTH)+1)+"/"+fecha.get(Calendar.YEAR) + " " + fecha.get(Calendar.HOUR_OF_DAY)+ ":" + fecha.get(Calendar.MINUTE)+ ":" +fecha.get(Calendar.SECOND);
	}

	public static boolean isObjetoInicializado(Object objeto)
	{
		boolean inicializado = false;
		if (HibernateProxy.class.isInstance(objeto)) {
			HibernateProxy proxy = HibernateProxy.class.cast(objeto);
			if (!proxy.getHibernateLazyInitializer().isUninitialized()) {
				inicializado = true;
			}
		}
		else
			inicializado = true;
		return inicializado;
	}
	
	public static void calcularTarifaSocial(Boleto nuevoBoleto, TarifaSocial tarifa)
	{
		nuevoBoleto.setMonto(nuevoBoleto.getMonto()-(nuevoBoleto.getMonto()* (tarifa.getPorcentajeDescuento()/100)));
	}
	
	
	public static  void calcularRedSube(List<Boleto> boletosRedSube, Boleto nuevoBoleto)
	{
		float porcentajeDescuento = 0;
		int intRedSube = 1;
		if(boletosRedSube.size()>0 && boletosRedSube.get(0).getIntRedSube() == 1)
		{
			if(boletosRedSube.get(boletosRedSube.size()-1).getIntRedSube()==1) porcentajeDescuento = 0.5f;//50%
			if(boletosRedSube.get(boletosRedSube.size()-1).getIntRedSube()>=2) porcentajeDescuento = 0.75f;//75%
			intRedSube = boletosRedSube.get(boletosRedSube.size()-1).getIntRedSube() +1;		
		}
		
		nuevoBoleto.setMonto(nuevoBoleto.getMonto()-(nuevoBoleto.getMonto()*porcentajeDescuento));
		nuevoBoleto.setIntRedSube(intRedSube);
		
		
	}
}
