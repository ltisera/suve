<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<TITLE>Agregar viajes</TITLE>
<link rel="stylesheet" type="text/css" href="css/estilos.css">
<script src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/TraemeLasListas.js"></script>

<script>
	$(document).ready(function() {
		/*Ocultamos los elementos al inicio*/
		ocultarElementos();
		traerListaTarjetas();
		$("#colBolMue").hide();

		/*Cambios en los inputs*/
		$("#inpTarjeta").change(cambiaTarjeta);
		$("#inpTipoTransporte").change(cambiaTipoTransporte);
		$("#inpLinea").change(cambiaLinea);
		$("#inpEstacion").change(cambiaEstacion);
		$("#inpLectora").change(cambiaLectora);
		OcultaDiv();
		
		$("#btnAgregar").click(agregarViaje);
	});

function OcultaDiv(){
	$("#divEstadoBoleto").hide();
}


function agregarViaje(){

	var unafecha = "" + f.getDate()+"/"+f.getMonth()+"/"+f.getFullYear() + " * " + f.getHours()+":"+f.getMinutes()+":"+f.getSeconds()
	var numTarjeta = parseInt($("#inpTarjeta").val());

	if (isNaN(numTarjeta)) {
		alert("No estas mandando numeros");
	} else {
		$.ajax({
			data : {
				"numSerieTarjeta" : $("#inpTarjeta").val(),
				"numSerieLectora": $("#inpLectora").val(),
				"linea": $("#inpLinea").val(),
				"estacion": $("#inpEstacion").val(),
				"tipoTransporte":$("#inpTipoTransporte").val(),
				"fdia": f.getDate(),
				"fmes": f.getMonth(),
				"fanio": f.getFullYear(),
				"fhora": f.getHours(),
				"fminuto": f.getMinutes(),
				"fsegundo": f.getSeconds()

				
			},
			url : "AgregarBoleto",
			type : "POST",
			beforeSend : function() {
				$("#lblEstadoBoleto").html("Generando Boleto");
				$("#divEstadoBoleto").show();
				
				
			},
			success : function(response) {
				console.log("Esta es la response");
				console.log(response);
				traerUltimosViajes();
				$("#lblEstadoBoleto").html("Boleto Creado Correctamente");
				$("#divEstadoBoleto").show();
				$("#divMostrarBoleto").html(response);
				setTimeout(OcultaDiv,2000);
				
			},
			error : function(response) {
				$("#lblEstadoBoleto").html("El boleto no se pudo Generar");
				$("#divEstadoBoleto").show();
				setTimeout(OcultaDiv,2000);
			}
		});
	}

}


function cambiaTarjeta(){
	if($("#inpTarjeta").val() != ""){
		traerUltimosViajes();
		$("#colTrans").show();	
	}
	else{
		ocultarElementos();
		$("#inpTipoTransporte").val("Vacio");
		cambiaTipoTransporte();
	}
}
	
function cambiaTipoTransporte(){
	if ($("#inpTipoTransporte").val() != "Vacio") {
		console.log("VA");
		traerListaLineas();
		console.log("Viene");
		$("#colLinea").show();
	}
	else{
		$("#colLinea").hide();
		$("#inpLinea").val("");
		cambiaLinea();
	}

	if ($("#inpTipoTransporte").val() == "Colectivo") {
		$("#lblEstacion").html("Ingrese la Seccion:");		
	}
	else{
		$("#lblEstacion").html("Ingrese la Estacion:");		
	}
	
	
}
function cambiaLinea() {
	if($("#inpLinea").val()!=""){
		traerListaEstaciones();
		$("#colEstacion").show()	
	}
	else{
		$("#colEstacion").hide();
		$("#inpEstacion").val("");
		cambiaEstacion();
	}
}

function cambiaEstacion() {
	
	if($("#inpEstacion").val()!=""){
		traerListaLectoras();
		$("#colLectora").show();
	}
	else{
		$("#colLectora").hide();
		$("#inpLectora").val("");
		cambiaLectora();
	}
}

function cambiaLectora() {
	if($("#inpLectora").val()!=""){
		$("#btnAgregar").show();
		
	}
	else{
		$("#btnAgregar").hide();
	}
}

function ocultarElementos(){
	$("#colTrans").hide();
	$("#colLinea").hide();
	$("#colLectora").hide();
	$("#colEstacion").hide();
	$("#btnAgregar").hide();
}




</script>

</HEAD>

<body>
	<div id="divGeneralAgrega">
		<h1>Agregado de 1 Boleto</h1>
		<form>
	
			<div id="colNumTar">
					<label>Ingrese el numero de tarjeta:</label>
					<br>
					<input id="inpTarjeta" name="numTarjeta" list="lstTarjetas"></input>
					<datalist id="lstTarjetas"></datalist>
			</div>
			<div id="colTrans" >
				<label id="lblTipoTransporte">Seleccione Transporte:</label> <br>
				<select id="inpTipoTransporte" >
					<option value="Vacio">Elija una opcion:</option>
					<option value="Tren">Tren</option>
					<option value="Subte">Subte</option>
					<option value="Colectivo">Colectivo</option>
				</select>
			</div>
			<div id="colLinea" >
				<label id="lblLinea">Seleccione la Linea:</label> <br>
				<select id="inpLinea">

				</select>
			</div>
			
			<div id="colEstacion">
				<label id="lblEstacion">Seleccione una Opcion:</label> <br>
				<select id="inpEstacion">
					<option value="Construir Lista de Estaciones">
				</select>
			</div>
		
			<div id="colLectora">
				<label id="lblLectora">Seleccione la Lectora:</label> <br>
				<select id="inpLectora">
					<option value="Construir Lista de Lectora">
				</select>
			</div>
			<div id="colAgregar">
				<INPUT id="btnAgregar" type="button" class="btn btn-success" value="Agregar"></input>
			</div>
		
			

			
			<div id="divEstadoBoleto">
				<label id="lblEstadoBoleto">Generando Boleto</label>
			</div>
		</form>
	</div>
	<div id="divDatosTarjeta">
	</div>

	

	
</body>
</html>