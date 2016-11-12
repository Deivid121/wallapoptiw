<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>index</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/style.css">

<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.0.0.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.26/jquery.form-validator.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
</head>

<body>
	<jsp:include page="menu.jsp" />
	<div class="container">

		<div class="row row-offcanvas row-offcanvas-right">

			<div class="col-xs-12 col-sm-12">
				<div class="row">
					<c:forEach items="${productos}" var="producto"> <!-- recorremos todos los objetos de la coleccion usuarios y cada objeto devuelto lo asignamos a la variable usuario -->
<div class="col-xs-12 col-lg-4">
<div class="ProductCase">
			<div class="Description">
			
						<h2>${producto.titulo }</h2>
						<img class=ProductoImage src = "./imagenes/${producto.imagen }">
						<p>${producto.descripcion }</p>
						<p>Categoria:${producto.categoria }</p>
						<p>
							<a href="#">Precio:${producto.precio }</a>
						</p>
						<p>
							<a href="#">Vendedor:${producto.usuario }</a>
						</p>
						<p>
			</div>
						<div id="Details" >
							<a class="btn btn-default" href="Producto,jsp" role="button">View
								details &raquo;</a>
						</div>
							
						</p>
						</div>
					</div>
			</c:forEach>

					<!--/.col-xs-6.col-lg-4-->
				<!--/row-->
			</div>
			<!--/.col-xs-12.col-sm-9-->
		</div>
		<!--/.sidebar-offcanvas-->
	</div>
	<!--/row-->

	<hr>

	<footer>
		<p>&copy; 2016 Company, Inc.</p>
	</footer>

	</div>
	<!--/.container-->

</body>
</html>

