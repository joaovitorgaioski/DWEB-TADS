package br.edu.ifpr.irati.ads.customjakartamail.mail;

import br.edu.ifpr.irati.ads.customjakartamail.exception.SendMailException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.Message;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.Authenticator;
import jakarta.mail.BodyPart;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMultipart;

public class SendMail {

    private static final Properties properties = new Properties();

    private static void send(Email email, String filePath) throws SendMailException, IOException {

        FileInputStream file = new FileInputStream(filePath);
        properties.load(file);
        System.out.println(properties.toString());

        boolean sucess = false;

        String mailSMTPServer = properties.getProperty("mail.smtp.host");

        SimpleAuth auth = null;
        auth = new SimpleAuth(
                properties.getProperty("mail.smtp.user"),
                properties.getProperty("passwd")
        );

        Session session = Session.getInstance(properties, auth);
        session.setDebug(true);

        Message msg = new MimeMessage(session);

        InternetAddress[] targets = new InternetAddress[email.getTargets().size()];
        int i = 0;
        for (String target : email.getTargets()) {
            try {
                targets[i++] = new InternetAddress(target.trim().toLowerCase());
            } catch (AddressException ex) {
                throw new SendMailException("Invalid address!");
            }
        }

        try {

            msg.setRecipients(Message.RecipientType.TO, targets);

            msg.setFrom(new InternetAddress(properties.getProperty("mail.smtp.user")));

            msg.setSubject(email.getSubjet());

            BodyPart messageBodyPart = new MimeBodyPart();

            messageBodyPart.setContent(email.getContent(), "text/html; charset=utf-8");

            Multipart multipart = new MimeMultipart();

            multipart.addBodyPart(messageBodyPart);

            for (File attachFile : email.getAttachments()) {
                messageBodyPart = new MimeBodyPart();
                DataSource source = new FileDataSource(attachFile);
                messageBodyPart.setDataHandler(new DataHandler(source));
                messageBodyPart.setFileName(source.getName());
                multipart.addBodyPart(messageBodyPart);
            }

            msg.setContent(multipart);

        } catch (Exception e) {
            System.out.println(">> Error: Incomplete Message");
        }

        Transport tr;
        try {
            tr = session.getTransport("smtp");
            tr.connect(
                    mailSMTPServer,
                    properties.getProperty("mail.smtp.user"),
                    properties.getProperty("passwd"));
            msg.saveChanges();
            tr.sendMessage(msg, msg.getAllRecipients());
            tr.close();
            sucess = true;
        } catch (Exception e) {
            System.out.println(">> Error: Sending message");
        }

        if (!sucess) {
            throw new SendMailException("Failed to send the email");
        }
    }

    static class SimpleAuth extends Authenticator {

        public String username = null;
        public String password = null;

        public SimpleAuth(String user, String pwd) {
            username = user;
            password = pwd;
        }

        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
        }
    }

    public static void sendMail(Email email, String configPath) throws SendMailException, IOException {
        send(email, configPath);
    }
}
