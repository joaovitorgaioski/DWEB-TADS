package br.edu.ifpr.irati.ads.customjakartamail.mail;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Email {

    private List<String> targets;
    
    private String subjet;
    
    private String content;
    
    private List<File> attachments;

    public Email(String target, String subjet, String content) {
        this.targets = new ArrayList<>();
        this.targets.add(target);
        this.subjet = subjet;
        this.content = plainTextToHTML(content);
        this.attachments = new ArrayList<>();
    }
    
    public Email(String target, String subjet, String content, List<File> attachments) {
        this.targets = new ArrayList<>();
        this.targets.add(target);
        this.subjet = subjet;
        this.content = plainTextToHTML(content);
        this.attachments = attachments;
    }

    public Email(List<String> targets, String subjet, String content) {
        this.targets = targets;
        this.subjet = subjet;
        this.content = plainTextToHTML(content);
        this.attachments = new ArrayList<>();
    }
    
    public Email(List<String> targets, String subjet, String content, List<File> attachments) {
        this.targets = targets;
        this.subjet = subjet;
        this.content = plainTextToHTML(content);
        this.attachments = attachments;
    }

    public String plainTextToHTML(String text) {

        StringBuilder sb = new StringBuilder();
        if (text.contains("\n")) {
            String[] texts = text.split("\n");
            for (String s : texts) {
                sb.append("<p>");
                sb.append(s);
                sb.append("</p>");
            }
        } else {
            sb.append("<p>");
            sb.append(text);
            sb.append("</p>");
        }

        String msg
                = "<html>"
                + "<head>"
                + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">"
                + "</head>"
                + "<body>"
                + sb.toString()
                + "</body>"
                + "</html>";
        return msg;
    }

    public List<String> getTargets() {
        return targets;
    }

    public void setTargets(List<String> targets) {
        this.targets = targets;
    }

    public String getSubjet() {
        return subjet;
    }

    public void setSubjet(String subjet) {
        this.subjet = subjet;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<File> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<File> attachments) {
        this.attachments = attachments;
    }
}
