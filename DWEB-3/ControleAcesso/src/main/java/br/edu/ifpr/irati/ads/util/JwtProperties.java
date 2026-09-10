package br.edu.ifpr.irati.ads.util;

import jakarta.servlet.ServletContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class JwtProperties {

    private static Properties properties = null;

    public static void loadProperties(ServletContext servletContext) {
        Properties props = new Properties();

        try {
            FileInputStream file = new FileInputStream(servletContext.getResource("/WEB-INF/jwt.properties").getPath());
            props.load(file);
            properties = props;
        } catch (IOException e) {
            properties.setProperty("jwt_passwd", "my_jwt_passwd");
            properties.setProperty("jwt_default_expiration", "60000");
        }
    }

    public static Properties getProperties() {
        return properties;
    }
}
