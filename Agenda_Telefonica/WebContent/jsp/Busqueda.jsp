<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Buscar</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<!-- Optional theme -->
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
<!-- Google Fonts -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
<!-- Bootstrap core CSS -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Material Design Bootstrap -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.15.0/css/mdb.min.css"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Kaushan+Script&display=swap"
	rel="stylesheet">

<link
	href="/Agenda_Telefonica/css/estilos.css"
	rel="stylesheet" type="text/css" />

</head>
<body>
	<c:set var="users" value="${requestScope['users']}" />


	<div class="container">
		<!--Cabecera-->
		<header>

			<!-- Navbar -->
			<nav
				class="navbar navbar-expand-lg navbar-dark gris row scrolling-navbar fixed-top">
				<!-- logo -->
				<ul class="navbar-nav mr-auto"
					style="margin-left: 20px; font-size: 17px">
					<li class="nav-item"><a
						href="/Agenda_Telefonica/index.html"
						class="nav-link" style="color: white;"><i 
							aria-hidden="true"></i> <span
							class="clearfix d-none d-sm-inline-block">Inicio</span></a></li>
				</ul>

				<!-- Search form -->
				<form class=" col-xs-8 col-sm-4 col-md-4 col-mg-4 mr-sm-4"
					id="formulario"
					action="/Agenda_Telefonica/Search">
					<input class="form-control my-0 py-1" type="text" name="usuario"
						placeholder="Search" aria-label="Search" id="buscar">

				</form>
				<!-- Datos extras -->
				<ul class="nav navbar-nav nav-flex-icons ml-auto  mr-sm-2">
					<li class="nav-item"><a class="nav-link"
						href="/Agenda_Telefonica/Agenda"
						style="font-size: 17px; margin-right: 20px;"><i
							></i> <span
							
							style="font-size: 17px;">Telefonos</span></a></li>
					<li class="nav-item"><a class="nav-link"
						href="/Agenda_Telefonica/html/CreateAccount.html"
						style="font-size: 17px; margin-right: 20px;"><i
							></i> <span
							
							style="font-size: 17px;">Registro</span></a></li>

					<li class="nav-item"><a class="nav-link"
						href="html/Login.html"
						style="font-size: 17px; margin-right: 20px;"><i
							></i> <span
							
							style="font-size: 17px;">Cuenta</span></a></li>
				</ul>
			</nav>
		</header>
		<!--Cabecera-->


	</div>

	<div class="container">


		<c:choose>
			<c:when test="${users.size() > 0}">

				<!-- <button class="btn blue-gradient"> </button>-->


				<br>
				<br>
				<br>
				<br>
				<br>
				<br>




				<table class="table">
					<thead >
						<tr >


							<th scope="col" style="font-size: 20px;">Correo</th>
							<th scope="col" style="font-size: 20px;">Numero </th>
							<th scope="col" style="font-size: 20px;"></th>
						</tr>
					</thead>

					<tbody>

						<c:set var="i" value="${0}" />

						<c:forEach var="userr" items="${users}">

							<c:set var="i" value="${i+1}" />

							<tr data-toggle="modal" data-target="#exampleModal${i}"
								data-whatever="@mdo">

								<td scope="col"
									style="font-size: 15px; font-family: 'Scada', sans-serif; color: white;">
									${userr.email}</td>
								<td scope="col"
									style="font-size: 15px; font-family: 'Scada', sans-serif; color: white;">
									${userr.telefono[0].numero}</td>
							</tr>


							<div style="padding-top: 15em;" class="modal fade"
								id="exampleModal${i}" tabindex="-1" role="dialog"
								aria-labelledby="exampleModalLabel" aria-hidden="true">
								<div class="modal-dialog" role="document">
									<div class="modal-content"
										style="background: linear-gradient(to bottom, rgba(0,0,0,1,), rgba(0, 0, 0, 0.5));">
										<div class="modal-header">
											<h5
												style="color: white; font-size: 37px; font-family: 'Kaushan Script', cursive;">Detalles
												del contacto</h5>


										</div>
										<div class="modal-body">
											<h3 class="modal-title row justify-content-center h5"
												id="exampleModalLabel">${userr.nombre}
												${userr.apellido}</h3>
										
											<p class="row" style="background: #001; box-sizing: border-box; ;">

												<a class="col-md-4"
													style="color: blue; font-size: 17px; ">Numero</a>
												<a class=" col-md-4 "
													style="color: blue; font-size: 17px; ">Tipo</a>
												<a class=" col-md-4"
													style="color: blue; font-size: 17px; ">Operadora</a>
											</p>
										
											<c:forEach var="telefono" items="${userr.telefono}">
												<p class="row">
													<a href="tel:${telefono.numero}" class="col-md-4 numero">${telefono.numero}</a>
													<a class="col-md-4"
														style="color: black; font-size: 17px;  ">${telefono.tipo}</a>
													<a class="com-md-4"
														style="color: black; font-size: 17px;  ">${telefono.operadora}</a>
												</p>

											</c:forEach>

											<a href="mailto:${userr.email}"
												
												id="corre"> <i>Enviar Correo :</i>
												${userr.nombre}
											</a>

										</div>
										<div class="modal-footer">
										</div>
									</div>
								</div>
							</div>

						</c:forEach>
					</tbody>
		

			</c:when>
			<c:otherwise>
				<h1>NO EXISTEN CONTACTOS</h1>
			</c:otherwise>

		</c:choose>
	</div>









	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous"></script>
	<!-- JQuery -->
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.15.0/js/mdb.min.js"></script>
	<script src="js/funcion.js"></script>
</body>
</html>