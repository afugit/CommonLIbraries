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

import java.util.Scanner;
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
}