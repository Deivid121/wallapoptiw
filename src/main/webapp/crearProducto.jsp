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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script src="./js/bootstrap.min.js"></script>





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
	<nav class="navbar navbar-default" role="navigation">
		<!-- El logotipo y el icono que despliega el men� se agrupan
       para mostrarlos mejor en los dispositivos m�viles -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-ex1-collapse">
				<span class="sr-only">Desplegar navegaci�n</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Logotipo</a>
		</div>

		<!-- Agrupar los enlaces de navegaci�n, los formularios y cualquier
       otro elemento que se pueda ocultar al minimizar la barra -->
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<form class="navbar-form navbar-left" role="search">
				<div class="form-group ">
					<input type="text" class="form-control"
						placeholder="Buscar producto ...">
				</div>
				<button type="submit" class="btn btn-default">Buscar</button>
			</form>
			<ul class="nav navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> Busqueda avanzada <b class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<form class="navbar-form navbar-left" role="search">
							<div class="form-group ">
								<input type="text" class="form-control"
									placeholder="Categoria ..."> <input type="text"
									class="form-control" placeholder="Ciudad ..."> <input
									type="text" class="form-control" placeholder="Vendedor ...">
								<input type="text" class="form-control" placeholder="Titulo ...">
								<input type="text" class="form-control"
									placeholder="Descripci�n ...">
							</div>
							<button type="submit" class="btn btn-default">Buscar</button>
						</form>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li>
					<div class="form-group ">
						<form class="form-inline navbar-form" role="form">
							<label class="sr-only" for="ejemplo_email_2">Email</label> <input
								type="email" class="form-control" id="ejemplo_email_2"
								placeholder="Introduce tu email"> <label class="sr-only"
								for="ejemplo_password_2">Contrase�a</label> <input
								type="password" class="form-control" id="ejemplo_password_2"
								placeholder="Contrase�a">
							<button type="submit" class="btn btn-default">Entrar</button>
					</div>
					</form>
				</li>
				<li><a href="#">Registrarse</a></li>
			</ul>
		</div>
	</nav>

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

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script src="../../dist/js/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
	<script src="offcanvas.js"></script>
</body>
</html>