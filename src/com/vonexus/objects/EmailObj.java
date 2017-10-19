/**
 * E-mail object used by Communications
 *
 * @author Anthony M. Fugit
 * @version 0.1.20171018
 */

package com.vonexus.objects;

public class EmailObj {

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

    /**
     * Creates new e-mail object that would contain everything required to send e-mail.
     *
     * @param to
     * @param from
     * @param subject
     * @param body
     * @param smtp
     * @param cc
     * @param bcc
     */

    public EmailObj(String to, String from, String subject, String body) {
        this(to, from, subject, body, "localhost");
    }

    public EmailObj(String to, String from, String subject, String body, String smtp) {
        this(to, from, subject, body, smtp, null, null);
    }

    public EmailObj(String to, String from, String subject, String body, String smtp, String cc, String bcc) {
        this.setTo(to);
        this.setFrom(from);
        this.setSubject(subject);
        this.setBody(body);
        this.setSmtp(smtp);
        this.setCc(cc);
        this.setBcc(bcc);
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
