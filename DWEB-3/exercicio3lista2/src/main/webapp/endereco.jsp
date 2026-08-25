<%@ page import="org.hibernate.HibernateException" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="br.edu.ifpr.irati.ads.dao.HibernateUtil" %>
<%@ page import="br.edu.ifpr.irati.ads.model.Usuario" %>
<%@ page import="br.edu.ifpr.irati.ads.model.Endereco" %>
<%@ page import="br.edu.ifpr.irati.ads.dao.Dao" %>
<%@ page import="br.edu.ifpr.irati.ads.dao.GenericDao" %>

<%
    try (Session bdSession = HibernateUtil.getSessionFactory().openSession()) {

        Dao<Usuario> usuarioDao = new GenericDao<>(Usuario.class);
        Dao<Endereco> enderecoDao = new GenericDao<>(Endereco.class);

        String operation = request.getParameter("operation");

        Long idUsuario = null;

        try {
            idUsuario = Long.parseLong(request.getParameter("idUsuario"));
        } catch (NumberFormatException e) {}

        if (idUsuario == null) {
            response.sendRedirect("formusuario.jsp");
            return;
        }

        Usuario usuario = usuarioDao.buscarPorId(idUsuario);

        if (usuario == null) {
            response.sendRedirect("formusuario.jsp");
            return;
        }

        if (operation != null && operation.equals("update")) {
            session.setAttribute("usuario", usuario);

            response.sendRedirect("formendereco.jsp");
            return;
        }

        if (operation != null && operation.equals("novo")) {
            Endereco endereco = new Endereco();

            session.setAttribute("usuario", usuario);
            session.setAttribute("endereco", endereco);

            response.sendRedirect("formendereco.jsp");
            return;
        }

        // Chega aq quando não há operation
        String logradouro = request.getParameter("logradouro");
        String numero = request.getParameter("numero");
        String bairro = request.getParameter("bairro");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String cep = request.getParameter("cep");

        Endereco endereco = usuario.getEndereco();

        if (endereco == null) { // Novo endereço
            endereco = new Endereco();

            endereco.setLogradouro(logradouro);
            endereco.setNumero(numero);
            endereco.setBairro(bairro);
            endereco.setCidade(cidade);
            endereco.setEstado(estado);
            endereco.setCep(cep);

            enderecoDao.salvar(endereco);

            usuario.setEndereco(endereco);
            usuarioDao.alterar(usuario);

        } else { // Muda endereço que ja existe
            endereco.setLogradouro(logradouro);
            endereco.setNumero(numero);
            endereco.setBairro(bairro);
            endereco.setCidade(cidade);
            endereco.setEstado(estado);
            endereco.setCep(cep);

            enderecoDao.alterar(endereco);
        }

        session.setAttribute("usuario", new Usuario());
        session.setAttribute("endereco", null);
        session.setAttribute("usuarios", usuarioDao.buscarTodos(bdSession));

        response.sendRedirect("formusuario.jsp");

    } catch (HibernateException ex) {
        throw new Exception("Conexão com o banco de dados indisponível");
    }

%>