/**
 * E-mail object used by Communications
 *
 * @author Anthony M. Fugit
 * @version 0.1.20171018
 */

package com.vonexus.objects;

public class Email {

    /**
     * class variables
     */

    private String to;
    private String from;
    private String subject;
    private String cc = null;
    private String bcc = null;
    private String smtp = "localhost";
    private String body = "";

    public Email(String to, String from, String subject, String body, String cc, String bcc, String smtp) {
        this.setTo(to);
        this.setFrom(from);
        this.setSubject(subject);
        this.setBody(body);
        this.setCc(cc);
        this.setBcc(bcc);
        this.setSmtp(smtp);
    }

    /**
     * accessors and mutators
     */

    public String getTo() {
        return to;
    }
    private void setTo(String to) {
        this.to = to;
    }
    public String getFrom() {
        return from;
    }
    private void setFrom(String from) {
        this.from = from;
    }
    public String getSubject() {
        return subject;
    }
    private void setSubject(String subject) {
        this.subject = subject;
    }
    public String getCc() {
        return cc;
    }
    private void setCc(String cc) {
        this.cc = cc;
    }
    public String getBcc() {
        return bcc;
    }
    private void setBcc(String bcc) {
        this.bcc = bcc;
    }
    public String getSmtp() {
        return smtp;
    }
    private void setSmtp(String smtp) {
        this.smtp = smtp;
    }
    public String getBody() {
        return body;
    }
    private void setBody(String body) {
        this.body = body;
    }
}
