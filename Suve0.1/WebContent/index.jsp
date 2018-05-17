<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html>

<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<TITLE>SuViajes</TITLE>


<script src="js/jquery-3.3.1.js" type="text/javascript"></script>
<script>
	$(document).ready(function(){
		$("#divAgregarViaje").hide();
		$("#divManejaFecha").hide();
		$("#divConsultarMovimientos").hide();
		
		$("#btnInicio").click(function() {
			$("#divInicio").show();
			$("#divManejaFecha").hide();
			$("#divAgregarViaje").hide();
			$("#divConsultarMovimientos").hide();
		});
		
		$("#btnAgregarViaje").click(function() {
			$("#divInicio").hide();
			$("#divManejaFecha").show("fast");
			$("#divAgregarViaje").show("slow");
			$("#divConsultarMovimientos").hide();
			
		});
		
		$("#btnConsultarMovimientos").click(function() {
			$("#divInicio").hide();
			$("#divManejaFecha").hide();
			$("#divAgregarViaje").hide();
			$("#divConsultarMovimientos").show("slow");
		});
		
	});
</script>

<script>
	
</script>


</HEAD>

<body style="background-color:#108CCC; color:#ffffff"  >

	<table width="100%">
		<tr>
			<th align="left">
				<%@ include file="/cabecera.jsp" %>
			</th>
			<th id="divManejaFecha" align="left">
				<%@ include file="/manejaFecha.jsp" %>
			</th>
		</tr>
	</table>
	<table width="100%">
		<tr>
			<th width="20%" valign="top" align="left">
				<!-- Contenedor del menu -->
				<input id="btnInicio" type="button" value="Inicio" style="width:150px"/>
				<br>
				<input id="btnAgregarViaje" type="button" value="Agregar Viaje" style="width:150px"/>
				<br>
				<input id="btnConsultarMovimientos" type="button" value="Consultar Movimientos" style="width:150px"/>
			
				
			</th>
			<th width="80%" align = "left">
				<!-- Contenedor del contenido OMG -->
				<div id="divInicio" class="container">
					<h1>Bienvenidos al sistema de gestion SUVE</h1>
				</div>
				<div id="divAgregarViaje" class="container">
					<%@ include file="/AgregarViaje.jsp" %>
				</div>
				<div id="divConsultarMovimientos" class="container">
					<%@ include file="/ConsultarMovimientos.jsp" %>
				</div>
			</th>
		</tr>
	</table>
			
	
	
	
	
</body>
</html>