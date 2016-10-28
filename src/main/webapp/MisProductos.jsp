<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="description" content="">
		<meta name="author" content="">
		<link rel="icon" href="../../favicon.ico">
		
		<title>Mis productos</title>
		
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
    
    	 <table class="table table-hover">
			<tr>
				<th>Id</th>
				<th>Titulo</th>
				<th>Categor�a</th>
				<th>Descripci�n</th>
				<th>Precio</th>
				<th>Imagen</th>
				<th>Estado</th>
				<th>Opciones</th>
			</tr>
<c:forEach items="${productos}" var="producto"> <!-- recorremos todos los objetos de la coleccion usuarios y cada objeto devuelto lo asignamos a la variable usuario -->
		<tr>
		<form>
			<td>${producto.id }</td> 
			<td>${producto.titulo }</td> 
			<td>${producto.categoria }</td>
			<td>${producto.descripcion }</td>
			<td>${producto.precio }</td>
			<td><img src = "./imagenes/${producto.imagen }" width ="25" height="25"></td>
			<td>${producto.estado }</td>
			
		
			<td>
			<a href="VerProductos?id=${producto.id }"><span class="glyphicon glyphicon-tag"></span></a>
			<a href="EditarProductoU?id=${producto.id}"><span class="glyphicon glyphicon-edit"></span></a>
			<a href="eliminarProductoClaveU?id=${producto.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
		</form>
	</tr>
	</c:forEach>
    <footer>
      <p>&copy; 2016 Company, Inc.</p>
    </footer>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="../../dist/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    <script src="offcanvas.js"></script>
  </body>
</html>