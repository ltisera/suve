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
				/*
				var opcion = document.createElement("option");
				opcion.text = "Kiwi";
			    $("#inpTipoTransporte").append("Kiwo");
			    opcion.text = "naranja";
			    $("#inpTipoTransporte").append(opcion);
			    opcion.text = "pepino";
			    $("#inpTipoTransporte").append(opcion);
			    /*/
				console.log(response);
			    console.log(response.item1);
			    
				for(i in response){
					var opcion = document.createElement("option");
					opcion.text = response[i];
				    $("#lstTarjetas").append(opcion);
				    
				}
			},
			error:function(response){
				alert("LA PUTA QUE TE PARIIOO");
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
			var x = document.getElementById("lstLinea");
			$("#lstLinea").empty();
			for(i in response){
				var opcion = document.createElement("option");
				opcion.text = response[i];
			    $("#lstLinea").append(opcion);
			    
			}

			
			
			
		},
		error:function(){
			alert("LA sdfsdIOO");
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
			$("#lstEstaciones").empty();
			for(i in response){
				var opcion = document.createElement("option");
				opcion.text = response[i];
			    $("#lstEstaciones").append(opcion);
			    
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
			$("#lstLectora").empty();
			for(i in response){
				var opcion = document.createElement("option");
				opcion.text = response[i];
			    $("#lstLectora").append(opcion);
			    
			}

		},
		error:function(){
			alert("Error en carga de lista de lectoras");
		}
		
	});
}