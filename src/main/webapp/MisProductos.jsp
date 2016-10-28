<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Off Canvas Template for Bootstrap</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">

    <!-- Latest compiled and minified JavaScript -->
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

   <script src ="./js/bootstrap.min.js"></script>

   


   
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
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
				<th>Imagen1</th>
				<th>Imagen</th>
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
			<td>${producto.imagen }</td>
			<td><img src = "./imagenes/${producto.imagen }" width ="25" height="25"></td>
		
			<td>
			<a href="VerProductosAdmin?id=${producto.id }"><span class="glyphicon glyphicon-tag"></span></a>
			<a href="EditarProductoAdmin?id=${producto.id}"><span class="glyphicon glyphicon-edit"></span></a>
			<a href="eliminarProductoClave?id=${producto.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
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