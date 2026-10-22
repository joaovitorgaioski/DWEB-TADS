package br.edu.ifpr.irati.ads.servlet;

import br.edu.ifpr.irati.ads.model.Livro;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "servletlivros", urlPatterns = {"/livros"})
public class ServletLivro extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Livro> livros = new ArrayList<>();

        livros.add(new Livro("A Culpa é das Estrelas", "John Green", 2012, true));
        livros.add(new Livro("O Retrato de Dorian Gray", "Oscar Wilde", 1890, false));
        livros.add(new Livro("A Garota do Lago", "Charlie Donlea", 2016, false));
        livros.add(new Livro("É Assim que Acaba", "Colleen Hoover", 2016, true));
        livros.add(new Livro("A Biblioteca da Meia-Noite", "Matt Haig", 2020, true));
        livros.add(new Livro("Torto Arado", "Itamar Vieira Junior", 2019, false));
        livros.add(new Livro("O Homem de Giz", "C. J. Tudor", 2018, true));
        livros.add(new Livro("Cidade de Deus", "Paulo Lins", 1997, true));
        livros.add(new Livro("O Morro dos Ventos Uivantes", "Emily Brontë", 1847, true));
        livros.add(new Livro("Crime e Castigo", "Fiódor Dostoiévski", 1866, false));
        livros.add(new Livro("Jogos Vorazes", "Suzanne Collins", 2008, true));
        livros.add(new Livro("Os Miseráveis", "Victor Hugo", 1862, true));
        livros.add(new Livro("Percy Jackson e o Ladrão de Raios", "Rick Riordan", 2005, true));
        livros.add(new Livro("A Paciente Silenciosa", "Alex Michaelides", 2019, false));
        livros.add(new Livro("Extraordinário", "R. J. Palacio", 2012, true));
        livros.add(new Livro("O Código Da Vinci", "Dan Brown", 2003, true));
        livros.add(new Livro("A Sutil Arte de Ligar o F*da-se", "Mark Manson", 2016, false));
        livros.add(new Livro("Verity", "Colleen Hoover", 2018, true));
        livros.add(new Livro("A Metamorfose", "Franz Kafka", 1915, true));
        livros.add(new Livro("A Máquina do Tempo", "H. G. Wells", 1895, true));

        req.setAttribute("livros", livros);
        req.getRequestDispatcher("lista-exercicios/livros.jsp").forward(req, resp);
    }
}
