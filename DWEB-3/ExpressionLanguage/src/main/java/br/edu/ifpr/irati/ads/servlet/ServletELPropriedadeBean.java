package br.edu.ifpr.irati.ads.servlet;

import br.edu.ifpr.irati.ads.model.Usuario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "servletelpropriedadebean", urlPatterns = "/servletelpropriedadebean")
public class ServletELPropriedadeBean extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Usuario usuario = new Usuario(10L, "joao@gmail.com", "123", "");

        HttpSession session = req.getSession();
        session.setAttribute("usuario", usuario);

        RequestDispatcher dispatcher = req.getRequestDispatcher("exemplos-el/exemploelpropriedadebean.jsp");
        dispatcher.forward(req, resp);

    }
}
