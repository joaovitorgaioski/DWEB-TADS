package br.edu.ifpr.irati.ads.dao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(name = "HibernateLoadServlet", loadOnStartup = 0, urlPatterns = "/hibernateloadservlet")
public class HibernateStarterServlet extends HttpServlet {


    @Override
    public void init() throws ServletException {
        super.init();
        /*
        Carrega as properties de conexão com o banco de dados
        Força o load do Hibernate de modo que quando for requisitado em outro servlet a resposta seja imediata.
         */
        DBProperties.loadProperties(this.getServletContext());
        HibernateUtil.getSessionFactory().openSession().close();
    }
}
