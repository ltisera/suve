<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Datos</title>
<link rel="stylesheet" type="text/css" href="css/estilos.css">
<script src="js/jquery-3.3.1.js"></script>
<script>
$(document).ready(function() {
	$("#divBotonDarBaja").mouseenter(entraMouseBotonDarBaja);
	$("#divBotonDarBaja").mouseleave(saleMouseBotonDarBaja);
	$("#divBotonDarBaja").mousedown(apretaMouseBotonDarBaja);
	$("#divBotonDarBaja").mouseup(sueltaMouseBotonDarBaja);
	
	$("#divBotonDarAlta").mouseenter(entraMouseBotonDarAlta);
	$("#divBotonDarAlta").mouseleave(saleMouseBotonDarAlta);
	$("#divBotonDarAlta").mousedown(apretaMouseBotonDarAlta);
	$("#divBotonDarAlta").mouseup(sueltaMouseBotonDarAlta);
		
});

function apretaMouseBotonDarBaja() {
	etq = document.getElementById("lblBotonDarBaja");
	etq.style.marginTop = "2px";
	etq.style.marginLeft = "3px";
}
function sueltaMouseBotonDarBaja() {
	etq.style.marginTop = "0px";
	etq.style.marginLeft = "0px";
	darBaja();
}

function entraMouseBotonDarBaja() {
	miboton = document.getElementById("divBotonDarBaja");
	miboton.style.backgroundColor = "#3F608B";
}
function saleMouseBotonDarBaja() {
	miboton = document.getElementById("divBotonDarBaja");
	miboton.style.backgroundColor = "#7092be";
}

function apretaMouseBotonDarAlta() {
	etq = document.getElementById("lblBotonDarAlta");
	etq.style.marginTop = "2px";
	etq.style.marginLeft = "3px";
}
function sueltaMouseBotonDarAlta() {
	etq.style.marginTop = "0px";
	etq.style.marginLeft = "0px";
	darAlta();
}

function entraMouseBotonDarAlta() {
	miboton = document.getElementById("divBotonDarAlta");
	miboton.style.backgroundColor = "#3F608B";
}
function saleMouseBotonDarAlta() {
	miboton = document.getElementById("divBotonDarAlta");
	miboton.style.backgroundColor = "#7092be";
}

function darBaja() {
	if(confirm("¿Esta seguro que quiere dar de baja la tarjeta "+$("#divNroSerieDatos").val()+"?")){
		$.ajax({
			data : {
				"operacion": "Baja",
				"numSerieTarjeta" : $("#divNroSerieDatos").val(),
			},
			url : "DatosUsuario",
			type : "POST",
			beforeSend : function() {
				//$("#lblRespuesta").html("Realizando carga");
			},
			success : function(response) {
				$("#divMostrarTarjeta").hide()
				$("#divAgregarTarjeta").show()
				$("#divNroSerieDatos").html("");
				$("#divMontoDatos").html("");
			},
			error : function(response) {
				console.log("Error Baja");
			}
		});

	}else{
		console.log("No gracias, no quiero dar de baja");
	}
}


function darAlta() {
	$.ajax({
		data : {
			"operacion": "Alta",
			"numSerieTarjeta" : $("#inpTarjetaDatos").val(),
		},
		url : "DatosUsuario",
		type : "POST",
		beforeSend : function() {
			//$("#lblRespuesta").html("Realizando carga");
		},
		success : function(response) {
			$("#divNroSerieDatos").html(response.numSerieTarjeta);
			$("#divMontoDatos").html(response.monto);
			$("#divMostrarTarjeta").show()
			$("#divAgregarTarjeta").hide()
		},
		error : function(response) {
			console.log("Error Alta");
		}
	});
}

function traerDatos() {
	$.ajax({
		data : {
			"operacion": "Datos",
			"dni" : $("#inpUser").val(),
		},
		url : "DatosUsuario",
		type : "POST",
		beforeSend : function() {
			//$("#lblRespuesta").html("Realizando carga");
		},
		success : function(response) {
			$("#divApellidoDatos").html(response.apellido);
			$("#divNombreDatos").html(response.nombre);
			$("#divDniDatos").html(response.dni);
			$("#divMailDatos").html(response.mail);
			if(response.numSerieTarjeta != -1){
				$("#divNroSerieDatos").html(response.numSerieTarjeta);
				$("#divMontoDatos").html(response.monto);
				$("#divMostrarTarjeta").show()
				$("#divAgregarTarjeta").hide()
			}else{
				$("#divMostrarTarjeta").hide()
				$("#divAgregarTarjeta").show()
				$("#divNroSerieDatos").html("");
				$("#divMontoDatos").html("");
			}
		},
		error : function(response) {
			console.log("Error al traer los datos");
		}
	});
}
</script>
</head>
<body>
	<div id="divContDatos">
		<div id="divSupDatos">
			<div class="colDatosA">
				<br>Datos:
				<br> 
				<br>Apellido: 
				<br>Nombre: 
				<br>Dni: 
				<br>Mail:
			</div>
			<div class="colDatosB">
				<br>
				<br>
				<br><label id="divApellidoDatos"> Perez</label> 
				<br><label id="divNombreDatos"> Juan</label>
				<br><label id="divDniDatos"> 40000000</label> 
				<br><label id="divMailDatos"> algo@gmail.com</label>
			</div>
		</div>
		<div id="divMostrarTarjeta" class="divInfDatos">
			<div id="divTarjetaDatos">
				<div id="colTarjetaDatos">
					<br>Tarjeta:
					<br>
					<br>Numero de Serie: 
					<br>Monto:
				</div>
				<div class="colDatosA">
					<br>
					<br>
					<br><label id="divNroSerieDatos">11111 </label> 
					<br><label id="divMontoDatos">$500 </label>
				</div>
			</div>
			<div id=divBotonDarBaja class="clsDivBoton">
					<label id="lblBotonDarBaja" class="clsLblBoton">Dar de baja</label>
			</div>
		</div>
		<div id="divAgregarTarjeta" class="divInfDatos">
				<br>Ingrese numero de serie:
				<br><input id="inpTarjetaDatos" class="selTextSmall"></input> 
			<div id=divBotonDarAlta class="clsDivBoton">
					<label id="lblBotonDarAlta" class="clsLblBoton">Dar de alta</label>
			</div>
		</div>
		
	</div>
	
</body>
</html>