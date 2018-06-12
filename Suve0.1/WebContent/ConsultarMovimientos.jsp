<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<TITLE>SuViajes</TITLE>
<link rel="stylesheet" type="text/css" href="css/estilos.css">
<script src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/TraemeLasListas.js"></script>
<script>
    $(document).ready(function(){
    	$("#divBtnConsMovimientos").mouseenter(entraMouseBtnConsMovimientos);
    	$("#divBtnConsMovimientos").mouseleave(saleMouseBtnConsMovimientos);
    	$("#divBtnConsMovimientos").mousedown(apretaMouseBtnConsMovimientos);
    	$("#divBtnConsMovimientos").mouseup(sueltaMouseBtnConsMovimientos);
    });

    function apretaMouseBtnConsMovimientos() {
    	etq = document.getElementById("lblBtnConsMovimientos");
    	etq.style.marginTop = "2px";
    	etq.style.marginLeft = "3px";
    }
    function sueltaMouseBtnConsMovimientos() {
    	etq.style.marginTop = "0px";
    	etq.style.marginLeft = "0px";
    	consultarMov();
    }

    function entraMouseBtnConsMovimientos() {
    	miboton = document.getElementById("divBtnConsMovimientos");
    	miboton.style.backgroundColor = "#3F608B";
    }
    function saleMouseBtnConsMovimientos() {
    	miboton = document.getElementById("divBtnConsMovimientos");
    	miboton.style.backgroundColor = "#7092be";
    }

function consultarMov(){
	$("#divMostrarMovimientos").html("<label>Cargando Movimientos... </label>");
	$.ajax({
		data:{
			"tarjeta":$("#inpTarjetaCon").val()
			},
		url: "ListarMovimientos",
		type:"POST",
		success: function(response){
			$("#divMostrarMovimientos").html(response);
		},
		error: function(response){
			$("#divMostrarMovimientos").html("<label>No se han podido cargar los movimientos, "+ response.responseText +"</label>");
		}
	});
}


</script>


</HEAD>

<body>
	<div class="jumbotron">
		<div class="container"></div>
		<div class="container">
			<h1>Consultas de Movimientos</h1>
			<div>
				<label>Ingrese Tarjeta: </label> <input id="inpTarjetaCon" name="numTarjetaCon" list="lstTarjetas"></input>
				<datalist id="lstTarjetasConsulta"></datalist>
				<br>
				<div id=divBtnConsMovimientos class="clsDivBoton">
					<label id="lblBtnConsMovimientos" class="clsLblBoton">Consultar</label>
				</div>
			</div>
		</div>

		<div class="container">
			<div id="divMostrarMovimientos"></div>
		</div>
	</div>

</body>
</html>