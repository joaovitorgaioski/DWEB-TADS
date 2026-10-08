<%@ page import="br.edu.ifpr.irati.ads.model.Usuario" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
    <h1>Home</h1>
    <p>Usuário logado: <%=usuario.getEmail()%></p>
    <a href="logout">Logout</a>
</body>
</html>