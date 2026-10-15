<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Exemplo EL Propriedade Bean</title>
</head>
<body>
<h3>EL: acesso a propriedades de um bean</h3>
<ul>
    <li><b>ID:</b> ${usuario.id} </li>
    <li><b>Email:</b> ${usuario.email} </li>
    <li><b>Senha:</b> ${usuario.senha} </li>
    <li><b>Token:</b> ${usuario.token} </li>
</ul>
</body>
</html>