<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<HEAD>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<TITLE>SuViajes</TITLE>
<link rel="stylesheet" type="text/css" href="css/estilos.css">

<script src="js/jquery-3.3.1.js" type="text/javascript"></script>
<script>

var tipoSesion = "inicio";

	$(document).ready(function(){
		$("#divAgregarViaje").hide();
		$("#divManejaFecha").hide();
		$("#divConsultarMovimientos").hide();
		$("#divCargarSaldo").hide();
		$("#divInicio").show();
		revisarContenido();
		
	
		$("#divBtnInicio").mouseenter(function(){
			if ($("#imgInicio").attr("src") != "recursos/btnInicioSel.png"){
				$("#imgInicio").attr("src","recursos/btnInicioOn.png");
			}
		});
		$("#divBtnInicio").mouseleave(function(){
			if ($("#imgInicio").attr("src") != "recursos/btnInicioSel.png"){
				$("#imgInicio").attr("src","recursos/btnInicioOff.png");
			}
		});
		
		
		$("#divBtnInicio").click(function() {
			if ($("#imgInicio").attr("src") != "recursos/btnInicioSel.png"){
				hideAll();
				$("#imgInicio").attr("src","recursos/btnInicioSel.png");
				$("#divInicio").show();
			}
		});
		
		$("#divBtnAgregarViaje").mouseenter(function(){
			if ($("#imgAgregarViaje").attr("src") != "recursos/btnAgregarViajeSel.png"){
				$("#imgAgregarViaje").attr("src","recursos/btnAgregarViajeOn.png");
			}
		});
		$("#divBtnAgregarViaje").mouseleave(function(){
			if ($("#imgAgregarViaje").attr("src") != "recursos/btnAgregarViajeSel.png"){
				$("#imgAgregarViaje").attr("src","recursos/btnAgregarViajeOff.png");
			}
		});
		$("#divBtnAgregarViaje").click(function() {
			if ($("#imgAgregarViaje").attr("src") != "recursos/btnAgregarViajeSel.png"){
				hideAll();
				$("#imgAgregarViaje").attr("src","recursos/btnAgregarViajeSel.png");
				$("#divManejaFecha").show("fast");
				$("#divAgregarViaje").show("slow");
			}
		});
		
		
		$("#divBtnConsultarMovimientos").mouseenter(function(){
			if ($("#imgConsultarMovimientos").attr("src") != "recursos/btnConsultarMovimientosSel.png"){
				$("#imgConsultarMovimientos").attr("src","recursos/btnConsultarMovimientosOn.png");
			}
		});
		$("#divBtnConsultarMovimientos").mouseleave(function(){
			if ($("#imgConsultarMovimientos").attr("src") != "recursos/btnConsultarMovimientosSel.png"){
				$("#imgConsultarMovimientos").attr("src","recursos/btnConsultarMovimientosOff.png");
			}
		});
		$("#divBtnConsultarMovimientos").click(function() {
			if ($("#imgConsultarMovimientos").attr("src") != "recursos/btnConsultarMovimientosSel.png"){
				hideAll();
				$("#imgConsultarMovimientos").attr("src","recursos/btnConsultarMovimientosSel.png");
				$("#divConsultarMovimientos").show("slow");
			}
		});	
		
		
		$("#divBtnCargarSaldo").mouseenter(function(){
			if ($("#imgCargarSaldo").attr("src") != "recursos/btnCargarSaldoSel.png"){
				$("#imgCargarSaldo").attr("src","recursos/btnCargarSaldoOn.png");
			}
		});
		$("#divBtnCargarSaldo").mouseleave(function(){
			if ($("#imgCargarSaldo").attr("src") != "recursos/btnCargarSaldoSel.png"){
				$("#imgCargarSaldo").attr("src","recursos/btnCargarSaldoOff.png");
			}
		});
		$("#divBtnCargarSaldo").click(function() {
			if ($("#imgCargarSaldo").attr("src") != "recursos/btnCargarSaldoSel.png"){
				hideAll();
				$("#imgCargarSaldo").attr("src","recursos/btnCargarSaldoSel.png");
				$("#divManejaFecha").show("fast");
				$("#divCargarSaldo").show("slow");
				traerListaLectorasCarga();
			}
		});
		
		
	});

function revisarContenido(){
	
	if(tipoSesion == "inicio"){
		$("#divBtnAgregarViaje").hide();
		$("#divBtnConsultarMovimientos").hide();
		$("#divBtnCargarSaldo").hide();
		
	}
	if(tipoSesion == "administrador"){
		$("#divBtnAgregarViaje").show();
		$("#divBtnConsultarMovimientos").show();
		$("#divBtnCargarSaldo").show();

		
	}
	if(tipoSesion == "pasajero"){
		$("#divBtnAgregarViaje").show();
		$("#divBtnConsultarMovimientos").show();

	}
}
function hideAll(){
	$("#divInicio").hide();
	$("#divAgregarViaje").hide();
	$("#divManejaFecha").hide();
	$("#divConsultarMovimientos").hide();
	$("#divCargarSaldo").hide();
	$("#imgInicio").attr("src","recursos/btnInicioOff.png");
	$("#imgAgregarViaje").attr("src","recursos/btnAgregarViajeOff.png");
	$("#imgConsultarMovimientos").attr("src","recursos/btnConsultarMovimientosOff.png");
	$("#imgCargarSaldo").attr("src","recursos/btnCargarSaldoOff.png");
}

</script>

</HEAD>

<body>

	<div id="divCabecera">
		<%@ include file="/cabecera.jsp"%>
	</div>
	<div id="divLinita"></div>
	<div id="divContenedorInferior">
		<div id="divMenu">
			<!-- Contenedor del menu -->
			<br>
			<br>
			<br>
			<br>
			<div id="divBtnInicio"><img id="imgInicio" alt="" src="recursos/btnInicioSel.png"></div>
			<br>
			<div id="divBtnAgregarViaje"><img id="imgAgregarViaje" alt="" src="recursos/btnAgregarViajeOff.png"></div>
			<br>
			<div id="divBtnConsultarMovimientos"><img id="imgConsultarMovimientos" alt="" src="recursos/btnConsultarMovimientosOff.png"></div>
			<br>
			<div id="divBtnCargarSaldo"><img id="imgCargarSaldo" alt="" src="recursos/btnCargarSaldoOff.png"></div>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
				
		</div>
		<div id="divContenido">
			<!-- Contenedor del contenido OMG -->
			<div id="divInicio" class="container">
				<%@ include file="/Inicio.jsp"%>
			</div>
			<div id="divAgregarViaje" class="container">
				<%@ include file="/AgregarViaje.jsp"%>
			</div>
			<div id="divConsultarMovimientos" class="container">
				<%@ include file="/ConsultarMovimientos.jsp"%>
			</div>
			<div id="divCargarSaldo" class="container">
				<div id="divContRecarga">
					<%@ include file="/Recarga.jsp"%>
				</div>
				
				
			</div>
		</div>

	</div>	

</body>
</html>