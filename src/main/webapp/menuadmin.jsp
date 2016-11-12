<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav id=nav class="navbar navbar-default" role="navigation">

	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-ex1-collapse">
			<span class="sr-only">Desplegar navegación</span> <span
				class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="index.jsp">Logotipo</a>
	</div>

	<!-- Agrupar los enlaces de navegación, los formularios y cualquier
       otro elemento que se pueda ocultar al minimizar la barra -->
	<div id=topNavElement class="collapse navbar-collapse navbar-ex1-collapse">
		<form class="navbar-form navbar-left" role="search" action = "buscarProductosSimple" method ="post">
			<div class="form-group ">
				<input type="text" class="form-control" placeholder="Buscar producto ..." name = "palabra">
			</div>
			<button type="submit" class="btn btn-default">Buscar</button>
		</form>
		<ul class="nav navbar-nav">
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown"> Busqueda avanzada <b class="caret"></b>
			</a>
				<ul class="dropdown-menu">
					<form class="navbar-form navbar-left" role="search" action ="buscarProducto" method ="post">
						<div class="form-group ">
							<input type="text" class="form-control"	placeholder="Categoria ..." name = "categoria"> 
							<input type="text" class="form-control" placeholder="Ciudad ..." name = "ciudad"> 
							<input type="text" class="form-control" placeholder="Vendedor ..." name = "vendedor">
							<input type="text" class="form-control" placeholder="Titulo ..." name = "titulo">
							<input type="text" class="form-control" placeholder="Descripcion ..." name = "descripcion">
						</div>
						<button type="submit" class="btn btn-default">Buscar</button>
					</form>
				</ul></li>
		</ul>
	</div>
</nav>
