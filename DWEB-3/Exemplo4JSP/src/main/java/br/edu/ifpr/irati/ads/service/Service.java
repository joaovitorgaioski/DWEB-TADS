package br.edu.ifpr.irati.ads.service;

import br.edu.ifpr.irati.ads.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface Service {

    public void findById(HttpServletRequest req, HttpServletResponse resp) throws ServiceException, IOException;

    public void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServiceException, IOException;

    public void create(HttpServletRequest req, HttpServletResponse resp) throws ServiceException, IOException;

    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServiceException, IOException;

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServiceException, IOException;
}
