package com.tests;

import com.vonexus.objects.EmailObj;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmailObjTest {

    EmailObj emailPackage;

    @BeforeEach
    void setUp() {
        this.emailPackage = new EmailObj("afugit@live.com", "afugit@live.com", "Test Email", "Hello World", "localhost");
    }

    @Test
    void getTo() {
        System.out.println(" --> getTo(): " + emailPackage.getTo());
    }

    @Test
    void getFrom() {
        System.out.println(" --> getFrom(): " + emailPackage.getFrom());
    }

    @Test
    void getSubject() {
        System.out.println(" --> getSubject(): " + emailPackage.getSubject());
    }

    @Test
    void getCc() {
        System.out.println(" --> getCc(): " + emailPackage.getCc());
    }

    @Test
    void getBcc() {
        System.out.println(" --> getBcc(): " + emailPackage.getBcc());
    }

    @Test
    void getSmtp() {
        System.out.println(" --> getSmtp(): " + emailPackage.getSmtp());
    }

    @Test
    void getBody() {
        System.out.println(" --> getBody(): " + emailPackage.getBody());
    }

}