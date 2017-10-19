/**
 * Miscellaneous utilities that are commonly used.  Though shortcuts, these
 * methods should never be used in writing a formal class.  Every class should
 * be independant of one another, so no relying on this.  SHould only be
 * utilized in main().
 *
 * @author Anthony M. Fugit
 * @version 0.1.20171019
 */

package com.vonexus;

import com.vonexus.objects.EmailObj;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utility {
    /**
     * Start logger
     */

    private static final Logger LOGGER = Logger.getLogger(Utility.class.getName());

    /**
     * When not using a public constructor, create a private one:
     */

    private Utility() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Get user input on CLI
     *
     * @param prompt String to display to user
     * @return user response
     */

    public String getInput(String prompt) {
        Scanner reader = new Scanner(System.in);
        System.out.printf(prompt);
        return reader.next();
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
            Properties properties = System.getProperties();
            properties.setProperty("mail.smtp.host", eObj.getSmtp());

            // get default session object
            Session session = Session.getDefaultInstance(properties);

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(eObj.getFrom()));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(eObj.getTo()));
            if (!eObj.getCc().isEmpty()) {
                message.addRecipients(Message.RecipientType.CC, String.valueOf(new InternetAddress(eObj.getCc())));
            }
            if (!eObj.getBcc().isEmpty()) {
                message.addRecipients(Message.RecipientType.BCC, String.valueOf(new InternetAddress(eObj.getBcc())));
            }
            message.setSubject(eObj.getSubject());
            message.setText(eObj.getBody());

            Transport.send(message);
        } catch (MessagingException e) {
            LOGGER.log(Level.WARNING, e.getLocalizedMessage());
        }
    }
}