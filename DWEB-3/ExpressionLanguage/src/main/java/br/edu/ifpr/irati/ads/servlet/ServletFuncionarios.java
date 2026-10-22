package br.edu.ifpr.irati.ads.servlet;

import br.edu.ifpr.irati.ads.model.Departamento;
import br.edu.ifpr.irati.ads.model.Funcionario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "servletfuncionaiors", urlPatterns = {"/funcionarios"})
public class ServletFuncionarios extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Departamento d1 = new Departamento("Recursos Humanos");
        Departamento d2 = new Departamento("Financeiro");
        Departamento d3 = new Departamento("Tecnologia");
        Departamento d4 = new Departamento("Marketing", 102);
        Departamento d5 = new Departamento("Vendas", 105);

        List<Funcionario> funcionarios = new ArrayList<>(20);

        funcionarios.add(new Funcionario("Ana Silva", new BigDecimal("5500.00"), d1));
        funcionarios.add(new Funcionario("Bruno Santos", new BigDecimal("3200.00"), d2));
        funcionarios.add(new Funcionario("Carla Oliveira", new BigDecimal("4100.00"), d3));
        funcionarios.add(new Funcionario("Daniel Souza", new BigDecimal("2800.00"), d4));
        funcionarios.add(new Funcionario("Eduarda Lima", new BigDecimal("5000.00"), d5));
        funcionarios.add(new Funcionario("Felipe Costa", new BigDecimal("3500.00"), d1));
        funcionarios.add(new Funcionario("Gabriela Alves", new BigDecimal("5200.00"), d2));
        funcionarios.add(new Funcionario("Henrique Pereira", new BigDecimal("3100.00"), d3));
        funcionarios.add(new Funcionario("Isabela Rodrigues", new BigDecimal("4700.00"), d4));
        funcionarios.add(new Funcionario("Joao Martins", new BigDecimal("2900.00"), d5));
        funcionarios.add(new Funcionario("Karen Ferreira", new BigDecimal("3800.00"), d1));
        funcionarios.add(new Funcionario("Lucas Ribeiro", new BigDecimal("5300.00"), d2));
        funcionarios.add(new Funcionario("Mariana Gomes", new BigDecimal("3400.00"), d3));
        funcionarios.add(new Funcionario("Nicolas Barbosa", new BigDecimal("7500.00"), d4));
        funcionarios.add(new Funcionario("Olivia Cardoso", new BigDecimal("2600.00"), d5));
        funcionarios.add(new Funcionario("Pedro Almeida", new BigDecimal("3900.00"), d1));
        funcionarios.add(new Funcionario("Rafaela Nunes", new BigDecimal("4800.00"), d2));
        funcionarios.add(new Funcionario("Samuel Moreira", new BigDecimal("3000.00"), d3));
        funcionarios.add(new Funcionario("Tatiane Mendes", new BigDecimal("5600.00"), d4));
        funcionarios.add(new Funcionario("Vinicius Carvalho", new BigDecimal("6600.00"), d5));

        req.setAttribute("funcionarios", funcionarios);
        req.getRequestDispatcher("lista-exercicios/funcionarios.jsp").forward(req, resp);
    }
}
