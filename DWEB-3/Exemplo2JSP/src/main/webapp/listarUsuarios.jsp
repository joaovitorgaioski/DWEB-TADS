<%@ page import="org.hibernate.Session" %>
<%@ page import="br.edu.ifpr.irati.ads.dao.HibernateUtil" %>
<%@ page import="br.edu.ifpr.irati.ads.dao.Dao" %>
<%@ page import="br.edu.ifpr.irati.ads.model.Usuario" %>
<%@ page import="br.edu.ifpr.irati.ads.dao.GenericDao" %>
<%@ page import="java.util.List" %>
<%@page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>

<%
    Session dbSession = HibernateUtil.getSessionFactory().openSession();
    Dao<Usuario> usuarioDao = new GenericDao<>(Usuario.class);
    List<Usuario> usuarios = usuarioDao.buscarTodos(dbSession);
%>

<!doctype html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Lista de Usuários</title>
</head>
<body>
<p>Listar Usuários</p>

<table>
    <tr>
        <th>Nome</th>
        <th>E-mail</th>
        <th>Senha</th>
        <th></th>
    </tr>

    <% for(Usuario usuario: usuarios){ %>
    <tr>
        <td><%=usuario.getNome()%></td>
        <td><%=usuario.getEmail()%></td>
        <td><%=usuario.getSenha()%></td>
        <td><a href="formAtualizarUsuario.jsp?id=<%=usuario.getId()%>">Atualizar</a></td>
    </tr>
    <% } %>
</table>

<a href="formCadastroUsuario.jsp">Cadastrar Novo</a>
</body>
</html>

<%
    dbSession.close();
%>