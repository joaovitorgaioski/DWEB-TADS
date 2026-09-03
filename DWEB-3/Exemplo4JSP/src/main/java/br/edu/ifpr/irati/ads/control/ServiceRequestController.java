package br.edu.ifpr.irati.ads.control;

import br.edu.ifpr.irati.ads.exception.ServiceException;
import br.edu.ifpr.irati.ads.exception.UrlException;
import br.edu.ifpr.irati.ads.service.Service;
import br.edu.ifpr.irati.ads.service.ServiceFactory;
import br.edu.ifpr.irati.ads.util.UrlParser;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(
        name = "servicerequestcontroller",
        urlPatterns = {
                "/usuario/findbyid",
                "/usuario/findall",
                "/usuario/create",
                "/usuario/update",
                "/usuario/delete",
                "/produto/findbyid",
                "/produto/findall",
                "/produto/create",
                "/produto/update",
                "/produto/delete",
        }
)
public class ServiceRequestController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            UrlParser urlParser = new UrlParser(req.getServletPath());
            Service service = ServiceFactory.getService(urlParser.getService());

            switch (urlParser.getMethod()) {
                case "findbyid" -> service.findById(req, resp);
                case "findall" -> service.findAll(req, resp);
                case "create" -> service.create(req, resp);
                case "update" -> service.update(req, resp);
                case "delete" -> service.delete(req, resp);
                default -> throw new ServiceException("Método inválido");
            }
        } catch (ServiceException e) {
            throw new ServletException(e.getMessage());
        } catch (UrlException e) {
            throw new ServletException(e.getMessage());
        }
    }
}
