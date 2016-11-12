<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>crear producto</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">

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
				<form role="form" action="crearProducto" method="post" enctype="multipart/form-data">
					<div class="form-group">
						<label for="nombre">Titulo</label> <input type="text"
							class="form-control" id="titulo_producto" placeholder="Titulo" name="titulo">
					</div>
					<div class="form-group">
						<label for="nombre">Descripci�n</label> <input type="text"
							class="form-control" id="descripcion_producto"
							placeholder="Descripcion" name="descripcion">
					</div>
					<div class="form-group">
						<label for="nombre">Precio</label> <input type="number"
							class="form-control" id="precio_producto"
							placeholder="Precio" name="precio">
					</div>
					<div class="form-group">
						<label for="nombre">Imagen</label> <input type="file" multiple
							class="form-control" id="imagen_producto"
							placeholder="Imagen" name="imagen">
					</div>

					<div class="form-group">
						<label for="ejemplo_password_1">Categoria</label> <select 
							class="form-control" name="categoria">
							<option>Mueble</option>
							<option>coche</option>
							<option>decoracion</option>
							<option>juguete</option>
						</select>
					</div>
					<button type="submit" class="btn btn-default">Enviar</button>
				</form>
			</div>
			<!--/.row-->
		</div>
		<!--/.offcanvas-->
	</div>
	<!--/.container-->
	<hr>
	<footer>
		<p>&copy; 2016 Company, Inc.</p>
	</footer>
</body>
</html>