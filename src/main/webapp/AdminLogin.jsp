<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.0.0.min.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.3.26/jquery.form-validator.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

<div class="col-md-4 col-md-offset-4">
        
        <h4>Login para administradores</h4>
    </div>
    <div class="col-md-4 col-md-offset-4">
        <form class="form-group" role="form" action="admin" method="post" id="login">
                  <label class="sr-only" for="ejemplo_email_2">Email</label>
                  <input type="text" class="form-control" name="User"
                         placeholder="Introduce tu email" data-validation="email" 
                         data-validation-error-msg="No has introducido un email valido (a@b.c)">
                          <br>
                  <label class="sr-only" for="ejemplo_password_2" >ContraseÃ±a</label>
                  <input type="password" class="form-control" name="Pass" 
                         placeholder="Contraseña" data-validation="length" data-validation-length="min8" 
                         data-validation-error-msg="La contraseña tiene al menos 8 caracteres" >
                         <br>
                  <input type="submit" class="btn btn-default" value="Entrar"></input>
                  
                </div>
        </form>
   </div>
          <script>
			$.validate({
				form : '#login',	
				 onError : function($form) {
				      return false;
				    }
		    });
		</script>
</body>
</html>