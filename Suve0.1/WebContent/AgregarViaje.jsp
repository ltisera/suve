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
		$("#lblTipoTransporte").hide();
		$("#inpTipoTransporte").hide();
		$("#lblLinea").hide();
		$("#inpLinea").hide();
		$("#lblLectora").hide();
		$("#inpLectora").hide();
		
		$("#lblEstacion").hide();
		$("#inpEstacion").hide();
		$("#btnAgregar").hide();
		
		$("#colBolMue").hide();
		
		
		/*Cambios en los inputs*/
		$("#idNumTarjeta").change(cambiaNumTarjeta);
		$("#inpTipoTransporte").change(cambiaTipoTransporte);
		$("#inpLinea").change(cambiaLinea);
		$("#btnAgregar").click(function() {
			var numTarjeta = parseInt($("#idNumTarjeta").val());
			if (isNaN(numTarjeta)) {
				alert("No estas mandando numeros");
			} else {
				$.ajax({
					data : {
						"numTarjeta" : numTarjeta
					},
					url : "AgregarBoleto",
					type : "POST",
					beforeSend : function() {

					},
					succes : function(response) {
					},
					error : function(response) {
						alert("Mal alla")
					}
				});
			}
		});
	});

function cambiaNumTarjeta(){
	if($("#numTarjeta").val() != ""){
		$("#inpTipoTransporte").show();
		$("#lblTipoTransporte").show();
	}
}
	
function cambiaTipoTransporte(){
	console.log($("#inpTipoTransporte").val());
	if ($("#inpTipoTransporte").val() != "") {
		$("#inpLinea").show();
		$("#lblLinea").show();
	}
	
	if ($("#inpTipoTransporte").val() == "Colectivo") {
		$("#lblEstacion").val("Putito");
		$("#lblEstacion").show();
		$("#inpEstacion").show();
		
		
	}
}
function cambiaLinea() {
	alert("ksdkf");
	if($("#inpLinea")!=""){
		$("#btnAgregar").show();
	}
}
</script>

</HEAD>

<body>
	<div class="jumbotron">
		<div></div>
		<div>
			<h1>Agregado de 1 Boleto</h1>
			<form>
				<div>
					<div id="wA" style="width: 100%">
						<div id="colNumTar" style="width: 25%; float: left;">
							<label>Ingrese el numero de tarjeta:</label> <br> <input
								id="idNumTarjeta" name="numTarjeta" list="lstTarjetas">

						</div>
						<div id="colBolMue" style="width: 60% S; background-color: coral;">
							<label style="color: white;"> ACA VA LO OTRO</label>
						</div>
					</div>
					<div id="colTrans" style="clear: both; float: left;">
						<label id="lblTipoTransporte">Seleccione Tipo de Transporte:</label> <br>
						<input id="inpTipoTransporte" list="lstTransporte"></input>
						<datalist id="lstTransporte">
							<option value="Tren">
							<option value="Subte">
							<option value="Colectivo">
						</datalist>
					</div>
					<div id="tblListaLinea">
						<label id="lblLinea">Seleccione la Linea:</label> <br> 
						<input	id="inpLinea" list="lstLinea"></input>
						<datalist id="lstLinea">
							<option value="Construir Lista de linea">
							<option value="adsfa">
							<option value="blah blah blah">
						</datalist>
						
						<div style="clear: both;">
							<div id="colEestacion">
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
								<label id="lblLectora">Seleccione la Estacion:</label> <br>
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