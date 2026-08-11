package servlet;

import dao.GenericDao;
import dao.HibernateUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Produto;
import org.hibernate.Session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ListarServlet", urlPatterns = "/listar")
public class ListarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        try (Session session = HibernateUtil.getSessionFactory().openSession();
             PrintWriter res = resp.getWriter()) {

            GenericDao<Produto> dao = new GenericDao<>(Produto.class);
            List<Produto> produtos = dao.buscarTodos(session);

            res.println("<!DOCTYPE html>");
            res.println("<html lang='pt-br'>");
            res.println("<head><meta charset='UTF-8'><title>Lista de Produtos</title></head>");
            res.println("<body>");
            res.println("<h1>Produtos Cadastrados</h1>");

            res.println("<table border='1'>");
            res.println("<tr>");
            res.println("<th>ID</th>");
            res.println("<th>Nome</th>");
            res.println("<th>Descrição</th>");
            res.println("<th>Preço</th>");
            res.println("<th>Quantidade em Estoque</th>");
            res.println("</tr>");

            for (Produto p : produtos) {
                res.println("<tr>");
                res.println("<td>" + p.getId() + "</td>");
                res.println("<td>" + p.getNome() + "</td>");
                res.println("<td>" + p.getDescricao() + "</td>");
                res.println("<td>R$ " + String.format("%.2f", p.getPreco()) + "</td>");
                res.println("<td>" + p.getQuantidadeEstoque() + "</td>");
                res.println("</tr>");
            }

            res.println("</table>");
            res.println("<br><a href='index.html'>Voltar para o início</a>");
            res.println("</body>");
            res.println("</html>");

        } catch (Exception e) {
            resp.sendRedirect("erro.html");
        }
    }
}