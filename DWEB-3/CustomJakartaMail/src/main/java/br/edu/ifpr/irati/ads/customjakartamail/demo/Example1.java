package br.edu.ifpr.irati.ads.customjakartamail.demo;

import br.edu.ifpr.irati.ads.customjakartamail.mail.Email;
import br.edu.ifpr.irati.ads.customjakartamail.exception.SendMailException;
import br.edu.ifpr.irati.ads.customjakartamail.mail.SendMail;

import java.io.IOException;

public class Example1 {
    
    /**
     * Sending an email to a single recipient without
     * including attachments in the message body.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        
        try {
            String configPath = "src/main/java/br/edu/ifpr/irati/ads/customjakartamail/demo/mail.properties";
            Email email = new Email(
                    "valter.junior@ifpr.edu.br",
                    "Complaint – Certificate Not Received",
                    "Dear Sir/Madam,\n\nI have not yet received my certificate.\n Best regards");
            SendMail.sendMail(email, configPath);
        } catch (SendMailException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
