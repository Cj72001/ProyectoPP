<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error</title>
    <style>
        .error-container {
            text-align: center;
            margin-top: 50px;
        }
        .error-message {
            color: red;
            font-size: 20px;
        }
        .back-link {
            margin-top: 20px;
            display: block;
        }
    </style>
</head>

<body>
    <div class="error-container">
        <h1>¡Ups! Algo salió mal.</h1>
        <div class="error-message">
            <h2>Error - Código de Estado: ${statusCode}</h2>
            <p>Fecha y Hora del Error: ${timestamp}</p>
            <p>Detalle del Error: ${errorMessage}</p>
        </div>
        <h1>¡VOLVEREMOS PRONTO !</h1>
        <a href="${pageContext.request.contextPath}/login">Volver</a>
    </div>
</body>
</html>


