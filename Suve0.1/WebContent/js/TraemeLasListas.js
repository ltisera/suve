/**
 * 
 */
function cargo() {
	alert("Dale");
}


function traerListaTarjetas(){
		$.ajax({
			data:{
				"lista": "Tarjetas",
				},
			url:"TraerListas",
			type:"POST",
			success:function(response){
				for(i in response){
					var opcion = document.createElement("option");
					opcion.text = response[i];
					opcion.value = response[i];
				    $("#lstTarjetas").append(opcion);
					   
				}
			},
			error:function(response){
				alert("No se ha podido cargar la lista de tarjetas");
			}
		});
}


function traerListaEstaciones(){
	$.ajax({
		data:{
			"lista":"Estaciones",
			"transporte":$("#inpTipoTransporte").val(),
			"linea":$("#inpLinea").val()
		},
		url:"TraerListas",
		type:"POST",
		success:function(response){
			$("#inpEstacion").empty();
			var opcion = document.createElement("option");
			opcion.text = "Seleccione una Estacion";
			opcion.value = "Vacio";
		    $("#inpEstacion").append(opcion);
			
			for(i in response){
				var opcion = document.createElement("option");
				opcion.text = response[i];
				opcion.value = response[i];
			    $("#inpEstacion").append(opcion);
			    
			}

		},
		error:function(){
			alert("Error al traer la lista de estaciones");
		}
		
	});
}

function traerListaLectoras(){
	$.ajax({
		data:{
			"lista":"Lectoras",
			"transporte":$("#inpTipoTransporte").val(),
			"linea":$("#inpLinea").val(),
			"estacion":$("#inpEstacion").val()
		},
		url:"TraerListas",
		type:"POST",
		success:function(response){
			$("#inpLectora").empty();
			var opcion = document.createElement("option");
			opcion.text = "Seleccione una Lectora";
			opcion.value = "Vacio";
		    $("#inpLectora").append(opcion);
			for(i in response){
				var opcion = document.createElement("option");
				opcion.text = response[i];
				opcion.value = response[i];
			    $("#inpLectora").append(opcion);
			}
		},
		error:function(){
			alert("Error en carga de lista de lectoras");
		}
		
	});
}
function traerListaLectorasCarga(){
	$.ajax({
		data:{
			"lista":"LectorasCarga"
		},
		url:"TraerListas",
		type:"POST",
		success:function(response){
			$("#inpPuntoCarga").empty();
			var opcion = document.createElement("option");
			opcion.text = "Seleccione una Lectora";
			opcion.value = "Vacio";
		    $("#inpPuntoCarga").append(opcion);
			for(i in response){
				var opcion = document.createElement("option");
				opcion.text = response[i];
				opcion.value = response[i];
			    $("#inpPuntoCarga").append(opcion);
			}
		},
		error:function(){
			alert("Error en carga de lista de lectoras de Carga");
		}
		
	});
}


function traerListaLineas(){
	$.ajax({
		data:{
			"lista":"Linea",
			"transporte":$("#inpTipoTransporte").val()
		},
		url:"TraerListas",
		type:"POST",
		success:function(response){
			$("#inpLinea").empty();
			var opcion = document.createElement("option");
			opcion.text = "Seleccione una Linea";
			opcion.value = "Vacio";
		    $("#inpLinea").append(opcion);
			
			for(i in response){
				var opcion = document.createElement("option");
				opcion.text = response[i];
				opcion.value = response[i];
			    $("#inpLinea").append(opcion);
			}
		},
		error:function(){
			alert("No se ha podido cargar la lista de Lineas");
		}
	});
}

function traerUltimosViajes(){
	$.ajax({
		data:{
			"lista":"UltimosViajes",
			"tarjeta":$("#inpTarjeta").val()
			},
		url: "TraerListas",
		type:"POST",
		success: function(response){
			$("#divDatosTarjeta").html(response);
		},
		error: function(response){
			$("#divDatosTarjeta").html("me pa que no esta tu tarjeta");
		}
			
	});
}

/*
function crearOpciones(response,idLista){
	alert("Entre");
	$(idLista).empty();
	var opcion = document.createElement("option");
	opcion.text = "Elija una opcion:";
    $(idLista).append(opcion);
	for(i in response){
		var opcion = document.createElement("option");
		opcion.text = response[i];
	    $(idLista).append(opcion);
	}
}
*/