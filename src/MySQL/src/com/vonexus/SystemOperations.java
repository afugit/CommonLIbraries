/**
 * File and directory operations to make Main code a lot cleaner.  Contains
 * FIle IO functions to help prevent building long strings.
 *
 * @author Anthony M. Fugit
 * @version 0.1.20171018
 */

package com.vonexus;

import java.util.Scanner;

/**
 * TODO:  FIll me out.
 */
public class SystemOperations {
    public String getInput() {
        Scanner reader = new Scanner(System.in);
        System.out.printf("Enter something: ");
        return reader.next();
    }

    public void print(String printme) {
        System.out.println(printme);
    }

    public void echo(String echome) {

    }
}