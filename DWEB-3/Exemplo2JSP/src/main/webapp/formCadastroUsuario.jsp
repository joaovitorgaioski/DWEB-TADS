<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>

<!doctype html>
<html>
<head>
    <title>Formulário de Cadastro</title>
</head>

<body>
<form action="scriptCadastroUsuario.jsp" method="post">
    <label for="nome">Nome</label>
    <input type="text" id="nome" name="nome">

    <label for="email">Email</label>
    <input type="email" id="email" name="email">

    <label for="senha">Senha</label>
    <input type="password" id="senha" name="senha">

    <input type="submit" value="Enviar">
</form>
</body>
</html>