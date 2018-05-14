<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html>

<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<TITLE>SuViajes</TITLE>

    <script src="js/jquery-3.3.1.js"></script>
    <script>
    $(document).ready(function(){
    	 $("#consultar").click(function() {
    		 console.log("Generomensaje");
			var boleto = $("#boleto").val();
			console.log("Debuguealo");
			$.ajax({
				data: {"boleto":boleto},
				url: "MostrarBoleto",
				type:"POST",
				beforeSend: function () {
                    $("#responseboleto").html("Procesando, espere por favor...");
	            },
	            success:  function (response) {
	                    $("#responseboleto").html(response);
	            },
	            error:	function () {
	                    alert("DAAA PUTO");
	            }
			});
			
    	});
    });
    </script>


</HEAD>

<body style="background-color:#108CCC; color:#ffffff"  >
	<%@ include file="/cabecera.jsp" %>
	<br>
	<br>
	<br>
	<div class="jumbotron">
		<div class="container">
			<h1>Busqueda de 1 boletito</h1>
			<form class="navbar-form navbar-right">
				<div class="form-group">
					<label for="boleto">Este es DIOS:</label> 
					<INPUT id="boleto" name="boleto">
				</div>
				<INPUT id="consultar" type="button" class="btn btn-success" value="Consultar"/>
			</form>
		</div>
		<div class="container">
			<div id="responseboleto">
			<br>
			
			</div>
			
			<div id="divlistarPrestamos"></div>
		</div>
	</div>

</body>
</html>