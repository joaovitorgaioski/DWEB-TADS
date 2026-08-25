<%@ page import="org.hibernate.HibernateException" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="br.edu.ifpr.irati.ads.dao.HibernateUtil" %>
<%@ page import="br.edu.ifpr.irati.ads.model.Usuario" %>
<%@ page import="br.edu.ifpr.irati.ads.dao.Dao" %>
<%@ page import="br.edu.ifpr.irati.ads.dao.GenericDao" %><%

    try (Session bdSession = HibernateUtil.getSessionFactory().openSession()){

        Dao<Usuario> usuarioDao = new GenericDao<>(Usuario.class);
        String operation = request.getParameter("operation");
        Long id = null;
        try {
            id = Long.parseLong(request.getParameter("id"));
        }catch (NumberFormatException nfe) {}
        if (operation != null && operation.equals("delete")) {
            Usuario usuario = usuarioDao.buscarPorId(id);
            usuarioDao.excluir(usuario);
            session.setAttribute("usuario", new Usuario());
            session.setAttribute("usuarios", usuarioDao.buscarTodos(bdSession));
        } else if (operation != null && operation.equals("update")) {
            Usuario usuario = usuarioDao.buscarPorId(id);
            session.setAttribute("usuario", usuario);
            session.setAttribute("usuarios", usuarioDao.buscarTodos(bdSession));
        } else {
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String cpf = request.getParameter("cpf");
            String dataNascimento = request.getParameter("dataNascimento");
            if (id != null && id == 0){//cadastrar
                Usuario usuario = new Usuario(nome, cpf, email, dataNascimento);
                usuarioDao.salvar(usuario);
                session.setAttribute("usuario", new Usuario());
                session.setAttribute("usuarios", usuarioDao.buscarTodos(bdSession));
            } else if (id != null) { //alterar
                Usuario usuario = usuarioDao.buscarPorId(id);
                usuario.setNome(nome);
                usuario.setEmail(email);
                usuario.setCpf(cpf);
                usuario.setDataNascimento(dataNascimento);
                usuarioDao.alterar(usuario);
                session.setAttribute("usuario", new Usuario());
                session.setAttribute("usuarios", usuarioDao.buscarTodos(bdSession));
            } else { //chamada sem passar parâmetros
                session.setAttribute("usuario", new Usuario());
                session.setAttribute("usuarios", usuarioDao.buscarTodos(bdSession));
            }
        }
        response.sendRedirect("formusuario.jsp");
    }catch (HibernateException he) {
        throw new Exception("Conexão com o banco de dados indisponível");
    }
%>