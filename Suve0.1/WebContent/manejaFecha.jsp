<%@page import="funciones.Funciones"%>
<%@page import="java.util.GregorianCalendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/estilos.css">

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<title>ManejaFecha</title>

<script src="js/jquery-3.3.1.js"></script>
<script type="text/javascript"></script>
<script>
	$(document).ready(function(){
		var lafecha = new Date();
		var avance = 0;
		$("#quefecha").html(lafecha);
		var f = sumarAvance(lafecha, avance);
		$("#quefecha").html(f.getDate()+"/"+(f.getMonth()+1)+"/"+f.getFullYear() + " Y la Hora: " + f.getHours()+":"+f.getMinutes()+":"+f.getSeconds());
		setInterval(function(){calcularFecha(avance); }, 1000);
		
		$("#avanzar").click(function() {
			avance = avance + sumarSegundos();
			lafecha=new Date();
			f = sumarAvance(lafecha, avance);
			$("#quefecha").html(f.getDate()+"/"+(f.getMonth()+1)+"/"+f.getFullYear() + "<br>    " + f.getHours()+":"+f.getMinutes()+":"+f.getSeconds());
		});
		
	});

//Pruebas con la fecha
function calcularFecha(avance){
	//avance = avance + sumarSegundos();
	lafecha=new Date();
	f = sumarAvance(lafecha, avance);
	$("#quefecha").html(f.getDate()+"/"+(f.getMonth()+1)+"/"+f.getFullYear() + "<br>    " + f.getHours()+":"+f.getMinutes()+":"+f.getSeconds());
}
//Pruebas con la fecha

function sumarAvance(fecha, avanzate){
	console.log("Avanzate:" + avanzate);
	fecha.setSeconds(fecha.getSeconds()+avanzate);
	return fecha;
}

function sumarSegundos(){
	var segundosTotales = 0;
	console.log(segundosTotales);
	segundosTotales = segundosTotales + parseInt($("#idDia").val()) * 60*60*24;
	segundosTotales = segundosTotales + parseInt($("#idHora").val()) *60*60;
	segundosTotales = segundosTotales + parseInt($("#idMinuto").val()) * 60;
	segundosTotales = segundosTotales + parseInt($("#idSegundo").val()) * 1;
	console.log(segundosTotales);
	return segundosTotales;
}

function Cerizar(){
	$("#idAnio").val(0);
	$("#idMes").val(0);
	$("#idDia").val(0);
	$("#idHora").val(0);
	$("#idMinuto").val(0);
	$("#idSegundo").val(0);
}

function componerCalendar(avance){
	avance.set

}
</script>
</head>
<body>
	<form class="navbar-form navbar-right">
		

		
		<table id=tblManejaFecha >	
			<tr>
				<th colspan="4">Fecha Actual: <label id="quefecha"></label></th>

			</tr>	
			<tr >
				<th>Dia</th>
				<th>Hora</th>
				<th>Minuto</th>
				<th>Segundo</th>
			</tr>
			
			<tr>
			 
				<th><input id= "idDia" value="0" size="4"></input></th>
				<th><input id= "idHora" name = "inpHora" value="0" size="4"></input></th>
				<th><input id= "idMinuto" value="0" size="4"></input></th>
				<th><input id= "idSegundo" value="0" size="4"></input></th>
				
				
			</tr>
		
			<tr>
				<th colspan="4">
					<input type="button" class ="btn btn-succes" id="avanzar" name="avanzar" value="avanzar"></input>
				</th>
			</tr>
		</table>
		
	
	</form>
	
</body>
</html>