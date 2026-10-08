package br.edu.ifpr.irati.ads.dao;

import jakarta.servlet.ServletContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class DBProperties {

    private static Properties properties = null;
    private static final Logger logger = Logger.getLogger(DBProperties.class.getName());

    static void loadProperties(ServletContext sc) {
        Properties props = new Properties();
        try {
            FileInputStream file = new FileInputStream(sc.getResource("/WEB-INF/db.properties").getPath());
            props.load(file);
            properties = props;
        } catch (IOException ioe) {
            logger.severe("ERROR Erro ao ler o arquivo properties: " + ioe.getMessage());
        }
    }

    public static Properties getProperties() {
        return properties;
    }
}