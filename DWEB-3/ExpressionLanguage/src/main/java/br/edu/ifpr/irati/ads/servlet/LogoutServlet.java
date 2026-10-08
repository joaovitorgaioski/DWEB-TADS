package br.edu.ifpr.irati.ads.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "logoutservlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {

    private Cookie getCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals(name)) {
                    cookie = c;
                    break;
                }
            }
        }

        return cookie;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie token = getCookie(req, "token");

        // A ideia é setar o valor do cookie como null
        if (token != null) {
            Cookie cookie = new Cookie("token", null);
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
        }
        HttpSession session = req.getSession();
        if(session != null)
            session.invalidate();

        resp.sendRedirect("index.jsp");
    }
}
