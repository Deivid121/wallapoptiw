<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Mostrar productos</title>

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
</head>
<body>
<jsp:include page="menu.jsp" />
<c:if test="${empty listaProductos }"> <!-- usuarios es un atributo metido en el request por eso no es necesario ponerle el prefijo param -->
<p class="error">Si no ves productos es porque has accedido directamente a la pagina y por tanto no has pasado
por el servlet controlador y no hay datos en el objeto request.
</p>
</c:if>
<table border="1">
<tr>
<th>Titulo</th>
<th>Categoría</th>
<th>Descripción</th>
<th>Precio</th>
<th>Imagen1</th>
<th>Imagen</th>
</tr>
<c:forEach items="${listaProductos}" var="producto"> <!-- recorremos todos los objetos de la coleccion usuarios y cada objeto devuelto lo asignamos a la variable usuario -->
<tr>
	<td>${producto.titulo }</td> 
	<td>${producto.categoria }</td>
	<td>${producto.descripcion }</td>
	<td>${producto.precio }</td>
	<td>${producto.imagen }</td>
	<td><img src = "./imagenes/${producto.imagen }" width ="25" height="25"></td>
</tr>

</c:forEach>
</table>
</body>
</html>