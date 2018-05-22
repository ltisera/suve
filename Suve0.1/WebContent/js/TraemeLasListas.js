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
				    $("#lstTarjetas").append(opcion);    
				}
			},
			error:function(response){
				alert("No se ha podido cargar la lista de Tarjetas");
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
			$("#inpEstaciones").empty();
			for(i in response){
				var opcion = document.createElement("option");
				opcion.text = response[i];
			    $("#inpEstaciones").append(opcion);
			    
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
		success:crearOpciones(response,"\"#inpLectora\""),
		/*
		success:function(response){
			console.log(response);
			$("#lstLectora").empty();
			for(i in response){
				var opcion = document.createElement("option");
				opcion.text = response[i];
			    $("#lstLectora").append(opcion);
			}
		},
		*/
		error:function(){
			alert("Error en carga de lista de lectoras");
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