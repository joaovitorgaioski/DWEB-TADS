<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Exemplo 1</title>
    </head>

    <body>
        <% for (int i = 0; i < 10; i++) { %>
            <p>Esta é a linha <%=i%></p>
        <% } %>

        <a href="telefone.jsp">Verificar telefones</a>
    </body>
</html>
