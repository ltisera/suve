package funciones;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.hibernate.proxy.HibernateProxy;

public class Funciones {
	public static String TraeFechaYHora(GregorianCalendar fecha) {
		return fecha.get(Calendar.DATE)+"/"+fecha.get(Calendar.MONTH)+"/"+fecha.get(Calendar.YEAR) + " " + fecha.get(Calendar.HOUR_OF_DAY)+ ":" + fecha.get(Calendar.MINUTE)+ ":" +fecha.get(Calendar.SECOND);
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
	
}
