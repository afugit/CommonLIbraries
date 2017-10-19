/**
 * E-mail interface to send/receive e-mail and other forms of communication.
 *
 * @author Anthony M. Fugit
 * @version 0.1.20171018
 */

package com.vonexus;

import com.vonexus.objects.EmailObj;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Communications {

    /**
     * Start logger
     */

    private static final Logger LOGGER = Logger.getLogger(Communications.class.getName());

    /**
     * When not using a public constructor, create a private one:
     */

    private Communications() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Overloaded method to send mails with optional SMTP, CC, and BCC.
     *
     * @param to      e-mail recipient
     * @param from    e-mail sender
     * @param subject e-mail subject
     * @param body    e-mail body
     * @param smtp    SMTP server if available
     * @param cc      carbon copy
     * @param bcc     blind carbon copy
     */
    public void sendMail(String to, String from, String subject, String body) {
        sendMail(to, from, subject, body, "localhost");
    }

    public void sendMail(String to, String from, String subject, String body, String smtp) {
        sendMail(to, from, subject, body, smtp, null, null);
    }

    public void sendMail(String to, String from, String subject, String body, String smtp, String cc, String bcc) {
        EmailObj eObj = new EmailObj();
        eObj.config(to, from, subject, body, smtp, cc, bcc); // research why this couldn't have been a constructor.  had several issues and .config() was the workaround
        try {
            sendMail(eObj);
        } catch (MessagingException e) {
            LOGGER.log(Level.WARNING, e.getLocalizedMessage());
        }
    }

    /**
     * Sending e-mails from SMTP server (default localhost)
     *
     * @param email object used to send data.  See /objects/EmailObj.java
     */

    private void sendMail(EmailObj email) throws MessagingException {
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", email.getSmtp());

        // get default session object
        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email.getFrom()));
            message.addRecipient(RecipientType.TO, new InternetAddress(email.getTo()));
            if (!email.getCc().isEmpty()) {
                message.addRecipients(RecipientType.CC, String.valueOf(new InternetAddress(email.getCc())));
            }
            if (!email.getBcc().isEmpty()) {
                message.addRecipients(RecipientType.BCC, String.valueOf(new InternetAddress(email.getBcc())));
            }
            message.setSubject(email.getSubject());
            message.setText(email.getBody());

            Transport.send(message);
        } catch (MessagingException e) {
            LOGGER.log(Level.SEVERE, e.getLocalizedMessage());
        }
    }

    /**
     * TODO:  Look into whether it is worth the time to upt something like
     *        Facebook or Twitter.  You'll never use it but will be good
     *        experience and probably re-usable in the future for a project.
     */
}

