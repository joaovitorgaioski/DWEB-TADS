package br.edu.ifpr.irati.ads.servlet;

import br.edu.ifpr.irati.ads.customjakartamail.exception.SendMailException;
import br.edu.ifpr.irati.ads.customjakartamail.mail.Email;
import br.edu.ifpr.irati.ads.customjakartamail.mail.SendMail;
import br.edu.ifpr.irati.ads.dao.GenericDao;
import br.edu.ifpr.irati.ads.dao.UsuarioDao;
import br.edu.ifpr.irati.ads.model.Usuario;
import br.edu.ifpr.irati.ads.util.JwtProperties;
import br.edu.ifpr.irati.ads.util.JwtUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.util.Properties;

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

            // Criação de token JWT
            JwtProperties.loadProperties(req.getServletContext());
            Properties props = JwtProperties.getProperties();
            String[] roles = {"admin", "user"}; // Normalmente esses papéis estão em um banco
            String jwtToken = JwtUtils.generateToken(
                    u.getEmail(),
                    roles,
                    Long.parseLong(props.getProperty("jwt_default_expiration")),
                    props.getProperty("jwt_passwd")
            );

            // Salvando o token JWT no cookie
            Cookie token = new Cookie("token", jwtToken);
            token.setMaxAge(Integer.parseInt(props.getProperty("jwt_default_expiration")) / 1000);
            resp.addCookie(token);

            // Armazenamos o token para o usuário no banco
            u.setToken(jwtToken);
            (new GenericDao<Usuario>(Usuario.class)).alterar(u);

            Email email1 = new Email("valter.junior@ifpr.edu.br", "Login realizado com sucesso!", "O usuário " + u.getEmail() + " esta logado no sistema!");

//            try {
//                SendMail.sendMail(email1, req.getServletContext().getResource("/WEB-INF/mail.properties").getPath());
//            } catch (SendMailException e) {
//                e.printStackTrace();
//            }

            resp.sendRedirect("home.jsp");
        }
    }
}
