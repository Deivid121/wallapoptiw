<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Panel admin</title>

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
<jsp:include page="menuadmin.jsp" />


    <table class="table table-hover">
    <h2>Usuarios del sistema</h2>
        <tr>
        ��� <th>Id</th>
        ��� <th>Nombre</th>
        ��� <th>Apellido1</th>
            <th>Apellido2</th>
            <th>Email</th>
            <th>Contrase�a</th>
            <th>Ciudad</th>
            <th>Opciones</th>
        </tr>
        <tr>
        <c:if test="empty usuarios"><p>Usuarios vac�os</p></c:if>
        
<c:forEach items="${usuarios}" var="usuario"> <!-- recorremos todos los objetos de la coleccion usuarios y cada objeto devuelto lo asignamos a la variable usuario -->
<tr>
	<form>
		<td>${usuario.id }</td> <!-- Usuario es un POJO por lo que podemos acceder a sus propiedades sin necesidad de get/set -->
		<td>${usuario.nombre }</td>
		<td>${usuario.apellido1 }</td>
		<td>${usuario.apellido2 }</td>
		<td>${usuario.email }</td>
		<td>${usuario.password }</td>
		<td>${usuario.ciudad }</td>
		
	
		<td>
		<a href="usuarioAdmin?id=${usuario.id }"><span class="glyphicon glyphicon-tag"></span></a>
		<a href="editarUsuarioAdmin?id=${usuario.id}"><span class="glyphicon glyphicon-edit"></span></a>
		<a href="borrarUsuarioAdmin?id=${usuario.id}"><span class="glyphicon glyphicon-trash"></span></a></td>

	</form>
	</tr>
	</c:forEach>
	

	 <table class="table table-hover">
	 <h2>Productos del sistema</h2>
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
		<a href="VerProductosAdmin?id=${producto.id }"><span class="glyphicon glyphicon-tag"></span></a>
		<a href="EditarProductoAdmin?id=${producto.id}"><span class="glyphicon glyphicon-edit"></span></a>
		<a href="eliminarProductoClave?id=${producto.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
	</form>
	</tr>
	</c:forEach>
	
</body>
</html>