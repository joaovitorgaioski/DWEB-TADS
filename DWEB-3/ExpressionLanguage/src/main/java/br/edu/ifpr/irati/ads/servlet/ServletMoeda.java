package br.edu.ifpr.irati.ads.servlet;

import br.edu.ifpr.irati.ads.model.Moeda;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "servletmoeda", urlPatterns = "/converter")
public class ServletMoeda extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Moeda dolar = new Moeda("Dólar", 5.05);
        Moeda libra = new Moeda("Libra", 5.60);
        Moeda euro = new Moeda("Euro", 6.67);

        List<Moeda> moedas = Arrays.asList(new Moeda[]{dolar, libra, euro});

        req.setAttribute("moedas", moedas);

        req.getRequestDispatcher("lista-exercicios/moedas.jsp").forward(req, resp);
    }
}
