<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
 
<html>

<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<TITLE>SuViajes</TITLE>

    <script src="js/jquery-3.3.1.js"></script>
    
</HEAD>

<body>
	<div class="jumbotron">
		<div class="container">
		
		</div>
		<div class="container">
			<h1>Agregado de 1 Boleto</h1>
			<form class="navbar-form navbar-right">
				<div class="form-group">
					<table>
						<tr>
							<th>
								<label>Ingrese el numero de tarjeta:</label>
								<br> 
								<input list="lstTarjetas">
								<datalist id="lstTarjetas">
									<option value="Construir Lista de tarjeta">
									<option value="21x">
									<option value="Ch21ome">
									<option value="O21ra">
									<option value="Safari">
								</datalist>
							</th>
							
							
						</tr>
						<tr>
							<th id="tblListaTransporte">
								<label>Seleccione Tipo de Transporte:</label>
								<br> 
								<input list="lstTransporte">
								<datalist id="lstTransporte">
									<option value="Tren">
									<option value="Subte">
									<option value="Colectivo">
									
								</datalist>
							</th>
						</tr>
						<tr>
							<th id="tblListaLinea">
								<label>Seleccione la Linea:</label>
								<br> 
								<input list="lstLinea">
								<datalist id="lstLinea">
									<option value="Construir Lista de linea">
									<option value="adsfa">
									<option value="blah blah blah">
									
								</datalist>
							</th>
						</tr>
						
					</table>
					
				</div>
			</form>
		</div>
	
	</div>
<INPUT id="btnAgregar" type="button" class="btn btn-success" value="Agregar"/>
</body>
</html>