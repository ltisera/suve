<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Estadisticas</title>
<script src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/Chart.js"></script>


<script>
	$(document).ready(function() {
		var ctx = document.getElementById('myChart').getContext('2d');
		var chart = new Chart(ctx, {
		    // The type of chart we want to create
		    type: 'doughnut',

		    // The data for our dataset
		    data: {
		        labels: ["Tren", "Colectivo", "Subte"],
		        datasets: [{
		            label: "QUE BOSTAS",
		            backgroundColor: [
		            	'rgb(255, 0, 0)',
		            	'rgb(0, 255, 0)',
		            	'rgb(0, 0, 255)'
			            ],
		            borderColor: 'rgb(0, 0, 0)',
		            data: [3, 10,4],
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
	});

</script>
</head>
<body>
	<div id="divContEstadisticas" class="caja2px">
		qwfqwfqw
		<canvas id="myChart"></canvas>
		
		
	</div>
</body>
</html>