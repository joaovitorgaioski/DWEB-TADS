<%@ page import="br.edu.ifpr.irati.ads.model.Usuario" %>
<%@ page import="br.edu.ifpr.irati.ads.dao.Dao" %>
<%@ page import="br.edu.ifpr.irati.ads.dao.GenericDao" %>
<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>

<%
    Usuario u = new Usuario();
    try {
        Long id = Long.parseLong(request.getParameter("id"));
        Dao<Usuario> usuarioDao = new GenericDao<>(Usuario.class);
        u = usuarioDao.buscarPorId(id);
    } catch (Exception e) {
        response.sendRedirect("index.jsp");
    }
%>

<!doctype html>
<html>
<head>
    <title>Formulário de Cadastro</title>
</head>

<body>
<form action="scriptAtualizarUsuario.jsp" method="post">

    <input type="hidden" name="id" value="<%=u.getId()%>">

    <label for="nome">Nome</label>
    <input type="text" id="nome" name="nome">

    <label for="email">Email</label>
    <input type="email" id="email" name="email">

    <label for="senha">Senha</label>
    <input type="password" id="senha" name="senha">

    <input type="submit" value="Salvar">
</form>
</body>
</html>