/**
 * 
 */

function traerListaLineasE(){
	$.ajax({
		data:{
			"lista":"Linea",
			"transporte":$("#inpTipoTransporteE").val()
		},
		url:"TraerListas",
		type:"POST",
		success:function(response){
			$("#inpLineaE").empty();
			var opcion = document.createElement("option");
			opcion.text = "Seleccione una Linea";
			opcion.value = "Vacio";
		    $("#inpLineaE").append(opcion);
			
			for(i in response){
				var opcion = document.createElement("option");
				opcion.text = response[i];
			    $("#inpLineaE").append(opcion);
			}
		},
		error:function(){
			alert("No se ha podido cargar la lista de Lineas");
		}
	});
}




function generarGraficoEstadisticasPorTransporte(nrs){
	document.getElementById("divContEstadisticas").innerHTML="";
	document.getElementById("divContEstadisticas").innerHTML='<canvas id="myChart"></canvas>';

	var ctx = document.getElementById('myChart').getContext('2d');
	Chart.defaults.global.defaultFontSize = 18;
	Chart.defaults.global.defaultFontColor = 'white';
	var chart = new Chart(ctx, {
	    // The type of chart we want to create
	    type: 'doughnut',

	    // The data for our dataset
	    data: {
	        labels: ["Descuento 0%", "Descuento 50%", "Descuento 75%"],
	        datasets: [{
	            label: "Descuentos Sube",
	            backgroundColor: [
	            	'rgb(0, 120, 255)',
	            	'rgb(63, 96, 139)',
	            	'rgb(0, 0, 255)',
	            	'rgb(0, 120, 255)',
	            	'rgb(63, 96, 139)',
	            	'rgb(0, 0, 255)',
	            	'rgb(0, 120, 255)',
	            	'rgb(63, 96, 139)',
	            	'rgb(0, 0, 255)',
	            	'rgb(0, 120, 255)',
	            	'rgb(63, 96, 139)',
	            	'rgb(0, 0, 255)',
	            	'rgb(0, 120, 255)',
	            	'rgb(63, 96, 139)',
	            	'rgb(0, 0, 255)',
	            	'rgb(0, 120, 255)',
	            	'rgb(63, 96, 139)',
	            	'rgb(0, 0, 255)',
	            	'rgb(0, 120, 255)',
	            	'rgb(63, 96, 139)',
	            	'rgb(0, 0, 255)',
	            	'rgb(0, 120, 255)',
	            	'rgb(63, 96, 139)',
	            	'rgb(0, 0, 255)'
		            ],
	            borderColor: 'rgb(0, 0, 0)',
	            data: [nrs[1], nrs[2],nrs[3] +nrs[4] +nrs[5] +nrs[6]],
	        }]
	    },

	    // Configuration options go here
	    options: {
	    	responsive: true,
	        maintainAspectRatio: false,
	        scales: {

	        }
		}
	});
}

function generarGraficoEstadisticasPorLinea(lstVal, lstLbl, lstSize){
	console.log(lstVal);
	console.log(lstLbl);
	console.log(lstSize);
	
	document.getElementById("divContEstadisticas").innerHTML="";
	document.getElementById("divContEstadisticas").innerHTML='<canvas id="myChart"></canvas>';

	var ctx = document.getElementById('myChart').getContext('2d');
	Chart.defaults.global.defaultFontSize = 18;
	Chart.defaults.global.defaultFontColor = 'white';
	var chart = new Chart(ctx, {
	    // The type of chart we want to create
	    type: 'bar',

	    // The data for our dataset
	    data: {
	        labels: lstLbl,
	        datasets: [{
	            label: "Estadisticas por Linea",
	            backgroundColor: [
	            	'rgb(0, 120, 255)',
	            	'rgb(63, 96, 139)',
	            	'rgb(0, 0, 255)',
	            	'rgb(0, 120, 255)',
	            	'rgb(63, 96, 139)',
	            	'rgb(0, 0, 255)',
	            	'rgb(0, 120, 255)',
	            	'rgb(63, 96, 139)',
	            	'rgb(0, 0, 255)',
	            	'rgb(0, 120, 255)',
	            	'rgb(63, 96, 139)',
	            	'rgb(0, 0, 255)',
	            	'rgb(0, 120, 255)',
	            	'rgb(63, 96, 139)',
	            	'rgb(0, 0, 255)',
	            	'rgb(0, 120, 255)',
	            	'rgb(63, 96, 139)',
	            	'rgb(0, 0, 255)',
	            	'rgb(0, 120, 255)',
	            	'rgb(63, 96, 139)',
	            	'rgb(0, 0, 255)',
	            	'rgb(0, 120, 255)',
	            	'rgb(63, 96, 139)',
	            	'rgb(0, 0, 255)'
		            ],
	            borderColor: 'rgb(0, 0, 0)',
	            data: lstVal,
	        }]
	    },

	    // Configuration options go here
	    options: {
	    	responsive: true,
	        maintainAspectRatio: false,
	        scales: {
	        	 yAxes: [{
	                 ticks: {
	                     beginAtZero:true
	                 }
	             }]
	        }
		}
	});
}



