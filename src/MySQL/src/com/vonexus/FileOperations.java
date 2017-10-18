/**
 * File and directory operations to make Main code a lot cleaner.  Contains
 * FIle IO functions to help prevent building long strings.
 *
 * @author Anthony M. Fugit
 * @version 0.1.20171018
 */

package com.vonexus;

/**
 * Operations that interact with the file system.  Opening and reading files,
 * making duplicate copies of files or folders, etc.
 */

public class FileOperations {
    /**
     * Gets the current working directory the application is running in.
     *
     * @return current working directory
     */
    public String getCurrentWorkingDirectory() {
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator");
        return filePath;
    }


}
