<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>editar producto</title>

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
			<div class="row">
				<form role="form" action="ProductoServlet" method="post" id="edituser">
					<div class="form-group">
						<label>Nombre</label> <input type="text"
							class="form-control" data-validation="required" data-validation="length" 
							data-validation-length="max30" placeholder="Nombre" name="nombre" value="${sessionScope.producto.titulo}">
					</div>
					<div class="form-group">
						<label>Categoria</label> <input type="text"
							class="form-control" data-validation="required" data-validation="length"
							 data-validation-length="max30"	placeholder="categoria" name="categoria" value="${sessionScope.producto.categoria}">
					</div>
					<div class="form-group">
						<label for="descripcion">Descripcion</label> <input type="text"
							class="form-control" data-validation="required" data-validation="length" data-validation-length="max30"
							placeholder="descripcion" name="descripcion" value="${sessionScope.producto.descripcion}">
					</div>
					<div class="form-group">
						<label for="ejemplo_password_1">Estado</label> <select multiple
							class="form-control" name="estado" size="5" data-validation="required" data-validation="length" data-validation-length="max1">
							<option>Disponible</option>
							<option>Reservado</option>
							<option>Vendido</option>
							
						</select>
					</div>
					<div class="form-group">
						<label for="precio">Precio</label> <input data-validation="precio" 
							class="form-control" data-validation="precio"
							placeholder="precio" name="precio" value="${sessionScope.producto.precio}">
					</div>
					
					<button type="submit" class="btn btn-default" name="Register">Enviar</button>
				</form>

				</div>
			<!--/.row-->
		</div>
		<!--/.offcanvas-->
	</div>
</body>
</html>