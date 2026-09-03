package br.edu.ifpr.irati.ads.util;

import br.edu.ifpr.irati.ads.exception.UrlException;

public class UrlParser {

    private String service;
    private String method;

    public UrlParser(String url) {
        try {
            String[] arrayUrl = url.split("/");

            service = arrayUrl[1];
            method = arrayUrl[2];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new UrlException("URL inválida");
        }
    }

    public String getService() {
        return service;
    }

    public String getMethod() {
        return method;
    }
}
