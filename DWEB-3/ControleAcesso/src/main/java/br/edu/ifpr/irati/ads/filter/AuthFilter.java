package br.edu.ifpr.irati.ads.filter;

import br.edu.ifpr.irati.ads.dao.UsuarioDao;
import br.edu.ifpr.irati.ads.model.Usuario;
import br.edu.ifpr.irati.ads.util.JwtProperties;
import br.edu.ifpr.irati.ads.util.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@WebFilter(urlPatterns = {
        "/home.jsp",
        "/relatorios.jsp"
})
public class AuthFilter implements Filter {

    private Usuario validarToken(Cookie token, Properties props) {
        Usuario usuario = null;
        if (token == null)
            return null;
        String jwtToken = token.getValue();
        String jwtPasswd = props.getProperty("jwt_passwd");

        try {
            Claims claims = JwtUtils.validateToken(jwtToken, jwtPasswd);
            String email = claims.getSubject();
            UsuarioDao usuarioDao = new UsuarioDao();
            usuario = usuarioDao.buscarPorEmail(email);

            if (!usuario.getToken().equals(jwtToken))
                return null;
        } catch (Exception e) {
            return null;
        }

        return usuario;
    }

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
        JwtProperties.loadProperties(((HttpServletRequest) request).getServletContext());
        Properties props = JwtProperties.getProperties();
        Usuario usuario = validarToken(cookie, props);

        if (cookie != null && usuario != null) {
            // chain.doFilter da sequência na requisição, ou seja, permite a passagem
            ((HttpServletRequest) request).getSession().setAttribute("usuarioLogado", usuario);
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
