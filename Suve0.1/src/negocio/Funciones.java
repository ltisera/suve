package negocio;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;

import org.hibernate.proxy.HibernateProxy;

import datos.TarifaSocial;
import datos.Beneficio;
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
	
	public static void calcularTarifaSocialTren(Boleto nuevoBoleto, float montoBoletoEntrada, TarifaSocial tarifa)
	{
		float seccion = nuevoBoleto.getTramoTrenYSubte().getSeccionViaje().getMonto();
		float descuentoRedSube = calcularRedSube(nuevoBoleto.getIntRedSube());
		float seccionRedSube = seccion - (seccion*descuentoRedSube);
		float descuentoTarifa = tarifa.getPorcentajeDescuento()/100;
		nuevoBoleto.setMonto(-(montoBoletoEntrada - (seccionRedSube - (seccionRedSube * descuentoTarifa))));
	}
	
	public static  float calcularRedSube(int intRedSubeNuevoBoleto)
	{
		float porcentajeDescuento = 0;
		if(intRedSubeNuevoBoleto==2) 
			porcentajeDescuento = 0.5f;//50%
				
		if(intRedSubeNuevoBoleto>=3) 
			porcentajeDescuento = 0.75f;//75%	
		
		return porcentajeDescuento;		
	}

	public static boolean tarjetaContieneTarifaSocial(Set<Beneficio> beneficios, TarifaSocial tarifa) 
	{
		boolean contieneTarifa = false;
		for(Beneficio b: beneficios)
			if(b instanceof TarifaSocial) contieneTarifa = true;
		return contieneTarifa;
	}

	public static boolean tiempoDeViajeValido(GregorianCalendar fechaAnterior, GregorianCalendar fechaActual) 
	{
		//Hacer segundos(Fecha Actual) - segundos(Fecha anterior) <=  7200 segundos
		return (fechaActual.getTimeInMillis()-fechaAnterior.getTimeInMillis())<7200000;
	}
	
	public static float redondea2D(float valor) {
		float valTemp;
		int parteEntera = (int) valor;
		valTemp = valor - parteEntera;
		valTemp = valTemp * 100;
		
		
				
		return valor;
	}
}
