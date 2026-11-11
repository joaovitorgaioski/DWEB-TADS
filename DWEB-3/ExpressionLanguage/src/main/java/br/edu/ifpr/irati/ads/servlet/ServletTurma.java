package br.edu.ifpr.irati.ads.servlet;

import br.edu.ifpr.irati.ads.model.Aluno;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet(name = "servletturma", urlPatterns = "/turma")
public class ServletTurma extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Aluno> alunos = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i <= 20; i++) {
            Aluno aluno = new Aluno("Aluno " + i, random.nextDouble(40, 100));
            alunos.add(aluno);
        }

        req.setAttribute("alunos", alunos);

        req.getRequestDispatcher("lista-exercicios/turma.jsp").forward(req, resp);
    }
}
