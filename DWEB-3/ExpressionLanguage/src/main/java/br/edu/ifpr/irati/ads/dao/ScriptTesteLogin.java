package br.edu.ifpr.irati.ads.dao;

import br.edu.ifpr.irati.ads.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;

@WebServlet(name = "loginusuario", urlPatterns = "/scriptloginusuario")
public class ScriptTesteLogin extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario u = usuarioDao.buscarPorEmail(email);

        if (u == null) {
            resp.getWriter().println("Usuário não encontrado");
        } else if(BCrypt.checkpw(senha, u.getSenha())) { // Checa a senha
            resp.getWriter().println("Bem-vindo " + u.getEmail() + "!");
        } else { // Senha incorreta
            resp.getWriter().println("Senha incorreta!");
        }
    }
}
