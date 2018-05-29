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
		$("#btnCargarSaldo").click(cargarSaldoEstudiantil);
	});
		
function cargarSaldoEstudiantil(){
	$.ajax({
		data : {
			"fdia": f.getDate(),
			"fmes": f.getMonth(),
			"fanio": f.getFullYear(),
			"fhora": f.getHours(),
			"fminuto": f.getMinutes(),
			"fsegundo": f.getSeconds()
		},
		url : "CargarBoletoEstudiantil",
		type : "POST",
		beforeSend : function() {
			$("#lblRespuesta").html("Cargando saldo estudiantil, espere...");
		},
		success : function(response) {
			$("#lblRespuesta").html("Saldo estudiantil cargado");
		},
		error : function(response) {
			$("#lblRespuesta").html(response.responseText);
		}
	});
}
		
		
</script>

</HEAD>

<body>

	<input id="btnCargarSaldo" type="button" value="Cargar Saldo Estudiantil" />

	<label id="lblRespuesta"></label>

</body>
</html>