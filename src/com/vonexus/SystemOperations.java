/**
 * File and directory operations to make Main code a lot cleaner.  Contains
 * FIle IO functions to help prevent building long strings.
 *
 * @author Anthony M. Fugit
 * @version 0.1.20171018
 */

package com.vonexus;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * TODO:  FIll me out.
 */
public class SystemOperations {
    /**
     * Start logger
     */

    private static final Logger LOGGER = Logger.getLogger(SystemOperations.class.getName());

    /**
     * When not using a public constructor, create a private one:
     */

    private SystemOperations() {
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