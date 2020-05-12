<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>


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







<title>Agenda</title>
</head>
<body>

	<c:set var="user" value="${requestScope['user']}" />



	<!--Cabecera-->
	<header>

		<!-- Navbar -->
		<nav
			class="navbar navbar-expand-lg navbar-dark griss row scrolling-navbar fixed-top">

			<ul 
				style="margin-left: 20px; font-size: 17px">
				<li ><a
					href="/Agenda_Telefonica/index.html"
					class="nav-link" style="font-size: 13px;" style="color: black;"> <span
						>Inicio</span></a></li>
			</ul>
			<!-- Search form -->
			
			<form class=" col-xs-8 col-sm-4 col-md-4 col-mg-4 mr-sm-4"
				id="formulario"
				action="/Agenda_Telefonica/Search">
				<input class="form-control my-0 py-1" type="text" name="usuario"
					placeholder="Buscar por Correo" aria-label="Search" id="buscar">
			</form>

			<form><button type="button"
			 data-toggle="modal"
			data-target="#AddPhone">
			<i  ></i> Añadir Telefono
		   </button></form>



			<!-- Datos extras -->
			<form >
			<div >
				<a href="Agenda?logout=true" 
					style="font-size: 13px;" style="color: black"; style="margin-left: 618px ;" type="submit" name="accion"
					value="Salir"> Cerrar Sesion </a>
			</div>		
			</form>

			</ul>
		</nav>
	</header>
	<!--Cabecera-->



	<br>
	<br>
	<br>
	<br>
	<br>
	<br>



	<div class="container">
		<c:choose>
			<c:when test="${user.telefono.size() > 0}">
				<!-- <button class="btn blue-gradient"> </button>-->


				
				
				<br>
				<br>

				<!-- Search form -->
				


				<c:set var="i" value="${0}" />
				<table class="table">
					<thead >
						<tr >

							<th scope="col" style="font-size: 20px;">Numero</th>
							<th scope="col" style="font-size: 20px;">Tipo</th>
							<th scope="col" style="font-size: 20px;">Operadora</th>
							
							
						</tr>
					</thead>
					<c:forEach var="telefono" items="${user.telefono}">
						<c:set var="i" value="${i+1}" />
						<tbody>
							<tr>

								<td scope="col"
									style="font-size: 15px; font-family: 'Scada', sans-serif; color: white;">
									${telefono.numero}</td>
								<td scope="col"
									style="font-size: 15px; font-family: 'Scada', sans-serif; color: white;">${telefono.tipo}</td>
								<td scope="col"
									style="font-size: 15px; font-family: 'Scada', sans-serif; color: white;">
									${telefono.operadora}</td>
								<td>

									<div style="padding-top: 15em;" class="modal fade"
										id="confirm-delete${i}" tabindex="-1" role="dialog"
										aria-labelledby="myModalLabel" aria-hidden="true">
										<div class="modal-dialog">
											<div 
												style="background: linear-gradient(to bottom, rgba(10, 10, 5, 0.3), rgba(0, 0, 0, 0.5));">
												<div class="modal-header">
													<h5 class="h5"
														 font-size: 27px; color: white;">Eliminar
														numero</h5>

												</div>

												<div class="modal-body">
													<p class="card-text"
														style="font-family: 'Scada', sans-serif; font-size: 16px; color: white;">
														${telefono.numero} Ud esta eliminando su numero telefonico es correcto...?</p>
												</div>
												<div >

													<a
														href="/Agenda_Telefonica/EditPhone?delete=true&idTel=${telefono.codigo}"
														
														 class= "btn btn-ok" style="font-size: 17px;">ELIMINAR</a>
												</div>
											</div>
										</div>

									</div>


									

								</td>
							</tr>

						</tbody>




						<!-- Para editar un telefono -->

						<div class="modal fade" id="editar${i}" tabindex="-1"
							role="dialog" aria-labelledby="exampleModalCenterTitle"
							aria-hidden="true">
							<div class="modal-dialog modal-dialog-centered" role="document">
								<div class="modal-content"
									style="background: linear-gradient(to bottom, rgba(7, 199, 233, 0.6), rgba(0, 0, 0, 0.5));">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalCenterTitle"
											style="color: white; font-size: 27px; font-family: 'Kaushan Script', cursive;">Editar
											Contacto</h5>
									</div>
									<form
										action="/Agenda_Telefonica/EditPhone"
										method="POST">

										<input type="hidden" name="codigotel"
											value="${telefono.codigo}">

										<div class="modal-body">
											<div class="form-group">
												<!-- Material input -->
												<div class="md-form">
													<input
														style="font-size: 13px; color: white; padding-top: 17px;"
														type="text" id="form1" class="form-control"
														value="${telefono.numero}" id="numero" name="numero">
													<label for="form1"
														style="font-family: 'BenchNine', sans-serif; color: white; font-size: 20px;">Ingrese
														el Numero</label>
												</div>
											</div>
											<div class="form-row">
												<!-- Material input -->
												<div class="md-form form-group col-md-6">
													<input
														style="font-size: 13px; color: white; padding-top: 17px;"
														type="text" class="form-control" value="${telefono.tipo}"
														id="tipo" name="tipo"> <label for="form1"
														style="font-family: 'BenchNine', sans-serif; color: white; font-size: 20px; margin-left: 3px;">Tipo</label>
												</div>
												<!-- Material input -->
												<div class="md-form form-group col-md-6">
													<input
														style="font-size: 13px; color: white; padding-top: 17px;"
														type="text" class="form-control"
														value="${telefono.operadora}" id="operadora"
														name="operadora"> <label for="operadora"
														style="font-family: 'BenchNine', sans-serif; color: white; font-size: 20px; margin-left: 3px;">Operadora</label>
												</div>

											</div>
										</div>
										<div class="modal-footer">

											<button type="submit" 
												style="font-size: 11px;">
												<i style="font-size: 11px;"></i> Guardar
											</button>
										</div>
									</form>
								</div>
							</div>
						</div>
						<!-- Fin editar un telefono -->

						<!-- Fin card -->
					</c:forEach>
				</table>
	</div>
	</c:when>


	<c:otherwise>
	
	
		<section  class="row">

			<h1 class="cl-md-12 ">Agenda Vacia</h1>


		</section>

		



	</c:otherwise>

	</c:choose>



	<!-- Inicio Crear Telefono -->

	<div class="modal fade" id="AddPhone" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content"
				style="background: linear-gradient(to bottom, rgba(10, 10,3,0.3), rgba(0, 0, 0, 0.8));">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalCenterTitle"
						style="color: white; font-size: 27px; ">Registrar Telefono</h5>
				</div>

				<form
					action="/Agenda_Telefonica/AgregarPhone"
					method="POST">
					<input type="hidden" name="idtel" value="${telefono.id}">
					<div class="modal-body">

						<div class="form-group">
							<!-- Material input -->
							<div class="md-form">
								<input type="text" id="form1" class="form-control" id="numero"
									name="numero"
									style="font-size: 13px; color: white; padding-top: 17px;">
								<label for="numero"
									style="font-family: 'BenchNine', sans-serif; color: white; font-size: 20px;">Numero</label>
							</div>
						</div>

						<div class="form-group">
							<!-- Material input -->
							<div class="md-form">
								<input style="font-size: 13px; color: white; padding-top: 18px;"
									type="text" class="form-control" value="" id="tipo" name="tipo">
								<label for="tipo"
									style="font-family: 'BenchNine', sans-serif; color: white; font-size: 20px; margin-left: 3px;">Tipo</label>
							</div>

						</div>	
						
						<div class="form-group">		

							<!-- Material input -->
							<div class="md-form ">
								<input style="font-size: 13px; color: white; padding-top: 17px;"
									type="text" class="form-control" value="" id="operadora"
									name="operadora"> <label for="operadora"
									style="font-family: 'BenchNine', sans-serif; color: white; font-size: 20px; margin-left: 3px;">Operadora</label>
							</div>



						</div>
					</div>
					<div class="form-group text-center">
						<button type="submit" 
							style="font-size: 11px;">
							<i  style="font-size: 11px;"></i> Registrar Telefono
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- Fin Crear Telefono -->

















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