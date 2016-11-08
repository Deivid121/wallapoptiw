<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Panel</title>
   <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">

    <!-- Latest compiled and minified JavaScript -->
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

   <script src ="./js/bootstrap.min.js"></script>

</head>
<body>
<nav class="navbar navbar-default" role="navigation">
      <!-- El logotipo y el icono que despliega el menÃº se agrupan
           para mostrarlos mejor en los dispositivos mÃ³viles -->
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse"
                data-target=".navbar-ex1-collapse">
          <span class="sr-only">Desplegar navegaciÃ³n</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">Logotipo</a>
      </div>
     
      <!-- Agrupar los enlaces de navegaciÃ³n, los formularios y cualquier
           otro elemento que se pueda ocultar al minimizar la barra -->
      <div class="collapse navbar-collapse navbar-ex1-collapse">
        <form class="navbar-form navbar-left" role="search">
          <div class="form-group ">
            <input type="text" class="form-control" placeholder="Buscar producto ...">
          </div>
          <button type="submit" class="btn btn-default">Buscar</button>
        </form>
        <form class="navbar-form navbar-left" role="search">
          <div class="form-group ">
            <input type="text" class="form-control" placeholder="Buscar usuario ...">
          </div>
          <button type="submit" class="btn btn-default">Buscar</button>
        </form>
        <ul class="nav navbar-nav">
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              Busqueda avanzada <b class="caret"></b>
            </a>
            <ul class="dropdown-menu">
              <form class="navbar-form navbar-left" role="search">
                <div class="form-group ">
                  <input type="text" class="form-control" placeholder="Categoria ...">
                  <input type="text" class="form-control" placeholder="Ciudad ...">
                  <input type="text" class="form-control" placeholder="Vendedor ...">
                  <input type="text" class="form-control" placeholder="Titulo ...">
                  <input type="text" class="form-control" placeholder="DescripciÃ³n ...">
                </div>
                <button type="submit" class="btn btn-default">Buscar</button>
              </form>
            </ul>
          </li>
        </ul>
      </div>
    </nav>
    <table class="table table-hover">
        <tr>
            <th>Id</th>
            <th>Nombre</th>
            <th>Apellido1</th>
            <th>Apellido2</th>
            <th>Email</th>
            <th>Ciudad</th>
        </tr>
        <tr>
            <td>Example</td>
            <td>Example</td>
            <td>Example</td>
            <td>Example</td>
            <td>Example</td>
            <td>Example</td>

        </tr>
    </table>
</body>
</html>