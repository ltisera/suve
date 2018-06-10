<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title>Inicio</title>
<link rel="stylesheet" type="text/css" href="css/estilos.css">
<script src="js/jquery-3.3.1.js"></script>
<script>
	$(document).ready(function() {

		$("#divBoton").mouseenter(entraMouseBoton);
		$("#divBoton").mouseleave(saleMouseBoton);
		$("#divBoton").mousedown(apretaMouseBoton);
		$("#divBoton").mouseup(sueltaMouseBoton);
	});

	function apretaMouseBoton() {
		etq = document.getElementById("lblBoton");
		etq.style.marginTop = "2px";
		etq.style.marginLeft = "3px";
	}
	function sueltaMouseBoton() {
		etq.style.marginTop = "0px";
		etq.style.marginLeft = "0px";
		ingresar();
	}

	function entraMouseBoton() {
		miboton = document.getElementById("divBoton");
		miboton.style.backgroundColor = "#3F608B";
	}
	function saleMouseBoton() {
		miboton = document.getElementById("divBoton");
		miboton.style.backgroundColor = "#7092be";
	}
	
	function ingresar() {
		$.ajax({
			data : {
				"user" : $("#inpUser").val(),
				"pass" : $("#inpPass").val(),
			},
			url : "IniciarSesion",
			type : "POST",
			/*
			beforeSend : function() {
				
			},
			*/
			success : function(response) {
				$("#divBienvenidoUsuario").html("Bievenido " + response);
				$("#divLoggin").hide();
			},
			error : function(response) {
				$("#divEstadoLoggin").html("Usuario y/o contraseña incorrectos");
			}
		});
	}
</script>
</head>
<body>
	<h1>Bienvenidos al sistema de gestion SUVE</h1>
	<div id="divIniciarSesion">
		<div id="divLoggin">
			<label id="lblUser">Usuario (DNI):</label> <input id="inpUser"></input>
			<br> 
			<label id="lblPass">Contraseña:</label> <input id="inpPass" type="password"></input>
			<br>
			<div id=divBoton>
				<label id="lblBoton">Ingresar</label>
			</div>
		</div>
		<div id="divEstadoLoggin"></div>
	</div>
	
	
</body>
</html>