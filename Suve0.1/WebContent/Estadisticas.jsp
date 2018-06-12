<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Estadisticas</title>
<link rel="stylesheet" type="text/css" href="css/estilos.css">
<script src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/Chart.js"></script>
<script type="text/javascript" src="js/ajaxEstadisticas.js"></script>


<script>
	$(document).ready(function() {

		$("#divBtnGenerarReporte").mouseenter(entraMouseAGenerarReporte);
		$("#divBtnGenerarReporte").mouseleave(saleMouseAGenerarReporte);
		$("#divBtnGenerarReporte").mousedown(apretaMouseAGenerarReporte);
		$("#divBtnGenerarReporte").mouseup(sueltaMouseAGenerarReporte);
		$("#inpTipoTransporteE").change(cambiaTransporte);
		
		$("#divContEstadisticas").hide();

		
	});

function cambiaTransporte(){
	if($("#inpTipoLineaE").val() != "Vacio"){
		traerListaLineasE();
	}
}

function apretaMouseAGenerarReporte(){
	etq=document.getElementById("lblGenerarReporte");
	etq.style.marginTop="2px";
	etq.style.marginLeft="3px";
}
function sueltaMouseAGenerarReporte(){
	etq.style.marginTop="0px";
	etq.style.marginLeft="0px";
	generarReporte();
}

function entraMouseAGenerarReporte(){
	miboton=document.getElementById("divBtnGenerarReporte");
	miboton.style.backgroundColor = "#3F608B";
}
function saleMouseAGenerarReporte(){
	miboton=document.getElementById("divBtnGenerarReporte");
	miboton.style.backgroundColor = "#7092be";
}

</script>
</head>
<body>
	<div id="divContEYR">
		<div id="divContReportes">
			<select id="inpTipoReporteE">
				<option value="Vacio">Elija una opcion:</option>
					<option value="Tren">Reporte de Viajes Realizados</option>
					<option value="Subte">Estadisticas punto 14</option>
					<option value="Colectivo">Estadisticas punto 15</option>
			</select>
			<br>
			
			<select id="inpTipoTransporteE" class="selText">
				<option value="Vacio">Elija un Transporte:</option>
				<option value="Tren">Tren</option>
				<option value="Subte">Subte</option>
				<option value="Colectivo">Colectivo</option>
			</select>
			<select id="inpLineaE" class="selText">
				<option value="Vacio">Elija una Linea:</option>
			</select>
			
			<br>
			Fecha Inicio: <input type="date" id="inpFechaDesdeE">
			<br>
			Fecha Hasta: <input type="date" id="inpFechaHastaE">
			
			<div id="divBtnGenerarReporte" class="clsDivBoton">
				<label id="lblGenerarReporte" class="clsLblBoton">Generar Reporte</label>
			</div>
			<div id="divReporte">
				
			</div>
			<br>
			<div id="divTblReporte">
					
			</div>
		</div>
		
		
		
		
		<div id="divContEstadisticas" class="caja2px">
			
			<canvas id="myChart"></canvas>
			
			
		</div>
		
	</div>
</body>
</html>