package br.edu.ifpr.irati.ads.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(name = "servletcolecoes", urlPatterns = "/servletelcolecoes")
public class ServletELColecoes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<String> frutas = new ArrayList<>();
        frutas.add("Banana");
        frutas.add("Uva");
        frutas.add("Pera");
        frutas.add("Maça");

        String[] carros = {"BMW", "Audi", "Alfa Romeo", "Ferrari"};

        HashMap<String, String> estados = new HashMap<>();
        estados.put("PR", "Paraná");
        estados.put("SC", "Santa Catarina");
        estados.put("RS", "Rio Grande do Sul");
        estados.put("SP", "São Paulo");
        estados.put("RJ", "Rio de Janeiro");
        estados.put("MG", "Minas Gerais");

        HttpSession session = req.getSession();
        session.setAttribute("frutas", frutas);
        session.setAttribute("carros", carros);
        session.setAttribute("estados", estados);

        RequestDispatcher dispatcher = req.getRequestDispatcher("exemploelcolecoes.jsp");
        dispatcher.forward(req, resp);
    }
}
