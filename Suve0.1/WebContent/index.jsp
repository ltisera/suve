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
		
		$("#divBtnInicio").mouseover(function(){
			$("#imgInicio").attr("src","recursos/btnInicioOn.png");
		});
		$("#divBtnInicio").mouseleave(function(){
			$("#imgInicio").attr("src","recursos/btnInicioOff.png");
		});
		$("#divBtnInicio").click(function() {
			$("#imgInicio").attr("src","recursos/btnInicioSel.png");
			$("#divManejaFecha").hide();
			$("#divAgregarViaje").hide();
			$("#divConsultarMovimientos").hide();
			$("#divCargarSaldoEstudiantil").hide();
			$("#divInicio").show();
		});
		
		$("#divBtnAgregarViaje").mouseover(function(){
			$("#imgAgregarViajes").attr("src","recursos/btnAgregarViajeOn.png");
		});
		$("#divBtnAgregarViajes").mouseleave(function(){
			$("#imgAgregarViajes").attr("src","recursos/btnAgregarViajeOff.png");
		});
		$("#divBtnAgregarViaje").click(function() {
			$("#imgAgregarViajes").attr("src","recursos/btnAgregarViajeSel.png");
			$("#divInicio").hide();
			$("#divConsultarMovimientos").hide();
			$("#divCargarSaldoEstudiantil").hide();
			$("#divManejaFecha").show("fast");
			$("#divAgregarViaje").show("slow");
		});
		
		$("#divBtnConsultarMovimientos").mouseover(function(){
			$("#imgConsultarMovimientos").attr("src","recursos/btnConsultarMovimientosOn.png");
		});
		$("#divBtnConsultarMovimientos").mouseleave(function(){
			$("#imgConsultarMovimientos").attr("src","recursos/btnConsultarMovimientosOff.png");
		});
		$("#divBtnConsultarMovimientos").click(function() {
			$("#imgConsultarMovimientos").attr("src","recursos/btnConsultarMovimientosSel.png");
			$("#divInicio").hide();
			$("#divManejaFecha").hide();
			$("#divAgregarViaje").hide();
			$("#divCargarSaldoEstudiantil").hide();
			$("#divConsultarMovimientos").show("slow");
		});
		
		$("#divBtnCargarSaldoEstudiantil").mouseover(function(){
			$("#imgInicio").attr("src","recursos/btnCargarSaldoEstudiantilOn.png");
		});
		$("#divBtnCargarSaldoEstudiantil").mouseleave(function(){
			$("#imgCargarSaldoEstudiantil").attr("src","recursos/btnCargarSaldoEstudiantilOff.png");
		});
		$("#divBtnCargarSaldoEstudiantil").click(function() {
			$("#imgCargarSaldoEstudiantil").attr("src","recursos/btnCargarSaldoEstudiantilSel.png");
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
	<div id="divContenedorInferior">
		<div id="divMenu">
			<!-- Contenedor del menu -->
			<div id="divBtnInicio"><img id="imgInicio" alt="" src="recursos/btnInicioSel.png"></div>
			<br> 
			<div id="divBtnAgregarViaje"><img id="imgAgregarViaje" alt="" src="recursos/btnAgregarViajeOff.png"></div>
			<br> 
			<div id="divBtnConsultarMovimientos"><img id="imgConsultarMovimientos" alt="" src="recursos/btnConsultarMovimientosOff.png"></div>
			<br> 
			<div id="divBtnCArgarSaldoEstudiantil"><img id="imgCargarSaldoEstudiantil" alt="" src="recursos/btnCargarSaldoEstudiantilOff.png"></div>	
		</div>
		<div id="divContenido">
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
		</div>

	</div>	

</body>
</html>