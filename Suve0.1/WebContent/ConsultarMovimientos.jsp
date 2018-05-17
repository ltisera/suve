<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
 
<html>

<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<TITLE>SuViajes</TITLE>

    <script src="js/jquery-3.3.1.js"></script>
    <script>
    $(document).ready(function(){
    	 $("#consultarBoleto").click(function() {
			var boleto = $("#boleto").val();
			$.ajax({
				data: {"boleto":boleto},
				url: "MostrarBoleto",
				type:"POST",
				beforeSend: function () {
                    $("#divMostrarBoleto").html("Procesando, espere por favor...");
	            },
	            success:  function (response) {
	                    $("#divMostrarBoleto").html(response);
	            },
	            error:	function (response) {
	                    alert(response);
	            }
			});
    	});
    	 $("#consultarMovimientos").click(function(){
    		 $.ajax({
    			 url: "ListarMovimientos",
    			 type: "POST",
    			 beforeSend: function () {
                     $("#divMostrarMovimientos").html("Procesando, espere por favor...");
 	            },
 	            success:  function (response) {
 	            		$("#divMostrarBoleto").html("");
 	                    $("#divMostrarMovimientos").html(response);
 	            },
 	            error:	function () {
 	                    alert("DAAA MISHI");
 	            }
    		 });
    	 
   			 
		});
    });
    </script>


</HEAD>

<body>
	<div class="jumbotron">
		<div class="container">
		
		</div>
		<div class="container">
			<h1>Busqueda de 1 boletito</h1>
			<form class="navbar-form navbar-right">
				<div class="form-group">
					<label for="boleto">Este es DIOS:</label> 
					<INPUT id="boleto" name="boleto">
				</div>
				<INPUT id="consultarBoleto" type="button" class="btn btn-success" value="Consultar"/>
			</form>
		</div>
		<div class="container">
			<div id="divMostrarBoleto">
			</div> 
			
			
		</div>
		<div class="container">
			<input id = "consultarMovimientos" type="button" class ="btn btn-succes" value = "Lista los movimientos pa!"/>
			<div id="divMostrarMovimientos">
			</div>
		</div>
	</div>

</body>
</html>