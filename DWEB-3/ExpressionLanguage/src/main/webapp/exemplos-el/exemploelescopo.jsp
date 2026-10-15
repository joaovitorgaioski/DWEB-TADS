<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Exemplo EL Escopo</title>
</head>
<body>
    <h3>EL: acesso a variáveis no escopo</h3>

    <ul>
        <li><b>Atributo de sessão:</b> ${atributoSessao}</li>
        <li><b>Atributo de request:</b> ${atributoRequest}</li>
        <li><b>Atributo de contexto da aplicação:</b> ${dataDoContexto}</li>
    </ul>
</body>
</html>