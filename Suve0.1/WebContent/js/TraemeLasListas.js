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
				console.log(response);
				for(i in response){
					var opcion = document.createElement("option");
					opcion.text = response[i];
				    //$("#lstTarjetasConsulta").append(opcion);
				    $("#lstTarjetas").append(opcion);
					   
				}
			},
			error:function(response){
				alert("No se ha podido cargar la lista de Tarjetas");
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
			console.log(response);
			$("#inpEstacion").empty();
			var opcion = document.createElement("option");
			opcion.text = "Seleccione una Estacion";
		    $("#inpEstacion").append(opcion);
			
			for(i in response){
				var opcion = document.createElement("option");
				opcion.text = response[i];
			    $("#inpEstacion").append(opcion);
			    
			}

		},
		error:function(){
			alert("LA sdfsdIOO");
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
			console.log(response);
			$("#inpLectora").empty();
			var opcion = document.createElement("option");
			opcion.text = "Seleccione una Lectora";
		    $("#inpLectora").append(opcion);
			for(i in response){
				var opcion = document.createElement("option");
				opcion.text = response[i];
			    $("#inpLectora").append(opcion);
			}
		},
		error:function(){
			alert("Error en carga de lista de lectoras");
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
			console.log(response);
			$("#inpLinea").empty();
			var opcion = document.createElement("option");
			opcion.text = "Seleccione una Linea";
		    $("#inpLinea").append(opcion);
			
			for(i in response){
				var opcion = document.createElement("option");
				opcion.text = response[i];
			    $("#inpLinea").append(opcion);
			}
		},
		error:function(){
			alert("No se ha podido cargar la lista de Lineas");
		}
	});
}



function crearOpciones(response,idLista){
	alert("Entre");
	console.log(response);
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