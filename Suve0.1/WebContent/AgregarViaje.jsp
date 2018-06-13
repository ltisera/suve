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
		
		$("#divBoton").mouseenter(entraMouseAAgregar);
		$("#divBoton").mouseleave(saleMouseAAgregar);
		$("#divBoton").mousedown(apretaMouseAAgregar);
		$("#divBoton").mouseup(sueltaMouseAAgregar);
		

		//$("#btnAgregar").click(agregarViaje);
	});

function OcultaDiv(){
	$("#divEstadoBoleto").hide();
}

function apretaMouseAAgregar(){
	etq=document.getElementById("lblAgregar");
	etq.style.marginTop="2px";
	etq.style.marginLeft="3px";
}
function sueltaMouseAAgregar(){
	etq.style.marginTop="0px";
	etq.style.marginLeft="0px";
	agregarViaje();
}

function entraMouseAAgregar(){
	miboton=document.getElementById("divBoton");
	miboton.style.backgroundColor = "#3F608B";
}
function saleMouseAAgregar(){
	miboton=document.getElementById("divBoton");
	miboton.style.backgroundColor = "#7092be";
}


function previsualizarViaje(){
	procesaViaje("previsualizar");
}

function agregarViaje(){
	procesaViaje("agregar");
}

function procesaViaje(queOpera){

	var numTarjeta = parseInt($("#inpTarjeta").val());
	
	if (isNaN(numTarjeta)) {
		alert("No estas mandando numeros");
	} else {
		$.ajax({
			data : {
				"operacion": queOpera,
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
				$("#divEstadoBoleto").html(response);
				$("#divEstadoBoleto").show();
				
			},
			error : function(response) {
				console.log(response);
				$("#divEstadoBoleto").html("El boleto no se pudo generar, " + response.responseText);
				$("#divEstadoBoleto").show();
				
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
		$("#inpTipoTransporte").val("Vacio").change();
	}
}
	
function cambiaTipoTransporte(){
	if ($("#inpTipoTransporte").val() != "Vacio") {
		traerListaLineas();
		$("#colLinea").show();
		if ($("#inpTipoTransporte").val() == "Colectivo") {
			$("#lblEstacion").html("Ingrese la Seccion:");		
		}
		else{
			$("#lblEstacion").html("Ingrese la Estacion:");		
		}
	}
	else{
		$("#colLinea").hide();
		$("#inpLinea").val("Vacio").change();
	}
}
function cambiaLinea() {
	if($("#inpLinea").val()!="Vacio" && $("#inpLinea").val()!=null){
		console.log("Mirame el vacio");
		console.log($("#inpLinea").val());
		traerListaEstaciones();
		$("#colEstacion").show()	
	}
	else{
		$("#colEstacion").hide();
		$("#inpEstacion").val("Vacio").change();
	}
}

function cambiaEstacion() {
	
	if($("#inpEstacion").val()!="Vacio" && $("#inpEstacion").val()!=null){
		traerListaLectoras();
		$("#colLectora").show();
	}
	else{
		$("#colLectora").hide();
		$("#inpLectora").val("Vacio").change();
	}
}

function cambiaLectora() {
	if($("#inpLectora").val()!="Vacio" && $("#inpLectora").val()!=null){
		$("#colAgregar").show();
		previsualizarViaje();
	}
	else{
		$("#colAgregar").hide();
	}
}

function ocultarElementos(){
	$("#colTrans").hide();
	$("#colLinea").hide();
	$("#colLectora").hide();
	$("#colEstacion").hide();
	$("#colAgregar").hide();
}




</script>

</HEAD>

<body>
	<div id="divGeneralAgrega">
		<h1>Agregar Boleto</h1>
		<form>
	
			<div id="colNumTar">
					<label>Ingrese el numero de tarjeta:</label>
					<br>
					<input id="inpTarjeta" name="numTarjeta" list="lstTarjetas" class="selText"></input>
					<datalist id="lstTarjetas"></datalist>
			</div>
			<div id="colTrans" >
				<label id="lblTipoTransporte">Seleccione Transporte:</label> <br>
				<select id="inpTipoTransporte" class="selText">
					<option value="Vacio">Elija una opcion:</option>
					<option value="Tren">Tren</option>
					<option value="Subte">Subte</option>
					<option value="Colectivo">Colectivo</option>
				</select>
			</div>
			<div id="colLinea" >
				<label id="lblLinea">Seleccione la Linea:</label> <br>
				<select id="inpLinea" class="selText">

				</select>
			</div>
			
			<div id="colEstacion">
				<label id="lblEstacion">Seleccione una Opcion:</label> <br>
				<select id="inpEstacion" class="selText">
					<option value="Construir Lista de Estaciones">
				</select>
			</div>
		
			<div id="colLectora">
				<label id="lblLectora">Seleccione la Lectora:</label> <br>
				<select id="inpLectora" class="selText">
					<option value="Construir Lista de Lectora">
				</select>
			</div>
			<div id="colAgregar">
				<div id=divBoton>
					<label id="lblAgregar">Agregar</label>
				</div>		
			</div>
		
			
			<div id="divEstadoBoleto">
				
			</div>
		</form>
	</div>
	<div id="divDatosTarjeta">
	</div>

	

	
</body>
</html>