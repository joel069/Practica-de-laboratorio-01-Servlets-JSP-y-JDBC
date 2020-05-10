<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de telefonos</title>
</head>
<body>
<form action="/Agenda_Telefonica/src/servlets/ListarTelefonos.java" method="get">
	<c:set var="lista" scope="request" value="${telflist}" />
	<h1>Lista de telefonos</h1>

	<table>
		<tr>
			<td><strong>codigo</strong></td>
			<td><strong>telefono</strong></td>
			<td><strong>tipo</strong></td>
			<td><strong>Operadora</strong></td>
		</tr>
		<c:forEach var="p" items="${lista}">
			<tr>
				<td>${p.codigo}</td>
				<td>${p.numero}</td>
				<td>${p.tipo}</td>
				<td>${p.operadora}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="/index.html">Regresar al Index</a>
</form>
</body>
</html>
