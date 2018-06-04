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
		
		if ($("#imgInicio").attr("src") != "recursos/btnInicioSel.png"){
			$("#divBtnInicio").mouseenter(function(){
				$("#imgInicio").attr("src","recursos/btnInicioOn.png");
			});
			$("#divBtnInicio").mouseleave(function(){
				$("#imgInicio").attr("src","recursos/btnInicioOff.png");
			});
			$("#divBtnInicio").click(function() {
				hideAll();
				$("#imgInicio").attr("src","recursos/btnInicioSel.png");
				$("#divInicio").show();
			});
		}
		
		if ($("#imgAgregarViaje").attr("src") != "recursos/btnAgregarViajeSel.png"){
			$("#divBtnAgregarViaje").mouseenter(function(){
				$("#imgAgregarViaje").attr("src","recursos/btnAgregarViajeOn.png");
			});
			$("#divBtnAgregarViaje").mouseleave(function(){
				$("#imgAgregarViaje").attr("src","recursos/btnAgregarViajeOff.png");
			});
			$("#divBtnAgregarViaje").click(function() {
				hideAll();
				$("#imgAgregarViaje").attr("src","recursos/btnAgregarViajeSel.png");
				$("#divManejaFecha").show("fast");
				$("#divAgregarViaje").show("slow");
			});
		}
		
		if ($("#imgConsultarMovimientos").attr("src") != "recursos/btnConsultarMovimientosSel.png"){
			$("#divBtnConsultarMovimientos").mouseenter(function(){
				$("#imgConsultarMovimientos").attr("src","recursos/btnConsultarMovimientosOn.png");
			});
			$("#divBtnConsultarMovimientos").mouseleave(function(){
				$("#imgConsultarMovimientos").attr("src","recursos/btnConsultarMovimientosOff.png");
			});
			$("#divBtnConsultarMovimientos").click(function() {
				hideAll();
				$("#imgConsultarMovimientos").attr("src","recursos/btnConsultarMovimientosSel.png");
				$("#divConsultarMovimientos").show("slow");
			});	
		}
		
		if ($("#imgCargarSaldoEstudiantil").attr("src") != "recursos/btnCargarSaldoEstudiantilSel.png"){
			$("#divBtnCargarSaldoEstudiantil").mouseenter(function(){
				$("#imgCargarSaldoEstudiantil").attr("src","recursos/btnCargarSaldoEstudiantilOn.png");
			});
			$("#divBtnCargarSaldoEstudiantil").mouseleave(function(){
				$("#imgCargarSaldoEstudiantil").attr("src","recursos/btnCargarSaldoEstudiantilOff.png");
			});
			$("#divBtnCargarSaldoEstudiantil").click(function() {
				hideAll();
				$("#imgCargarSaldoEstudiantil").attr("src","recursos/btnCargarSaldoEstudiantilSel.png");
				$("#divManejaFecha").show("fast");
				$("#divCargarSaldoEstudiantil").show("slow");
			});
		}
		
	});
	
function hideAll(){
	$("#divInicio").hide();
	$("#divAgregarViaje").hide();
	$("#divManejaFecha").hide();
	$("#divConsultarMovimientos").hide();
	$("#divCargarSaldoEstudiantil").hide();
	$("#imgInicio").attr("src","recursos/btnInicioOff.png");
	$("#imgAgregarViaje").attr("src","recursos/btnAgregarViajeOff.png");
	$("#imgConsultarMovimientos").attr("src","recursos/btnConsultarMovimientosOff.png");
	$("#imgCargarSaldoEstudiantil").attr("src","recursos/btnCargarSaldoEstudiantilOff.png");
}

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
			<div id="divBtnAgregarViaje"><img id="imgAgregarViaje" alt="" src="recursos/btnAgregarViajeOff.png"></div>
			<div id="divBtnConsultarMovimientos"><img id="imgConsultarMovimientos" alt="" src="recursos/btnConsultarMovimientosOff.png"></div>
			<div id="divBtnCargarSaldoEstudiantil"><img id="imgCargarSaldoEstudiantil" alt="" src="recursos/btnCargarSaldoEstudiantilOff.png"></div>	
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