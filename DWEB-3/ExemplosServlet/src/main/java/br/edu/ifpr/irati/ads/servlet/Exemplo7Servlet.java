package br.edu.ifpr.irati.ads.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(name="ex7", urlPatterns = {"/exemplo7"})
public class Exemplo7Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            File file = new File("C:\\Users\\Aluno\\Documents\\Servlets.pdf");
            if (file.exists()){
                resp.setContentType("application/pdf");
                resp.setHeader("Content-Disposition","attachment; filename=\"servlet.pdf\"");
                resp.setDateHeader("Expires", 0);
                FileInputStream inputStream = null;
                try{
                    inputStream = new FileInputStream(file);
                    byte[] buffer = new byte[1024];
                    int bytesRead = 0;
                    do {
                        bytesRead = inputStream.read(buffer, 0, buffer.length);
                        resp.getOutputStream().write(buffer, 0, bytesRead);
                    }while (bytesRead == buffer.length);
                    resp.setContentLength(buffer.length);
                    resp.getOutputStream().flush();
                }finally {
                    if (inputStream != null){
                        inputStream.close();
                    }
                }
            }else{
                System.out.println("Arquivo inexistente.");
            }
        }catch (IOException ioe){
            System.out.println("Errp: "+ioe.getMessage());
        }
    }
}
