package negocio;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.proxy.HibernateProxy;

import datos.TarifaSocial;
import datos.Tarjeta;
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
	
	
	public static  void calcularRedSube(List<Boleto> lstBoletosRedSube, Boleto nuevoBoleto)
	{
		float porcentajeDescuento = 0;
		int intRedSube = 1;
		System.out.println("***Size de la lista: " + lstBoletosRedSube.size());
		if (lstBoletosRedSube.size()!=0) {
			int intRedSubeAnterior = lstBoletosRedSube.get(lstBoletosRedSube.size()-1).getIntRedSube() ;
			if(lstBoletosRedSube.size()>0 && 
				intRedSubeAnterior != 0 && 
				intRedSubeAnterior <= lstBoletosRedSube.size() && 
				intRedSubeAnterior < 6)
			{
				if(intRedSubeAnterior==1) { 
					porcentajeDescuento = 0.5f;//50%
				}
				if(intRedSubeAnterior>=2) {
					porcentajeDescuento = 0.75f;//75%
				}
				intRedSube = intRedSubeAnterior + 1;		
			}
		}
		nuevoBoleto.setMonto(nuevoBoleto.getMonto()-(nuevoBoleto.getMonto()*porcentajeDescuento));
		nuevoBoleto.setIntRedSube(intRedSube);
		
		
	}

	public static boolean tarjetaContieneTarifaSocial(Object[] array, TarifaSocial tarifa) 
	{
		boolean contieneTarifa = false;
		for(Object o: array)
			if(o instanceof TarifaSocial) contieneTarifa = true;
		return contieneTarifa;
		
		
	}
	
	
	public static boolean tiempoDeViajeValido(GregorianCalendar fechaAnterior, GregorianCalendar fechaActual) 
	{
		//Hacer segundos(Fecha Actual) - segundos(Fecha anterior) <=  7200 segundos
		return sonFechasIguales(fechaAnterior, fechaActual) && fechaAnterior.get(Calendar.HOUR) > (fechaActual.get(Calendar.HOUR)-2) && fechaAnterior.get(Calendar.HOUR) <= fechaActual.get(Calendar.HOUR);
	}
	
	public static boolean sonFechasIguales(GregorianCalendar fechaAnterior,GregorianCalendar fechaActual)
	{
		return (fechaAnterior.get(Calendar.YEAR)==fechaActual.get(Calendar.YEAR) && fechaAnterior.get(Calendar.MONTH)==fechaActual.get(Calendar.MONTH) && fechaAnterior.get(Calendar.DAY_OF_MONTH)==fechaActual.get(Calendar.DAY_OF_MONTH));
	}
}
