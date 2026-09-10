package br.edu.ifpr.irati.ads.servlet;

import br.edu.ifpr.irati.ads.dao.UsuarioDao;
import br.edu.ifpr.irati.ads.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;

@WebServlet(name = "loginservlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario u = usuarioDao.buscarPorEmail(email);

        // Checa o usuário e a senha
        if (u == null || !BCrypt.checkpw(senha, u.getSenha())) {
            req.getSession().setAttribute("usuarioLogado", null);
            resp.sendRedirect("login.jsp");
        } else {
            req.getSession().setAttribute("usuarioLogado", u);

            // Criação de token
            Cookie token = new Cookie("token", "F1EE133C90");
            token.setMaxAge(60);
            resp.addCookie(token);

            resp.sendRedirect("home.jsp");
        }
    }
}
