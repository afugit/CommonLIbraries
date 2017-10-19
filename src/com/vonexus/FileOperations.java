/**
 * File and directory operations to make Main code a lot cleaner.  Contains
 * FIle IO functions to help prevent building long strings.
 *
 * @author Anthony M. Fugit
 * @version 0.1.20171018
 */

package com.vonexus;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Operations that interact with the file system.  Opening and reading files,
 * making duplicate copies of files or folders, etc.
 */

public class FileOperations {

    /**
     * Start logger
     */

    private static final Logger LOGGER = Logger.getLogger(FileOperations.class.getName());

    /**
     * When not using a public constructor, create a private one:
     */

    private FileOperations() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Overloaded method allowing user to specify a filter
     *
     * @param source      source directory
     * @param destination destination directory
     * @throws IOException
     */

    private static void copyDirectory(File source, File destination) throws IOException {
        copyDirectory(source, destination, null);
    }

    private static void copyDirectory(File source, File destination, FileFilter filter) throws IOException {
        File nextDirectory = new File(destination, source.getName());
        // create the directory if necessary...
        if (!nextDirectory.exists() && !nextDirectory.mkdirs()) {
            Object[] filler = {nextDirectory.getAbsolutePath()};
            String message = "Dir Copy Failed";
            throw new IOException(message);
        }
        File[] files = source.listFiles();

        // and then all the items below the directory...
        for (File file : files) {
            if (filter == null || filter.accept(file)) {
                if (file.isDirectory()) {
                    copyDirectory(file, nextDirectory, filter);
                } else {
                    copyFile(file, nextDirectory);
                }
            }
        }
    }

    /**
     * Allows user to pass either a File or InputStream object
     *
     * @param source
     * @param destination
     * @throws IOException
     */

    private static void copyFile(File source, File destination) throws IOException {
        // what we really want to do is create a file with the same name in that dir
        if (destination.isDirectory())
            destination = new File(destination, source.getName());
        FileInputStream input = new FileInputStream(source);
        copyFile(source, destination);
    }

    /**
     * Gets the current working directory the application is running in.
     *
     * @return current working directory
     */

    public String getCurrentWorkingDirectory() {
        return System.getProperty("user.dir") + System.getProperty("file.separator");
    }

    /**
     * Basic user method that can pass either a directory or a file for copying.
     *
     * @param source      source file or directory
     * @param destination destination file or directory
     * @return whether operation was successful or not.
     * @throws IOException
     */

    public boolean copy(File source, File destination) throws IOException {
        boolean success = false;

        if (source == null) {
            throw new NullPointerException("Null Source");
        }
        if (destination == null) {
            throw new NullPointerException("Null Destination");
        }
        if (source.isDirectory()) {
            copyDirectory(source, destination);
            success = true;
        } else {
            copyFile(source, destination);
            success = true;
        }

        return success;
    }
}
