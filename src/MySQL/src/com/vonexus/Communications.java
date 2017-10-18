/**
 * E-mail interface to send/receive e-mail and other forms of communication.
 *
 * @author Anthony M. Fugit
 * @version 0.1.20171018
 */

package com.vonexus;

import com.vonexus.objects.Email;

import java.util.*;
import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.*;
import java.util.logging.*;

public class Communications {
    private static final Logger LOGGER = Logger.getLogger(Communications.class.getName());

    /**
     * When not using a public constructor, create a private one:
     */

	private Communications() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Email system
     *
     * @param email object used to send data.  See /objects/Email.java
     */

    public void Email(Email email) throws MessagingException {
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
                message.addRecipients(RecipientType.BCC, String.valueOf(newInternetAddress(email.getBcc())));
            }
            message.setSubject(email.getSubject());
            message.setText(email.getBody());

            Transport.send(message);
        }
        catch (MessagingException e) {
            LOGGER.log(Level.SEVERE, e.getLocalizedMessage());;
        }
    }

    /**
     * TODO:  Look into whether it is worth the time to upt something like
     *        Facebook or Twitter.  You'll never use it but will be good
     *        experience and probably re-usable in the future for a project.
     */
}

