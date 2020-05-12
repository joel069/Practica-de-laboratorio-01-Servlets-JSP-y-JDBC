<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html">
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Iniciar Sesion</title>
<link rel="stylesheet"  href="/Practica-1/CONFIG/Style/style.css" type="text/css">
</head>
<body>
<form action="/Agenda_Telefonica/Login" method="POST">
	<div class="body"></div>
		<div class="grad"></div>
		<div class="header">
			<div><a href="/Agenda_Telefonica/JSPs/IndexUsuario.jsp" style="font-size:x-large">Agenda</a><span></span></div>
		</div>
		<br>
		<div class="login">
				<input type="text" placeholder="username" name="correo" required><br>
				<input type="password" placeholder="password" name="clave" required><br>
				<button type="submit" name="resp" value="Login">Login</button>
		</div>
</form>
</body>
</html>