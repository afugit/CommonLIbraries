package com.tests;

import com.vonexus.Utility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UtilityTest {
    private final String to = "afugit@live.com";
    private final String from = "afugit@live.com";
    private final String subject = "Testing sendMail()";
    private final String smtp = "smtp.live.com";
    private final String cc = "afugit@live.com";
    private final String bcc = "afugit@live.com";

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public String getSubject() {
        return subject;
    }

    public String getSmtp() {
        return smtp;
    }

    public String getCc() {
        return cc;
    }

    public String getBcc() {
        return bcc;
    }

    @BeforeEach
    void setUp() {
    }

    @Test
    void echo() {
    }

    @Test
    void getInput() {
        Utility.getInput("What is your name?");
    }

    /* think smtp server is required, localhost didn't work in testing
    @Test
    void sendMail() {
        String to = "afugit@live.com";
        String from = "afugit@live.com";
        String subject = "Testing sendMail()";
        String body = String .format(" --> sendMail(%s, %s, %s, \"Hello World\")", to, from, subject);
        Utility.sendMail(to, from, subject, body);
        System.out.println(body);
    }
    */

    @Test
    void sendMail1() {
        String body = String.format(" --> sendMail(%s, %s, %s, \"Hello World\", %s)", this.getTo(), this.getFrom(), this.getSubject(), this.getSmtp());
        try {
            Utility.sendMail(this.getTo(), this.getFrom(), this.getSubject(), body, this.getSmtp());
        } catch (Exception e) {
            System.out.println(body);
            System.exit(1);
        }
    }

    @Test
    void sendMail2() {

        String body = String.format(" --> sendMail(%s, %s, %s, \"Hello World\", %s, %s, null)", this.getTo(), this.getFrom(), this.getSubject(), this.getSmtp(), this.getCc());
        try {
            Utility.sendMail(this.getTo(), this.getFrom(), this.getSubject(), body, this.getSmtp(), this.getCc(), null);
        } catch (Exception e) {
            System.out.println(body);
            System.exit(1);
        }
    }

    @Test
    void sendMail3() {
        String body = String.format(" --> sendMail(%s, %s, %s, \"Hello World\", %s, null, %s)", this.getTo(), this.getFrom(), this.getSubject(), this.getSmtp(), this.getBcc());
        try {
            Utility.sendMail(this.getTo(), this.getFrom(), this.getSubject(), body, this.getSmtp(), null, this.getBcc());
        } catch (Exception e) {
            System.out.println(body);
            System.exit(1);
        }
    }

    @Test
    void sendMail4() {
        String body = String.format(" --> sendMail(%s, %s, %s, \"Hello World\", %s, %s, %s)", this.getTo(), this.getFrom(), this.getSubject(), this.getSmtp(), this.getCc(), this.getBcc());
        try {
            Utility.sendMail(this.getTo(), this.getFrom(), this.getSubject(), body, this.getSmtp(), this.getCc(), this.getBcc());
        } catch (Exception e) {
            System.out.println(body);
            System.exit(1);
        }
    }
}

