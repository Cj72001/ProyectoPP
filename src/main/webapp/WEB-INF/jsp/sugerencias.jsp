<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@include file="/WEB-INF/jsp/include-css.jsp"%>
<title>Sección de Sugerencias</title>
<style>
        body {
            font-family: Arial, sans-serif;
        }

        .suggestions-section {
            max-width: 600px;
            margin: 20px auto;
        }

        .suggestion-form {
            margin-bottom: 20px;
        }

        .suggestion-form textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
        }

        .suggestion-form button {
            background-color: #2c3640;
            color: white;
            padding: 10px 15px;
            border: none;
            cursor: pointer;
        }

        .suggestion-list {
            list-style: none;
            padding: 0;
        }

        .suggestion {
            border: 1px solid #ddd;
            padding: 10px;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
	<!-- inluyendo header -->
	<%@include file="/WEB-INF/jsp/header.jsp"%>
	
    <div class="suggestions-section">
        <h2 class="colordiv">Deja tus comentarios</h2>        
	<form method="post" action="addComentario">
        <div class="suggestion-form">            
            
	        <div class="box">
		        <input type="text" name="mensaje" placeholder="Escribe tus opiniones o sugencias" onFocus="field_focus(this, 'nameActivity');" onblur="field_blur(this, 'nameActivity');" class="carnet" />
	        </div> <!-- End Box -->
        
            <h3>${errorAE}</h3>
      
             <br> <input class="btn2"type="submit" value="Enviar Sugerencia">
       </div>     
     </form>
    </div>
</body>
</html>