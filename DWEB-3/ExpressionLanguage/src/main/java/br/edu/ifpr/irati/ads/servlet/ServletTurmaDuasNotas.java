package br.edu.ifpr.irati.ads.servlet;

import br.edu.ifpr.irati.ads.model.AlunoDuasNotas;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "servletturmaduasnotas", urlPatterns = "/turmaduasnotas")
public class ServletTurmaDuasNotas extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<AlunoDuasNotas> alunos = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            AlunoDuasNotas aluno = new AlunoDuasNotas("Aluno " + i);
            alunos.add(aluno);
        }

        req.setAttribute("alunos", alunos);

        req.getRequestDispatcher("lista-exercicios/turma-duas-notas.jsp").forward(req, resp);
    }
}
