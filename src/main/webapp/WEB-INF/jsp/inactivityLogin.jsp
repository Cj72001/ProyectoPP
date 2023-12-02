<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@include file="/WEB-INF/jsp/include-css.jsp" %>
<title>Login</title>
</head>
<body>
<div class="main">
   <div class="signin"> 
      <form method="post" action="loginn">
        <img  src="<c:url value='/resources/img/login.jpg'/>" width="100px"/>
        <h1> Iniciar sesión</h1>
        <p>Sesión expirada. Favor vuelva a ingresar</p>
        <div class="box">
          <input type="carnet" name="CARNET" placeholder="Carnet" onFocus="field_focus(this, 'carnet');" onblur="field_blur(this, 'carnet');" class="carnet" />
          <input type="password" name="PASSWORD" placeholder="Contraseña" onFocus="field_focus(this, 'password');" onblur="field_blur(this, 'password');" class="carnet" />
        </div>
        <h3>${errorL}</h3>   
        <br> <input class="btn4" type="submit" value="ENTRAR">
      </form> 
      <div class="booter">
        <a href="${pageContext.request.contextPath}/register">Crear una nueva cuenta</a>
      </div>
      <div>
        <a href="${pageContext.request.contextPath}/recoveryPasword">Recuperar contraseña</a>
      </div>
    </div>
    <div class="signin-img">
      <img  src="<c:url value='/resources/img/signin-image.jpg'/>" width="277px"/>
    </div>
</div>
</body>
</html>