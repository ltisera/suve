<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recarga</title>
<link rel="stylesheet" type="text/css" href="css/estilos.css">
<script src="js/jquery-3.3.1.js"></script>
<script>
	$(document).ready(function() {

		$("#divBotonRecarga").mouseenter(entraMouseBotonRecarga);
		$("#divBotonRecarga").mouseleave(saleMouseBotonRecarga);
		$("#divBotonRecarga").mousedown(apretaMouseBotonRecarga);
		$("#divBotonRecarga").mouseup(sueltaMouseBotonRecarga);
	});

	function apretaMouseBotonRecarga() {
		etq = document.getElementById("lblBotonRecarga");
		etq.style.marginTop = "2px";
		etq.style.marginLeft = "3px";
	}
	function sueltaMouseBotonRecarga() {
		etq.style.marginTop = "0px";
		etq.style.marginLeft = "0px";
		ingresar();
	}

	function entraMouseBotonRecarga() {
		miboton = document.getElementById("divBotonRecarga");
		miboton.style.backgroundColor = "#3F608B";
	}
	function saleMouseBotonRecarga() {
		miboton = document.getElementById("divBotonRecarga");
		miboton.style.backgroundColor = "#7092be";
	}

	function recarga() {
		$.ajax({
			data : {
				"monto" : $("#inpMontoR").val(),
				"numSerieTarjeta" : $("#inpTarjetaR").val(),
				"numSerieLectora" : $("#inpLectoraR").val(),
				"fdia" : f.getDate(),
				"fmes" : f.getMonth(),
				"fanio" : f.getFullYear(),
				"fhora" : f.getHours(),
				"fminuto" : f.getMinutes(),
				"fsegundo" : f.getSeconds()
			},
			url : "AgregarRecarga",
			type : "POST",
			beforeSend : function() {
			},
			success : function(response) {
			},
			error : function(response) {
			}
		});
	}
</script>
</head>
<body>

	<h1>Consultas de Movimientos</h1>
	<div>
		<label>Ingrese Tarjeta: </label><input id="inpTarjetaR" list="lstTarjetas"></input> 
		<br>
		<div id=divBotonRecarga class="clsDivBoton">
			<label id="lblBotonRecarga" class="clsLblBoton">Agregar</label>
		</div>
	</div>

</body>
</html>