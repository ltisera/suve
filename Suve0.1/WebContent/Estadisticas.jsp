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


<script>
	$(document).ready(function() {

		$("#divBtnGenerarReporte").mouseenter(entraMouseAGenerarReporte);
		$("#divBtnGenerarReporte").mouseleave(saleMouseAGenerarReporte);
		$("#divBtnGenerarReporte").mousedown(apretaMouseAGenerarReporte);
		$("#divBtnGenerarReporte").mouseup(sueltaMouseAGenerarReporte);

		
		var ctx = document.getElementById('myChart').getContext('2d');
		Chart.defaults.global.defaultFontSize = 18;
		Chart.defaults.global.defaultFontColor = 'white';
		var chart = new Chart(ctx, {
		    // The type of chart we want to create
		    type: 'bar',

		    // The data for our dataset
		    data: {
		        labels: ["Tren", "Colectivo", "Subte"],
		        datasets: [{
		            label: "QUE BOSTAS",
		            backgroundColor: [
		            	'rgb(255, 0, 0)',
		            	'rgb(0, 255, 0)',
		            	'rgb(0, 0, 255)'
			            ],
		            borderColor: 'rgb(0, 0, 0)',
		            data: [3, 10,4],
		        }]
		    },

		    // Configuration options go here
		    options: {
		    	responsive: true,
		        maintainAspectRatio: false,
		        scales: {
		            yAxes: [{
		                ticks: {
		                    beginAtZero:true
		                }
		            }]
		        }
			}
		});
	});



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
function generarReporte(){
	$.ajax({
		data : {
			"tipoReporte": $("#inpTipoReporteE").val(),
			"tipoTransporte" : $("#inpTipoTransporteE").val(),
			"fechaDesde" : $("#inpFechaDesdeE").val(),
			"fechaHasta" : $("#inpFechaHastaE").val(),
			
		},
		url : "Estadisticas",
		type : "POST",
		beforeSend : function() {
			$("#divTblReporte").html("");
			$("#divReporte").html("Realizando Reportes");
		},
		success : function(response) {
			console.log(response);
			$("#divReporte").html("Carga realizada exitosamente");
			var i = 0;
			
			for(i = 0; i < response.length;i++){
				console.log("Entro al bucle: " + i);
				console.log(response[i].fechaHora);
				console.log(response[i].numTarjeta);
				console.log(response[i].monto);
				var nFila = document.createElement("div");
				
				if(i%2 != 0){
					console.log("Una Par");
					nFila.className = "clsFilaImpar";
				} else {
					console.log("Una Impar");
					nFila.className = "clsFilaPar";
				}

				var cFecha = document.createElement("div");
				cFecha.className = "clsColFecha";
				cFecha.innerHTML = response[i].fechaHora;
				nFila.appendChild(cFecha)

				var cNumTarjeta = document.createElement("div");
				cNumTarjeta.className = "clsColNumTarjeta";
				cNumTarjeta.innerHTML = response[i].numTarjeta;
				nFila.appendChild(cNumTarjeta);

				var cMonto = document.createElement("div");
				cMonto.className = "clsColMonto";
				cMonto.innerHTML = response[i].monto;
				nFila.appendChild(cMonto);

				var tbl = document.getElementById("divTblReporte");
				tbl.appendChild(nFila);
			}
		},
		error : function(response) {
			$("#divReporte").html("Fallo la carga");
		}
	});
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
				<div id ="divFila">
					<div id="divColFecha" class="clsColFecha">
						Fecha
					</div>
					<div id="divColNumTarjeta" class="clsColNumTarjeta">
						Numero Tarjeta
					</div>
					<div id="divColMonto" class="clsColMonto">
						Monto
					</div>
				</div>	
			</div>
		</div>
		
		
		
		
		<div id="divContEstadisticas" class="caja2px">
			
			<canvas id="myChart"></canvas>
			
			
		</div>
		
	</div>
</body>
</html>