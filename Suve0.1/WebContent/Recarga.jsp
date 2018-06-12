<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recarga</title>
<link rel="stylesheet" type="text/css" href="css/estilos.css">
<script src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/TraemeLasListas.js"></script>

<script>
$(document).ready(function() {

	$("#divBotonRecarga").mouseenter(entraMouseBotonRecarga);
	$("#divBotonRecarga").mouseleave(saleMouseBotonRecarga);
	$("#divBotonRecarga").mousedown(apretaMouseBotonRecarga);
	$("#divBotonRecarga").mouseup(sueltaMouseBotonRecarga);

	$("#divBtnSaldoE").mouseenter(entraMouseBtnSaldoE);
	$("#divBtnSaldoE").mouseleave(saleMouseBtnSaldoE);
	$("#divBtnSaldoE").mousedown(apretaMouseBtnSaldoE);
	$("#divBtnSaldoE").mouseup(sueltaMouseBtnSaldoE);

	
			
});

function apretaMouseBotonRecarga() {
	etq = document.getElementById("lblBotonRecarga");
	etq.style.marginTop = "2px";
	etq.style.marginLeft = "3px";
}
function sueltaMouseBotonRecarga() {
	etq.style.marginTop = "0px";
	etq.style.marginLeft = "0px";
	recarga();
}

function entraMouseBotonRecarga() {
	miboton = document.getElementById("divBotonRecarga");
	miboton.style.backgroundColor = "#3F608B";
}
function saleMouseBotonRecarga() {
	miboton = document.getElementById("divBotonRecarga");
	miboton.style.backgroundColor = "#7092be";
}

function apretaMouseBtnSaldoE() {
	etq = document.getElementById("lblBtnSaldoE");
	etq.style.marginTop = "2px";
	etq.style.marginLeft = "3px";
}
function sueltaMouseBtnSaldoE() {
	etq.style.marginTop = "0px";
	etq.style.marginLeft = "0px";
	cargarSaldoEstudiantil();
}

function entraMouseBtnSaldoE() {
	miboton = document.getElementById("divBtnSaldoE");
	miboton.style.backgroundColor = "#3F608B";
}
function saleMouseBtnSaldoE() {
	miboton = document.getElementById("divBtnSaldoE");
	miboton.style.backgroundColor = "#7092be";
}

function inicializarInpRecarga(){
	$("#inpTarjetaR").val("");
	$("#inpPuntoCarga").val("Vacio");
	$("#inpMontoR").val("");
}

function cargarSaldoEstudiantil(){
	$.ajax({
		data : {
			"fdia": f.getDate(),
			"fmes": f.getMonth(),
			"fanio": f.getFullYear(),
			"fhora": f.getHours(),
			"fminuto": f.getMinutes(),
			"fsegundo": f.getSeconds()
		},
		url : "CargarBoletoEstudiantil",
		type : "POST",
		beforeSend : function() {
			$("#lblRespuesta").html("Cargando saldo estudiantil, espere...");
		},
		success : function(response) {
			$("#lblRespuesta").html("Saldo estudiantil cargado");
		},
		error : function(response) {
			$("#lblRespuesta").html(response.responseText);
		}
	});
}
function recarga() {
	$.ajax({
		data : {
			"monto" : $("#inpMontoR").val(),
			"numSerieTarjeta" : $("#inpTarjetaR").val(),
			"numSerieLectora" : $("#inpPuntoCarga").val(),
			"fdia" : f.getDate(),
			"fmes" : f.getMonth(),
			"fanio" : f.getFullYear(),
			"fhora" : f.getHours(),
			"fminuto" : f.getMinutes(),
			"fsegundo" : f.getSeconds()
		},
		url : "Recarga",
		type : "POST",
		beforeSend : function() {
			$("#lblRespuesta").html("Realizando carga");
		},
		success : function(response) {
			$("#lblRespuesta").html("Carga realizada exitosamente");
			inicializarInpRecarga()
		},
		error : function(response) {
			$("#lblRespuesta").html("Fallo la carga");
		}
	});
}
</script>
</head>
<body>

	<h1>Consultas de Movimientos</h1>
	<div>
		<div>
			<label>Ingrese Tarjeta: </label>
			<br>
			<input id="inpTarjetaR" list="lstTarjetas" class="selText"></input> 
		</div>
		<div>
			<label>Ingrese Punto de Carga: </label>
			<br>
			<select id="inpPuntoCarga" class="selText">
					<option value="Construir Lista de Lectora">
			</select> 
		</div>
		<div>
			<label>Ingrese Monto: </label>
			<br>
			<input id="inpMontoR" class="selText"></input> 
		</div>
		
		<div id=divBotonRecarga class="clsDivBoton">
			<label id="lblBotonRecarga" class="clsLblBoton">Agregar</label>
		</div>
		<div id=divBtnSaldoE>
			<label id="lblBtnSaldoE" class="clsLblBoton">Cargar Saldo Estudiantil</label>
		</div>
		<br>
		<label id="lblRespuesta"></label>
	</div>

</body>
</html>