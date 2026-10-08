package br.edu.ifpr.irati.ads.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "servletobjetosimplicitos", urlPatterns = "/servletelobjimpl")
public class ServletELObjetosImplicitos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        session.setAttribute("atributoSessao", "Esse é o valor do atributo armazenado na sessão");

        req.setAttribute("parametro", "param request");

        RequestDispatcher dispatcher = req.getRequestDispatcher("exemploelobjimpl.jsp");
        dispatcher.forward(req, resp);
    }
}
