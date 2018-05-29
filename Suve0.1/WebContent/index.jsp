<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<TITLE>SuViajes</TITLE>
<link rel="stylesheet" type="text/css" href="css/estilos.css">

<script src="js/jquery-3.3.1.js" type="text/javascript"></script>
<script>
	$(document).ready(function(){
		$("#divAgregarViaje").hide();
		$("#divManejaFecha").hide();
		$("#divConsultarMovimientos").hide();
		$("#divCargarSaldoEstudiantil").hide();
		$("#divInicio").show();
		
		$("#btnInicio").click(function() {
			$("#divManejaFecha").hide();
			$("#divAgregarViaje").hide();
			$("#divConsultarMovimientos").hide();
			$("#divCargarSaldoEstudiantil").hide();
			$("#divInicio").show();
		});
		
		$("#btnAgregarViaje").click(function() {
			$("#divInicio").hide();
			$("#divConsultarMovimientos").hide();
			$("#divCargarSaldoEstudiantil").hide();
			$("#divManejaFecha").show("fast");
			$("#divAgregarViaje").show("slow");
		});
		
		$("#btnConsultarMovimientos").click(function() {
			$("#divInicio").hide();
			$("#divManejaFecha").hide();
			$("#divAgregarViaje").hide();
			$("#divCargarSaldoEstudiantil").hide();
			$("#divConsultarMovimientos").show("slow");
		});
		
		$("#btnCargarSaldoEstudiantil").click(function() {
			$("#divInicio").hide();
			$("#divAgregarViaje").hide();
			$("#divConsultarMovimientos").hide();
			$("#divManejaFecha").show("fast");
			$("#divCargarSaldoEstudiantil").show("slow");
		});
		
	});
		
		
</script>

</HEAD>

<body>

	<div id="divCabecera">
		<div id="divFoto">
			<%@ include file="/cabecera.jsp"%>
		</div>
		<div id="divManejaFecha">
			<%@ include file="/manejaFecha.jsp"%>
		</div>

	</div>
	<table width="100%">
		<tr id="columnita">
			<th width="20%" valign="top" align="left" class="pepe">
				<!-- Contenedor del menu --> 
				<input id="btnInicio" type="button" value="Inicio" style="width: 150px"/> 
				<br> 
				<input id="btnAgregarViaje" type="button" value="Agregar Viaje"	style="width: 150px" /> 
				<br> 
				<input id="btnConsultarMovimientos" type="button" value="Consultar Movimientos" style="width: 150px" /> 
				<br> 
				<input id="btnCargarSaldoEstudiantil" type="button" value="Saldo Estudiantil" style="width: 150px" />

			</th>
			<th width="80%" align="left" class="pepe">
				<!-- Contenedor del contenido OMG -->
				<div id="divInicio" class="container">
					<h1>Bienvenidos al sistema de gestion SUVE</h1>
				</div>
				<div id="divAgregarViaje" class="container">
					<%@ include file="/AgregarViaje.jsp"%>
				</div>
				<div id="divConsultarMovimientos" class="container">
					<%@ include file="/ConsultarMovimientos.jsp"%>
				</div>
				<div id="divCargarSaldoEstudiantil" class="container">
					<%@ include file="/SaldoEstudiantil.jsp"%>
				</div>
			</th>
		</tr>
	</table>

</body>
</html>