function generarReporte(nrs){
	$.ajax({
		data : {
			"tipoReporte": "Reporte Tipo Transporte",
			"tipoTransporte" : $("#inpTipoTransporteE").val(),
			"fechaDesde" : $("#inpFechaDesdeE").val(),
			"fechaHasta" : $("#inpFechaHastaE").val(),
			
		},
		url : "Estadisticas",
		type : "POST",
		beforeSend : function() {
			$("#divTblReporte").html("");
			$("#divContEstadisticas").hide();
			$("#divReporte").html("Realizando Reportes");
		},
		success : function(response) {

			$("#divContEstadisticas").show();
			$("#divReporte").html("Carga realizada exitosamente");

			var i = 0;

			var nFila = document.createElement("div");
			nFila.className = "clsFilaImpar";
			var cFecha = document.createElement("div");
			cFecha.className = "clsColFecha";
			cFecha.innerHTML = "Fecha";
			nFila.appendChild(cFecha)

			var cNumTarjeta = document.createElement("div");
			cNumTarjeta.className = "clsColNumTarjeta";
			cNumTarjeta.innerHTML = "Numero de Tarjeta";
			nFila.appendChild(cNumTarjeta);

			var cMonto = document.createElement("div");
			cMonto.className = "clsColMonto";
			cMonto.innerHTML = "Monto";
			nFila.appendChild(cMonto);

			var tbl = document.getElementById("divTblReporte");
			tbl.appendChild(nFila);
			var nrs =[0,0,0,0,0,0,0];
			for(i = 0; i < response.length;i++){
				nrs[response[i].intRedSube]++;
				var nFila = document.createElement("div");
				
				if(i%2 != 0){
					nFila.className = "clsFilaImpar";
				} else {
					nFila.className = "clsFilaPar";
				}
				
				var cFecha = document.createElement("div");
				cFecha.className = "clsColFecha";
				cFecha.innerHTML = response[i].fechaHora;
				nFila.appendChild(cFecha)

				var cNumTarjeta = document.createElement("div");
				cNumTarjeta.className = "clsColNumTarjeta";
				cNumTarjeta.innerHTML = response[i].numTarjeta;
				nFila.appendChild(cNumTarjeta);

				var cMonto = document.createElement("div");
				cMonto.className = "clsColMonto";
				cMonto.innerHTML = response[i].monto;
				nFila.appendChild(cMonto);

				var tbl = document.getElementById("divTblReporte");
				tbl.appendChild(nFila);
			}
			generarGraficoEstadisticasPorTransporte(nrs);
		},
		error : function(response) {
			$("#divReporte").html("Fallo la carga");
		}
	});
}

function generarReporteLinea(){
	$.ajax({
		data : {
			"tipoReporte": "Reporte Linea Transporte",
			"tipoTransporte" : $("#inpTipoTransporteE").val(),
			"tipoLinea": $("#inpLineaE").val(),
			"fechaDesde" : $("#inpFechaDesdeE").val(),
			"fechaHasta" : $("#inpFechaHastaE").val(),
			
		},
		url : "Estadisticas",
		type : "POST",
		beforeSend : function() {
			$("#divTblReporte").html("");
			$("#divContEstadisticas").hide();
			$("#divReporte").html("Realizando Reportes");
		},
		success : function(response) {
			console.log(response);
			$("#divContEstadisticas").show();
			$("#divReporte").html("Carga realizada exitosamente");

			var i = 0;

			var nFila = document.createElement("div");
			nFila.className = "clsFilaImpar";
			var cFecha = document.createElement("div");
			cFecha.className = "clsColFecha2";
			cFecha.innerHTML = "Fecha";
			nFila.appendChild(cFecha)

			var cNumTarjeta = document.createElement("div");
			cNumTarjeta.className = "clsColNumTarjeta2";
			cNumTarjeta.innerHTML = "Num Tarjeta";
			nFila.appendChild(cNumTarjeta);
			
			var cTramo = document.createElement("div");
			cTramo.className = "clsColTramo";
			cTramo.innerHTML = "Tramo";
			nFila.appendChild(cTramo);

			var cMonto = document.createElement("div");
			cMonto.className = "clsColMonto2";
			cMonto.innerHTML = "Monto";
			nFila.appendChild(cMonto);

			var tbl = document.getElementById("divTblReporte");
			tbl.appendChild(nFila);
			var nrs =[0,0,0,0,0,0,0];
			for(i = 0; i < response.length-2;i++){
				nrs[response[i].intRedSube]++;
				var nFila = document.createElement("div");
				
				if(i%2 != 0){
					nFila.className = "clsFilaImpar";
				} else {
					nFila.className = "clsFilaPar";
				}
				
				var cFecha = document.createElement("div");
				cFecha.className = "clsColFecha2";
				cFecha.innerHTML = response[i].fechaHora;
				nFila.appendChild(cFecha)

				var cNumTarjeta = document.createElement("div");
				cNumTarjeta.className = "clsColNumTarjeta2";
				cNumTarjeta.innerHTML = response[i].numTarjeta;
				nFila.appendChild(cNumTarjeta);
				
				var cTramo = document.createElement("div");
				cTramo.className = "clsColTramo";
				cTramo.innerHTML = response[i].tramo;
				nFila.appendChild(cTramo);

				var cMonto = document.createElement("div");
				cMonto.className = "clsColMonto2";
				cMonto.innerHTML = response[i].monto;
				nFila.appendChild(cMonto);

				var tbl = document.getElementById("divTblReporte");
				tbl.appendChild(nFila);
			}
			generarGraficoEstadisticasPorLinea(response[response.length-2].arrayEST,response[response.length-1].arrayNombres, response[response.length-2].arrayEST.length);
		},
		error : function(response) {
			$("#divReporte").html("Fallo la carga");
		}
	});
}