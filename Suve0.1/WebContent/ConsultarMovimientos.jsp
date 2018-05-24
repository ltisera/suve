<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
			alert("la pucha e icho");
		}
			
	});
	
}

function traerListaTarjetasConsulta(){
	$.ajax({
		data:{
			"lista": "Tarjetas"
			},
		url:"TraerListas",
		type:"POST",
		success:function(response){
			console.log(response);
			for(i in response){
				var opcion = document.createElement("option");
				opcion.text = response[i];
			    $("#lstTarjetasConsulta").append(opcion);    
			}
		},
		error:function(response){
			alert("Con error Tarjetas");
		}
	});
}
    </script>


</HEAD>

<body>
	<div class="jumbotron">
		<div class="container">
		
		</div>
		<div class="container">
			<h1>Consultas de Movimientos</h1>
			<div>
				<label>Ingrese Tarjeta: </label>
				<input id="inpTarjetaCon" name="numTarjetaCon" list="lstTarjetas"></input>
				<datalist id="lstTarjetasConsulta"></datalist>
				
				<br>
				<INPUT id="consultarMovimientos" type="button" class="btn btn-success" value="Consultar"/>
			</div>
		</div>

		<div class="container">
			<div id="divMostrarMovimientos">
			</div>
		</div>
	</div>

</body>
</html>