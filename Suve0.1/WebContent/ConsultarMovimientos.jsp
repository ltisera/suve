<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<TITLE>SuViajes</TITLE>

<script src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/TraemeLasListas.js"></script>
<script>
    $(document).ready(function(){
    	//traerListaTarjetasConsulta();
        $("#consultarMovimientos").click(consultarMov);
    });


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

				<br> <INPUT id="consultarMovimientos" type="button" class="btn btn-success" value="Consultar" />
			</div>
		</div>

		<div class="container">
			<div id="divMostrarMovimientos"></div>
		</div>
	</div>

</body>
</html>