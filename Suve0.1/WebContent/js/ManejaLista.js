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
		success:function(response){},
		error:function(){
			alert("LA PUTA QUE TE PARIIOO");
		}
		
	});
}