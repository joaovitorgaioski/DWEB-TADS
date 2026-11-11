package br.edu.ifpr.irati.ads.servlet;

import br.edu.ifpr.irati.ads.model.Produto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "servletproduto", urlPatterns = "/produtos")
public class ServletProduto extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Produto> produtos = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            Produto produto = new Produto("Produto Maneiro " + i);
            produtos.add(produto);
        }

        req.setAttribute("produtos", produtos);

        req.getRequestDispatcher("lista-exercicios/produtos.jsp").forward(req, resp);
    }
}
