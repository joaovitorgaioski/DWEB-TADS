package br.edu.ifpr.irati.ads.dao;

import br.edu.ifpr.irati.ads.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;

@WebServlet(name = "cadastrousuarios", urlPatterns = "/scriptcadastrousuarios")
public class ScriptCadastroUsuarios extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Dao<Usuario> usuarioDao = new GenericDao<>(Usuario.class);

        // Criando usuários usando o BCrypt para salvar senhas com hash e sal
        Usuario u1 = new Usuario(0L, "joao@gmail.com", BCrypt.hashpw("123456", BCrypt.gensalt()), null);
        Usuario u2 = new Usuario(0L, "valter@gmail.com", BCrypt.hashpw("234567", BCrypt.gensalt()), null);
        Usuario u3 = new Usuario(0L, "thalita@gmail.com", BCrypt.hashpw("345678", BCrypt.gensalt()), null);

        usuarioDao.salvar(u1);
        usuarioDao.salvar(u2);
        usuarioDao.salvar(u3);
    }
}
