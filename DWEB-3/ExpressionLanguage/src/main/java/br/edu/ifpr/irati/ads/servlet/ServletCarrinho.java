package br.edu.ifpr.irati.ads.servlet;

import br.edu.ifpr.irati.ads.model.ItemCarrinho;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "servletcarrinho", urlPatterns = {"/carrinho"})
public class ServletCarrinho extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ItemCarrinho> carrinho = new ArrayList<>();

        carrinho.add(new ItemCarrinho("Arroz", new BigDecimal("25.90"), 2));
        carrinho.add(new ItemCarrinho("Feijão", new BigDecimal("8.50"), 3));
        carrinho.add(new ItemCarrinho("Macarrão", new BigDecimal("5.99"), 4));
        carrinho.add(new ItemCarrinho("Óleo de soja", new BigDecimal("7.49"), 2));
        carrinho.add(new ItemCarrinho("Açúcar", new BigDecimal("4.79"), 1));
        carrinho.add(new ItemCarrinho("Café", new BigDecimal("18.90"), 2));
        carrinho.add(new ItemCarrinho("Leite", new BigDecimal("5.29"), 6));
        carrinho.add(new ItemCarrinho("Pão de forma", new BigDecimal("9.50"), 1));
        carrinho.add(new ItemCarrinho("Manteiga", new BigDecimal("12.99"), 1));
        carrinho.add(new ItemCarrinho("Queijo", new BigDecimal("35.90"), 2));
        carrinho.add(new ItemCarrinho("Presunto", new BigDecimal("24.50"), 1));
        carrinho.add(new ItemCarrinho("Biscoito", new BigDecimal("3.99"), 5));
        carrinho.add(new ItemCarrinho("Chocolate", new BigDecimal("6.49"), 3));
        carrinho.add(new ItemCarrinho("Refrigerante", new BigDecimal("8.99"), 2));
        carrinho.add(new ItemCarrinho("Suco de laranja", new BigDecimal("7.90"), 2));
        carrinho.add(new ItemCarrinho("Água mineral", new BigDecimal("2.50"), 6));
        carrinho.add(new ItemCarrinho("Detergente", new BigDecimal("2.99"), 3));
        carrinho.add(new ItemCarrinho("Sabão em pó", new BigDecimal("16.90"), 1));
        carrinho.add(new ItemCarrinho("Papel higiênico", new BigDecimal("19.99"), 2));
        carrinho.add(new ItemCarrinho("Creme dental", new BigDecimal("4.50"), 2));

        req.setAttribute("carrinho", carrinho);
        req.getRequestDispatcher("lista-exercicios/carrinho.jsp").forward(req, resp);
    }
}
