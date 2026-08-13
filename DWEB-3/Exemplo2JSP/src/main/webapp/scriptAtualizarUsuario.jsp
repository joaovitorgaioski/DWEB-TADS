<%@ page import="br.edu.ifpr.irati.ads.model.Usuario" %>
<%@ page import="br.edu.ifpr.irati.ads.dao.Dao" %>
<%@ page import="br.edu.ifpr.irati.ads.dao.GenericDao" %><%

    Long id = Long.parseLong(request.getParameter("id"));
    String nome = request.getParameter("nome");
    String email = request.getParameter("email");
    String senha = request.getParameter("senha");

    Usuario usuario = new Usuario(id, nome, email, senha);

    Dao<Usuario> usuarioDao = new GenericDao<>(Usuario.class);
    usuarioDao.salvar(usuario);

    response.sendRedirect("listarUsuarios.jsp");
%>