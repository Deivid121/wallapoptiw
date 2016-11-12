<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<jsp:include page="menuadmin.jsp" />
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
              <a href="/wallapoptiw/editarUsuarioAdmin.jsp" class="btn btn-default">Editar pefil</a>
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
