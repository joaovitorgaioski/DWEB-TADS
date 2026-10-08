<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Exemplo EL Propriedade Bean</title>
</head>
<body>
<h3>EL: acesso a propriedade de um bean</h3>

<ul>
    <li><b>ID:</b> ${usuario.id}</li>
    <li><b>Nome:</b> ${usuario.nome}</li>
    <li><b>Email:</b> ${usuario.email}</li>
    <li><b>Senha:</b> ${usuario.senha}</li>
    <li><b>Válido:</b> ${usuario.valido}</li>
</ul>
</body>
</html>