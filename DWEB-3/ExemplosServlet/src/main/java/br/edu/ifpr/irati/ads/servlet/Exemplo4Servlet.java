package br.edu.ifpr.irati.ads.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ex4", urlPatterns = {"/exemplo4"})
public class Exemplo4Servlet extends HttpServlet {
    private double z;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int x = 1, y = 0;
        int z = x / y;
    }
}
