<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar Usuario</title>
<link rel="stylesheet"  href="/Practica-1/CONFIG/Style/style.css" type="text/css">
</head>
<body>
	<form action="/Agenda_Telefonica/RegistrarTelefonos" method="POST">
	<div class="body"></div>
		<div class="grad"></div>
		<div class="header">
			<div><a href="/Agenda_Telefonica/JSPs/Inicio.jsp" style="font-size:x-large">Agenda</a><span></span></div>
		</div>
		<br>
		<div class="login">
				<h1>Registrar Telefono</h1><br>
				<input type="text" placeholder="Numero" name="numero" required><br>
				<input type="text" placeholder="Tipo" name="tipo" required><br>
				<input type="text" placeholder="Operadora" name="operadora" required><br>
				
				<button type="submit" name="resp" value="Registrar">Registrarse</button>
		</div>
</form>
</body>
</html>