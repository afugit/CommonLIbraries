/**
 * Data validation such as string format
 *
 * @author Anthony M. Fugit
 * @version 0.1.20171019
 */

package com.vonexus;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validations {

    /**
     * Start logger
     */

    private static final Logger LOGGER = Logger.getLogger(Validations.class.getName());

    /**
     * When not using a public constructor, create a private one:
     */


    /**
     * class variables
     */


    /**
     * Central function to find a match in a given string with a given pattern.
     *
     * @param plaintext string that acts as needle
     * @param regex     expression that acts as haystack
     * @return
     */

    private static boolean isValidTest(String regex, String plaintext) {
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(plaintext);
        return matcher.matches();
    }

    /**
     * Verifies if an e-mail address is valid
     *
     * @param email
     * @return
     */

    public static boolean isValidEmail(String email) {
        String pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        return isValidTest(pattern, email);
    }

    /**
     * Verifies if string is hex color code
     *
     * @param hex
     * @return
     */

    public static boolean isHex(String hex) {
        String pattern = "^[A-Fa-f0-9]+$";
        return isValidTest(pattern, hex);
    }

    /**
     * Verifies if string is hex color code
     *
     * @param hex
     * @return
     */

    public static boolean isHexColorCode(String hex) {
        String pattern = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";
        return isValidTest(pattern, hex);
    }

    /**
     * Verifies if string is a URL
     *
     * @param url
     * @return
     */

    public static boolean isURL(String url) {
        String pattern = "(http(s)?://)?([\\w-]+\\.)+[\\w-]+(/[\\w- ;,./?%&=]*)?";
        return isValidTest(pattern, url);
    }

    /**
     * Verifies if string is an IP address
     *
     * @param ip
     * @return
     */

    public static boolean isIP(String ip) {
        String pattern = "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        return isValidTest(pattern, ip);
    }

    /**
     * Verifies if valid phone number
     *
     * @param phone
     * @return
     */

    public static boolean isValidPhone(String phone) {
        String pattern = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$";
        return isValidTest(pattern, phone);
    }
}