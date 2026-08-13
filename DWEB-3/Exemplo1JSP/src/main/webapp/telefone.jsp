<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="br.edu.ifpr.irati.ads.dao.HibernateUtil" %>
<%@page import="br.edu.ifpr.irati.ads.dao.Telefone" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="java.util.List" %>
<%@ page import="br.edu.ifpr.irati.ads.dao.Dao" %>
<%@ page import="br.edu.ifpr.irati.ads.dao.GenericDao" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Telefones</title>
    </head>

    <body>
        <%
            Session new_session = HibernateUtil.getSessionFactory().openSession();
            Dao<Telefone> telefoneDao = new GenericDao<>(Telefone.class);
            List<Telefone> telefones = telefoneDao.buscarTodos(new_session);
            for (Telefone t: telefones) {
                System.out.println(t.getNumero());
            }
            new_session.close();
        %>
    </body>
</html>
