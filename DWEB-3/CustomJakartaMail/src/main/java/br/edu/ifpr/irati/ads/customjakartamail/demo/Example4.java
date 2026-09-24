package br.edu.ifpr.irati.ads.customjakartamail.demo;

import br.edu.ifpr.irati.ads.customjakartamail.mail.Email;
import br.edu.ifpr.irati.ads.customjakartamail.exception.SendMailException;
import br.edu.ifpr.irati.ads.customjakartamail.mail.SendMail;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFileChooser;

public class Example4 {

    /**
     * Sending an email to multiple recipients and including one or more
     * files in the body of the message.
     * 
     * @param args 
     */
    public static void main(String[] args) {

        try {

            List<String> targets = new ArrayList<>();
            targets.add("valter.junior@ifpr.edu.br");
            targets.add("algumemail@valterestevam.com.br");

            List<File> attachments = new ArrayList<>();
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setMultiSelectionEnabled(true);            
            int ret = fileChooser.showOpenDialog(null);
            if (ret == JFileChooser.APPROVE_OPTION) {
                File[] files = fileChooser.getSelectedFiles();
                attachments.addAll(Arrays.asList(files));
            } else {
                System.exit(1);
            }

            String configPath = "src/main/java/br/edu/ifpr/irati/ads/customjakartamail/demo/mail.properties";
            Email email = new Email(
                    targets,
                    "Complaint – Certificate Not Received",
                    "Dear Sir/Madam,\n\nI have not yet received my certificate.\n Best regards",
                    attachments);
            SendMail.sendMail(email, configPath);
        } catch (SendMailException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
