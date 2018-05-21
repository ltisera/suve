/**
 * 
 */
function cargo() {
	alert("Dale");
}

function traerListaTarjetas(){
	var para = "da"
		var valor = "nulo";
		$.ajax({
			data:{
				"pedirLista": "da",
				"valor": "nulo"
				},
			url:"AgregarBoleto",
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