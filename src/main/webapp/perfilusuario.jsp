<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Perfil usuarios</title>

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
          <div class="list-group">
            <div class="list-group-item">
              <h4>Nombre  </h4>${sessionScope.usuario.nombre}
            </div>
            <div class="list-group-item">
              <h4>Primer apellido  </h4>${sessionScope.usuario.apellido1}
            </div>
            <div class="list-group-item">
              <h4>Segundo apellido  </h4>${sessionScope.usuario.apellido2}
            </div>
            <div class="list-group-item">
              <h4>Contraseña  </h4>********
            </div>
            <div class="list-group-item">
              <h4>E-mail  </h4>${sessionScope.usuario.email}
            </div>
             <div class="list-group-item">
              <h4>Ciudad  </h4>${sessionScope.usuario.ciudad}
            </div>
            <div class="list-group-item">
              <a href="/wallapoptiw/editarUsuario.jsp" class="btn btn-default">Editar pefil</a>
              <a href="MisProductos" class="btn btn-default">Administrar productos</a>
              <a href="borrarUsuario" class="btn btn-default">Borrar cuenta</a>
            </div>
          </div>
        </div><!--/.row-->
      </div><!--/.offcanvas-->
    </div><!--/.container-->
    <hr>
    <footer>
      <p>&copy; 2016 Company, Inc.</p>
    </footer>
  </body>
</html>
