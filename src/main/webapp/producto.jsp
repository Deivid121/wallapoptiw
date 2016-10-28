<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">




<c:forEach items="${productos}" var="producto"> <!-- recorremos todos los objetos de la coleccion usuarios y cada objeto devuelto lo asignamos a la variable usuario -->
<div class="col-xs-12 col-lg-4">
						<h2>${producto.titulo }</h2>
						<img class=ProductoImage src = "./imagenes/${producto.imagen }">
						<p>${producto.descripcion }</p>
						<p>Categoria:${producto.categoria }</p>
						<p>
							<a href="#">Precio:${producto.precio }</a>
						</p>
						<p>
							<a href="#">Vendedor:${producto.usuario }</a>
						</p>
						<p>
							<a class="btn btn-default" href="#" role="button">View
								details &raquo;</a>
						</p>
					</div>
			</c:forEach>
