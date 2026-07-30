package br.edu.ifpr.irati.ads.servlet;

import br.edu.ifpr.irati.ads.model.NovaPessoa;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.io.StringWriter;

@WebServlet(name = "ex6", urlPatterns = {"/exemplo6"})
public class Exemplo6Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(NovaPessoa.class);
            StringWriter sw = new StringWriter();

            jaxbContext.createMarshaller().marshal(new NovaPessoa("João", "Vitor"), sw);

            resp.setContentType("text/xml");
            resp.getWriter().write(sw.toString());
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
