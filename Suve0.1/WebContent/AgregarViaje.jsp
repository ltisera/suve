<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<TITLE>Agregar viajes</TITLE>
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
		setInterval(OcultaDiv, 3000);
		
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
				$("#lblEstadoBoleto").val("Generando Boleto");
				
			},
			success : function(response) {
				console.log("Esta es la response");
				console.log(response);
				$("#lblEstadoBoleto").html("Boleto Creado Correctamente");
				$("#divEstadoBoleto").show();
				$("#divMostrarBoleto").html(response);
			},
			error : function(response) {
				$("#lblEstadoBoleto").html("El boleto no se pudo Generar");
				$("#divEstadoBoleto").show();
			}
		});
	}

}


function cambiaTarjeta(){
	if($("#inpTarjeta").val() != ""){
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
	<div class="jumbotron">
		<div></div>
		<div>
			<h1>Agregado de 1 Boleto</h1>
			<form>
		
				<div id="wA" style="width: 100%">
					<div id="colNumTar" style="width: 25%; float: left;">
						<label>Ingrese el numero de tarjeta:</label>
						<br>
						<input id="inpTarjeta" name="numTarjeta" list="lstTarjetas"></input>
						<datalist id="lstTarjetas"></datalist>
					</div>
					
					<div id="colBolMue" style="width: 60% S; background-color: coral;">
						<label style="color: white;"> ACA VA LO OTRO</label>
					</div>
					
				</div>
				<div id="colTrans" style="clear: both; float: left;">
					<label id="lblTipoTransporte">Seleccione Tipo de Transporte:</label> <br>
					<select id="inpTipoTransporte" >
						<option value="Vacio">Elija una opcion:</option>
						<option value="Tren">Tren</option>
						<option value="Subte">Subte</option>
						<option value="Colectivo">Colectivo</option>
					</select>
				</div>
				<div id="tblListaLinea">
					<div id="colLinea">
						<label id="lblLinea">Seleccione la Linea:</label> <br>
						<select id="inpLinea">

						</select>
					</div>
					<div style="clear: both;">
						<div id="colEstacion">
							<label id="lblEstacion">Seleccione la Estacion:</label> <br>
							<select id="inpEstacion">
								<option value="Construir Lista de Estaciones">
							</select>
						</div>
					</div>
					<div style="clear: both;">
						<div id="colLectora">
							<label id="lblLectora">Seleccione la Lectora:</label> <br>
							<select id="inpLectora">
								<option value="Construir Lista de Lectora">
							</select>
						</div>
					</div>
					<INPUT id="btnAgregar" type="button" class="btn btn-success" value="Agregar"></input>
					
				</div>
				<div id="divEstadoBoleto">
					<label id="lblEstadoBoleto">ARRRRR</label>
				</div>
			</form>
		</div>

	</div>


	
</body>
</html>