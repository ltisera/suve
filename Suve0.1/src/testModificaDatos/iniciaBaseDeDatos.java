package testModificaDatos;


import java.util.List;

import dao.*;
import datos.*;

public class iniciaBaseDeDatos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis() ;
		agregaTransporteEstacion();
		agregaLectora();
		agregaSeccionTramoColectivo();
		TestAgregarTramosDeEntradaTrenYSubte.main(args);
		tCargarMultiplesUsuariosYTarjetas.main(args);
		testAgregaBeneficio.main(args);
		testCargarMovimientosEnBaseDeDatos.main(args);
		
		long endTime = System.currentTimeMillis()  - startTime; 
		System.out.println("Base inicializada en: " + endTime);
	}

	public static void agregaTransporteEstacion() {
		EstacionDao edao = new EstacionDao();
		TransporteDao tdao = new TransporteDao();

		//Trenes

		long idTransporte = tdao.agregar(new Transporte("Roca", TipoTransporte.Tren));
		Transporte t = tdao.traerTransporte(idTransporte);

		edao.agregar(new Estacion(t, "Glew"));
		edao.agregar(new Estacion(t, "Longchamps"));
		edao.agregar(new Estacion(t, "Burzaco"));
		edao.agregar(new Estacion(t, "Adrogue"));
		edao.agregar(new Estacion(t, "Temperley"));
		edao.agregar(new Estacion(t, "Lomas"));
		edao.agregar(new Estacion(t, "Banfield"));
		edao.agregar(new Estacion(t, "Escalada"));
		edao.agregar(new Estacion(t, "Lanus"));
		edao.agregar(new Estacion(t, "Gerli"));
		edao.agregar(new Estacion(t, "D.Santillan y M.Kosteki"));
		edao.agregar(new Estacion(t, "Hipolito Yrigoyen"));
		edao.agregar(new Estacion(t, "Pza. Constitucion"));

		idTransporte = tdao.agregar(new Transporte("Sarmiento", TipoTransporte.Tren));
		t = tdao.traerTransporte(idTransporte);

		edao.agregar(new Estacion(t, "Once"));
		edao.agregar(new Estacion(t, "Caballito"));
		edao.agregar(new Estacion(t, "Flores"));
		edao.agregar(new Estacion(t, "Villa Luro"));
		edao.agregar(new Estacion(t, "Ciudadela"));
		edao.agregar(new Estacion(t, "Ramos Mejia"));
		edao.agregar(new Estacion(t, "Haedo"));
		edao.agregar(new Estacion(t, "Moron"));
		edao.agregar(new Estacion(t, "Castelar"));
		edao.agregar(new Estacion(t, "Ituzaingo"));
		edao.agregar(new Estacion(t, "S.A. Padua"));
		edao.agregar(new Estacion(t, "Merlo"));
		edao.agregar(new Estacion(t, "Paso del Rey"));
		edao.agregar(new Estacion(t, "Moreno"));

		//Subte
		idTransporte = tdao.agregar(new Transporte("Linea A", TipoTransporte.Subte));
		t = tdao.traerTransporte(idTransporte);

		edao.agregar(new Estacion(t, "San Pedrito"));
		edao.agregar(new Estacion(t, "San Jose de Flores"));
		edao.agregar(new Estacion(t, "Carabobo"));

		idTransporte = tdao.agregar(new Transporte("Linea B", TipoTransporte.Subte));
		t = tdao.traerTransporte(idTransporte);

		edao.agregar(new Estacion(t, "J.M. de Rosas"));
		edao.agregar(new Estacion(t, "Echeverría"));
		edao.agregar(new Estacion(t, "Los Incas"));

		idTransporte = tdao.agregar(new Transporte("Linea C", TipoTransporte.Subte));
		t = tdao.traerTransporte(idTransporte);

		edao.agregar(new Estacion(t, "Constitucion"));
		edao.agregar(new Estacion(t, "San Juan"));
		edao.agregar(new Estacion(t, "Independencia"));

		idTransporte = tdao.agregar(new Transporte("Linea D", TipoTransporte.Subte));
		t = tdao.traerTransporte(idTransporte);

		edao.agregar(new Estacion(t, "Congreso de Tucuman"));
		edao.agregar(new Estacion(t, "Juramento"));
		edao.agregar(new Estacion(t, "Jose Hernandez"));

		idTransporte = tdao.agregar(new Transporte("Linea E", TipoTransporte.Subte));
		t = tdao.traerTransporte(idTransporte);

		edao.agregar(new Estacion(t, "Plaza de los Virreyes"));
		edao.agregar(new Estacion(t, "Varela"));
		edao.agregar(new Estacion(t, "Medalla Milagrosa"));

		idTransporte = tdao.agregar(new Transporte("Linea H", TipoTransporte.Subte));
		t = tdao.traerTransporte(idTransporte);

		edao.agregar(new Estacion(t, "Hospitales"));
		edao.agregar(new Estacion(t, "Parque Patricios"));
		edao.agregar(new Estacion(t, "Caseros"));

		//Colectivo
		for(int i=0; i<10;i++)
		{
			tdao.agregar(new Transporte("11"+i, TipoTransporte.Colectivo));
			tdao.agregar(new Transporte("2"+i+"1", TipoTransporte.Colectivo));
			tdao.agregar(new Transporte("43"+i, TipoTransporte.Colectivo));
			tdao.agregar(new Transporte("5"+i+"3", TipoTransporte.Colectivo));
		}
	}
	
	public static void agregaLectora() {
		LectoraDao ldao = new LectoraDao();
		EstacionDao edao = new EstacionDao();
		int numeroSerieLectora = 3331000;
		for (Estacion e:edao.traerEstacion()){
			for(int i=0; i<=10;i++)
			{
				ldao.agregar(new LectoraEstacion(e,numeroSerieLectora));
				numeroSerieLectora++;
			}
		}
		TransporteDao tdao = new TransporteDao();
		for(Transporte t:tdao.traerLineasPorTransporte(TipoTransporte.Colectivo)) {
			for(int i=0; i<=10;i++)
			{
				ldao.agregar(new LectoraColectivo(t,numeroSerieLectora));
				numeroSerieLectora++;
			}
		}
	}
	
	public static void agregaSeccionTramoColectivo(){
		SeccionViajeDao sdao = new SeccionViajeDao();
		TramoColectivoDao tdao = new TramoColectivoDao();
		sdao.agregar(new SeccionViaje("Unica Seccion", 7.5f,TipoTransporte.Subte));
		
		long idSeccion = sdao.agregar(new SeccionViaje("1era Seccion", 3f,TipoTransporte.Tren));
		SeccionViaje s1 = sdao.traerSeccionViaje(idSeccion);
		
		idSeccion = sdao.agregar(new SeccionViaje("2da Seccion", 4.5f,TipoTransporte.Tren));
		SeccionViaje s2 = sdao.traerSeccionViaje(idSeccion);
		
		idSeccion = sdao.agregar(new SeccionViaje("3era Seccion", 6.25f,TipoTransporte.Tren));
		SeccionViaje s3 = sdao.traerSeccionViaje(idSeccion);
		
		agregarTramoTren(s1,s2,s3);
		
		idSeccion = sdao.agregar(new SeccionViaje("1era Seccion", 9f,TipoTransporte.Colectivo));
		SeccionViaje s = sdao.traerSeccionViaje(idSeccion);
		tdao.agregar(new TramoColectivo(0f,3f,s));
		
		idSeccion = sdao.agregar(new SeccionViaje("2da Seccion", 9.25f,TipoTransporte.Colectivo));
		s = sdao.traerSeccionViaje(idSeccion);
		tdao.agregar(new TramoColectivo(3f,6f,s));
		
		idSeccion = sdao.agregar(new SeccionViaje("3era Seccion", 9.5f,TipoTransporte.Colectivo));
		s = sdao.traerSeccionViaje(idSeccion);
		tdao.agregar(new TramoColectivo(6f,12f,s));
		
		idSeccion = sdao.agregar(new SeccionViaje("4ta Seccion", 10.25f,TipoTransporte.Colectivo));
		s = sdao.traerSeccionViaje(idSeccion);
		tdao.agregar(new TramoColectivo(12f,30f,s));
		
		idSeccion = sdao.agregar(new SeccionViaje("5ta Seccion", 10.75f,TipoTransporte.Colectivo));
		s = sdao.traerSeccionViaje(idSeccion);
		tdao.agregar(new TramoColectivo(30f,-1f,s));
	}
	
	public static void agregarTramoTren(SeccionViaje s1, SeccionViaje s2, SeccionViaje s3) {
		TransporteDao tdao = new TransporteDao();
		EstacionDao edao = new EstacionDao();
		TramoTrenYSubteDao tramodao = new TramoTrenYSubteDao();
		List<Estacion> lista = edao.traerEstacionPorTransporte(tdao.traerTransporte("Sarmiento").getIdTransporte());
		Estacion estacionA = null;
		Estacion estacionB = null;
		for (int i = 0; i< lista.size() ; i++) {
			estacionA = lista.get(i);
			for (int j = i+1; j< lista.size() ; j++) {
				estacionB = lista.get(j);
				if(j-i < 4) {
					tramodao.agregar(new TramoTrenYSubte(estacionA,estacionB,s1));
				}
				else if (j-1 < 8) {

					tramodao.agregar(new TramoTrenYSubte(estacionA,estacionB,s2));
				}else {

					tramodao.agregar(new TramoTrenYSubte(estacionA,estacionB,s3));
				}
			}
		}
		lista = edao.traerEstacionPorTransporte(tdao.traerTransporte("Roca").getIdTransporte());
		
		estacionA = edao.traerEstacion("Glew");
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Longchamps"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Burzaco"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Adrogue"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Temperley"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Lomas"),s2));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Banfield"),s2));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Escalada"),s2));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Lanus"),s2));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Gerli"),s2));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("D.Santillan y M.Kosteki"),s2));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Hipolito Yrigoyen"),s2));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Pza. Constitucion"),s3));

		estacionA = edao.traerEstacion("Longchamps");
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Burzaco"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Adrogue"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Lomas"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Temperley"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Banfield"),s2));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Escalada"),s2));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Lanus"),s2));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Gerli"),s2));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("D.Santillan y M.Kosteki"),s2));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Hipolito Yrigoyen"),s2));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Pza. Constitucion"),s2));
		
		estacionA = edao.traerEstacion("Burzaco");
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Adrogue"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Lomas"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Banfield"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Escalada"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Lanus"),s2));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Gerli"),s2));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("D.Santillan y M.Kosteki"),s2));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Hipolito Yrigoyen"),s2));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Pza. Constitucion"),s2));

		estacionA = edao.traerEstacion("Adrogue");
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Temperley"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Lomas"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Banfield"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Escalada"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Lanus"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Gerli"),s2));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("D.Santillan y M.Kosteki"),s2));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Hipolito Yrigoyen"),s2));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Pza. Constitucion"),s2));

		estacionA = edao.traerEstacion("Temperley");
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Lomas"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Banfield"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Escalada"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Lanus"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Gerli"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("D.Santillan y M.Kosteki"),s2));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Hipolito Yrigoyen"),s2));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Pza. Constitucion"),s2));

		estacionA = edao.traerEstacion("Lomas");
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Banfield"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Escalada"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Lanus"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Gerli"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("D.Santillan y M.Kosteki"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Hipolito Yrigoyen"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Pza. Constitucion"),s2));

		estacionA = edao.traerEstacion("Banfield");
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Escalada"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Lanus"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Gerli"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("D.Santillan y M.Kosteki"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Hipolito Yrigoyen"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Pza. Constitucion"),s2));

		estacionA = edao.traerEstacion("Escalada");
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Lanus"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Gerli"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("D.Santillan y M.Kosteki"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Hipolito Yrigoyen"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Pza. Constitucion"),s1));

		estacionA = edao.traerEstacion("Lanus");
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Gerli"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("D.Santillan y M.Kosteki"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Hipolito Yrigoyen"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Pza. Constitucion"),s1));
		
		estacionA = edao.traerEstacion("Gerli");
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("D.Santillan y M.Kosteki"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Hipolito Yrigoyen"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Pza. Constitucion"),s1));

		estacionA = edao.traerEstacion("D.Santillan y M.Kosteki");
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Hipolito Yrigoyen"),s1));
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Pza. Constitucion"),s1));

		estacionA = edao.traerEstacion("Hipolito Yrigoyen");
		tramodao.agregar(new TramoTrenYSubte(estacionA,edao.traerEstacion("Pza. Constitucion"),s1));
		
		

	}

}


