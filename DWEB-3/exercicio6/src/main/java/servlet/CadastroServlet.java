package servlet;

import dao.GenericDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Produto;

import java.io.IOException;

@WebServlet(name = "CadastroServlet", urlPatterns = "/cadastrar")
public class CadastroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String nome = req.getParameter("nome");
            String descricao = req.getParameter("descricao");
            double preco = Double.parseDouble(req.getParameter("preco"));
            int qtdEstoque = Integer.parseInt(req.getParameter("qtdEstoque"));

            Produto produto = new Produto(nome, descricao, preco, qtdEstoque);

            if (!produto.validar())
                throw new Exception("Erro ao validar!");

            GenericDao<Produto> dao = new GenericDao<>(Produto.class);
            dao.salvar(produto);

            resp.sendRedirect("index.html");

        } catch (Exception e) {
            resp.sendRedirect("erro.html");
        }
    }
}