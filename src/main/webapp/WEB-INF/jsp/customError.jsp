<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
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
            <% if (request.getAttribute("message") != null) { %>
                <p><%= request.getAttribute("message") %></p>
            <% } else { %>
                <p>Estamos experimentando problemas técnicos. Por favor, intenta de nuevo más tarde.</p>
            <% } %>
        </div>
        <a href="/" class="back-link">Volver a la página de inicio</a>
    </div>
</body>
</html>
