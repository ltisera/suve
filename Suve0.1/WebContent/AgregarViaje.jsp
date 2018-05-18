<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<TITLE>Agregar viajes</TITLE>

<script src="js/jquery-3.3.1.js"></script>
<script>
	$(document).ready(function() {
		/*Ocultamos los elementos al inicio*/
		ocultarElementos();
		$("#colBolMue").hide();
		
		/*Seccion de pruebas
		var x = document.getElementById("mySelect");
	    var option = document.createElement("option");
	    option.text = "Kiwi";
	    x.add(option);
		*/
		var para = "da"
		var valor = "nulo";
		$.ajax({
			data:{
				"pedirLista": para,
				"valor": valor
				},
			url:"AgregarBoleto",
			type:"POST",
			success:function(response){
				/*
				var opcion = document.createElement("option");
				opcion.text = "Kiwi";
			    $("#inpTipoTransporte").append("Kiwo");
			    opcion.text = "naranja";
			    $("#inpTipoTransporte").append(opcion);
			    opcion.text = "pepino";
			    $("#inpTipoTransporte").append(opcion);
			    /*/
				
			    
			},
			error:function(response){
				alert("LA PUTA QUE TE PARIIOO");
			}
		});

		/*Cambios en los inputs*/
		$("#inpTarjeta").change(cambiaTarjeta);
		$("#inpTipoTransporte").change(cambiaTipoTransporte);
		$("#inpLinea").change(cambiaLinea);
		$("#inpEstacion").change(cambiaEstacion);
		$("#inpLectora").change(cambiaLectora);
		
		
		$("#btnAgregar").click(agregarViaje);
	});

function agregarViaje(){

	var numTarjeta = parseInt($("#inpTarjeta").val());
	var tipoTransporte = $("#inpTipoTransporte").val();
	var linea = $("#inpLinea")
	
	if (isNaN(numTarjeta)) {
		alert("No estas mandando numeros");
	} else {
		$.ajax({
			data : {
				"pedirLista" : "nahh",
				"numTarjeta" : numTarjeta,
				"tipoTransporte":tipoTransporte
			},
			url : "AgregarBoleto",
			type : "POST",
			beforeSend : function() {

			},
			success : function(response) {
			},
			error : function(response) {
				alert("Mal alla")
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
		$("#inpTipoTransporte").val("");
		cambiaTipoTransporte();
	}
}
	
function cambiaTipoTransporte(){
	if ($("#inpTipoTransporte").val() != "") {
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
	if ($("#inpTipoTransporte").val() != "Colectivo") {
		$("#lblEstacion").html("Ingrese la Estacion:");		
	}
	
	
}
function cambiaLinea() {
	if($("#inpLinea").val()!=""){
		$("#colEstacion").show();
		
	}
	else{
		$("#colEstacion").hide();
		$("#inpEstacion").val("");
		cambiaEstacion();
	}
}

function cambiaEstacion() {
	if($("#inpEstacion").val()!=""){
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
	/*
	$("#lblTipoTransporte").hide();
	$("#inpTipoTransporte").hide();
	*/
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

					</div>
					
					<div id="colBolMue" style="width: 60% S; background-color: coral;">
						<label style="color: white;"> ACA VA LO OTRO</label>
					</div>
					
				</div>
				<div id="colTrans" style="clear: both; float: left;">
					<label id="lblTipoTransporte">Seleccione Tipo de Transporte:</label> <br>
					<select id="inpTipoTransporte" >
						<option value="Tren">Tren</option>
						<option value="Subte">Subte</option>
						<option value="Colectivo">Colectivo</option>
					</select>
				</div>
				<div id="tblListaLinea">
					<div id="colLinea">
						<label id="lblLinea">Seleccione la Linea:</label> <br> 
						<input	id="inpLinea" list="lstLinea"></input>
						<datalist id="lstLinea">
							<option value="Construir Lista de linea">
							<option value="adsfa">
							<option value="blah blah blah">
						</datalist>
					</div>
					<div style="clear: both;">
						<div id="colEstacion">
							<label id="lblEstacion">Seleccione la Estacion:</label> <br>
							<input id="inpEstacion" list="lstEstaciones"></input>
							<datalist id="lstEstaciones">
								<option value="Construir Lista de linea">
								<option value="glew">
								<option value="Longchamps">
							</datalist>
						</div>
					</div>
					<div style="clear: both;">
						<div id="colLectora">
							<label id="lblLectora">Seleccione la Lectora:</label> <br>
							<input id="inpLectora" list="lstLectora"></input>
							<datalist id="lstLectora">
								<option value="Construir Lista de linea">
								<option value="Carga: lectora 2">
								<option value="Viaje: Lectora 18">
							</datalist>
						</div>
					</div>
					<INPUT id="btnAgregar" type="button" class="btn btn-success" value="Agregar"></input>
					
				</div>
			</form>
		</div>

	</div>


	<datalist id="lstTarjetas">
		<option value="Construir Lista de tarjeta">
		<option value="21x">
		<option value="Ch21ome">
		<option value="O21ra">
		<option value="Safari">
	</datalist>
</body>
</html>