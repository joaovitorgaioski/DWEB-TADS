package br.edu.ifpr.irati.ads.customjakartamail.demo;

import br.edu.ifpr.irati.ads.customjakartamail.mail.Email;
import br.edu.ifpr.irati.ads.customjakartamail.exception.SendMailException;
import br.edu.ifpr.irati.ads.customjakartamail.mail.SendMail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Example2 {

    /**
     * Sending an email to two recipients including two attachments in the message body
     * 
     * @param args 
     */
    public static void main(String[] args) {

        try {
            
            List<String> targets = new ArrayList<>();
            targets.add("valter.junior@ifpr.edu.br");
            targets.add("algumemail@valterestevam.com.br");
            
            String configPath = "src/main/java/br/edu/ifpr/irati/ads/customjakartamail/demo/mail.properties";
            Email email = new Email(
                    targets,
                    "Complaint – Certificate Not Received",
                    "Dear Sir/Madam,\n\nI have not yet received my certificate.\n Best regards");
            SendMail.sendMail(email, configPath);
        } catch (SendMailException | IOException ex) {
            System.out.println(ex.getMessage());
        }      
    }

}
