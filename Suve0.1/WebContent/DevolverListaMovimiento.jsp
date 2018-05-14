<%@ page language = "java" contentType = "text/html; charset=ISO-8859-1"
pageEncoding = "ISO-8859-1" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@page import="datos.*"%>
<%@page import="dao.*"%>

<%@page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sistema Suve</title>
</head>
<body>
<%@ include file="/cabecera.jsp" %>
	<br>
	<table border="1">
		<tr>
			<th>Movimiento</th>
			<th>Estacion</th>
		</tr>
		<%MovimientoDao mdao = new MovimientoDao();%>
		<% List<Movimiento> lm = mdao.traerMovimientos();%>
		<%="PUTO" %>
	</table>
	
</body>
</html>