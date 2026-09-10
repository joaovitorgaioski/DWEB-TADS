package br.edu.ifpr.irati.ads.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

@WebFilter(urlPatterns = {
        "/home.jsp",
        "/relatorios.jsp"
})
public class AuthFilter implements Filter {

    // Recebe os cookies do request
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
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Data e hora: " + new Date().toString());
        System.out.println("IP: " + request.getRemoteHost());

        Cookie cookie = getCookie((HttpServletRequest) request, "token");
        if (cookie != null && cookie.getValue().equals("F1EE133C90")) {
            // chain.doFilter da sequência na requisição, ou seja, permite a passagem
            chain.doFilter(request, response);
        } else {
            // Verificação se já há sessão ativa
            if (((HttpServletRequest) request).getSession().getAttribute("usuarioLogado") != null) {
                chain.doFilter(request, response);
            } else {
                ((HttpServletResponse) response).sendRedirect("login.jsp");
            }
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
