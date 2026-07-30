package br.edu.ifpr.irati.ads.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ex3", urlPatterns = {"/exemplo3"})
public class Exemplo3Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("mail");
        String mensagem = req.getParameter("msg");

        System.out.println(email + "\t" + mensagem);

        PrintWriter pw = resp.getWriter();
        pw.println("<html>");

        pw.println("<head>");
        pw.println("<meta charset=\"UTF-8\">");
        pw.println("<title>Confirmação</title>");
        pw.println("</head>");

        pw.println("<body>");
        pw.println("<p>Olá, recebemos a sua mensagem:</p>");
        pw.println("<p>" + mensagem + "</p>");
        pw.println("<p>Logo entraremos em contato via " + email + "</p>");
        pw.println("</body>");

        pw.println("</html>");
    }
}
