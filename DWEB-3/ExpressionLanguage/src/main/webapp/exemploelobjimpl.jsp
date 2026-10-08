<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Exemplo EL Objetos Implícitos</title>
</head>
<body>
<h3>EL: acesso a objetos implícitos</h3>

<ul>
    <li><b>User agent:</b> ${header["User-Agent"]}</li>
    <li><b>ID da sessão:</b> ${pageContext.session.id}</li>
    <li><b>Atributo da sessão:</b> ${atributoSessao}</li>
    <li><b>Servidor:</b> ${pageContext.servletContext.serverInfo}</li>
    <li><b>JSESSIONID:</b> ${cookie.JSESSIONID.value}</li>
    <li><b>header accept:</b> ${header.accept}</li>
    <li><b>header accept[0]:</b> ${headerValues.accept[0]}</li>
    <li><b>Parametro do request:</b> ${requestScope.parametro}</li>
</ul>
</body>
</html>