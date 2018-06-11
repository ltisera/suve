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
var avance = 0;
var lafecha = 0;
var f =0;

	$(document).ready(function(){
		lafecha = new Date();
		$("#quefecha").html(lafecha);
		f = sumarAvance(lafecha, avance);
		$("#quefecha").html(f.getDate()+"/"+(f.getMonth()+1)+"/"+f.getFullYear() + " Y la Hora: " + f.getHours()+":"+f.getMinutes()+":"+f.getSeconds());
		setInterval(function(){calcularFecha(avance); }, 1000);
		$("#avanzar").click(darAvance);
		$("#divBtnAvanzar").mouseenter(entraMouseAAvanzar);
		$("#divBtnAvanzar").mouseleave(saleMouseAAvanzar);
		$("#divBtnAvanzar").mousedown(apretaMouseAAvanzar);
		$("#divBtnAvanzar").mouseup(sueltaMouseAAvanzar);
		
	});

function darAvance(){
	
	avance = avance + sumarSegundos();
	console.log(avance);
	lafecha=new Date();
	f = sumarAvance(lafecha, avance);
	$("#quefecha").html(f.getDate()+"/"+(f.getMonth()+1)+"/"+f.getFullYear() + "<br>    " + f.getHours()+":"+f.getMinutes()+":"+f.getSeconds());
}

function apretaMouseAAvanzar(){
	etq=document.getElementById("lblAvanzar");
	etq.style.marginTop="2px";
	etq.style.marginLeft="3px";
}
function sueltaMouseAAvanzar(){
	etq.style.marginTop="0px";
	etq.style.marginLeft="0px";
	darAvance();
}

function entraMouseAAvanzar(){
	miboton=document.getElementById("divBtnAvanzar");
	miboton.style.backgroundColor = "#3F608B";
}
function saleMouseAAvanzar(){
	miboton=document.getElementById("divBtnAvanzar");
	miboton.style.backgroundColor = "#7092be";
}
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
	if(isNaN(segundosTotales)){
		segundosTotales = 0;
	}
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
					<div id="divBtnAvanzar" class="clsDivBoton">
						<label id="lblAvanzar" class ="clsLblBoton">Avanzar</label>
					</div>
					
				</th>
			</tr>
		</table>
		
	
	</form>
	
</body>
</html>