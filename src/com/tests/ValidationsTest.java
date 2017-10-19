package com.tests;

import com.vonexus.Validations;
import org.junit.jupiter.api.Test;

class ValidationsTest {
    final String emailAddress = "afugit@live.com";
    final String badEmailAddress = "wasl!8a0s.";

    final String hex = "05abf2e";
    final String badHex = "n280sr";

    final String url = "https://www.google.com/";
    final String badUrl = "ldap://server.com:4040";

    final String ip = "192.168.0.1";
    final String badIp = "22.4280.103.802";

    final String phone = "502-555-1000";
    final String badPhone = "520832010u102";

    final String hexColor = "#abc123";
    final String badHexColor = "#samson";

    @Test
    void isValidEmail() {
        System.out.printf(" --> isValidEmail(%s): %b%n", emailAddress, Validations.isValidEmail(emailAddress));
        System.out.printf(" --> isValidEmail(%s): %b%n", badEmailAddress, Validations.isValidEmail(badEmailAddress));
    }

    @Test
    void isHex() {
        System.out.printf(" --> isHex(%s): %b%n", hex, Validations.isHex(hex));
        System.out.printf(" --> isHex(%s): %b%n", badHex, Validations.isHex(badHex));
    }

    @Test
    void isHexColorCode() {
        System.out.printf(" --> isHexColorCode(%s): %b%n", hexColor, Validations.isHexColorCode(hexColor));
        System.out.printf(" --> isHexColorCode(%s): %b%n", badHexColor, Validations.isHexColorCode(badHexColor));
    }

    @Test
    void isURL() {
        System.out.printf(" --> isURL(%s): %b%n", url, Validations.isURL(url));
        System.out.printf(" --> isURL(%s): %b%n", badUrl, Validations.isURL(badUrl));
    }

    @Test
    void isIP() {
        System.out.printf(" --> isIP(%s): %b%n", ip, Validations.isIP(ip));
        System.out.printf(" --> isIP(%s): %b%n", badIp, Validations.isIP(badIp));
    }

    @Test
    void isValidPhone() {
        System.out.printf(" --> isValidPhone(%s): %b%n", phone, Validations.isValidPhone(phone));
        System.out.printf(" --> isValidPhone(%s): %b%n", badPhone, Validations.isValidPhone(badPhone));
    }

}