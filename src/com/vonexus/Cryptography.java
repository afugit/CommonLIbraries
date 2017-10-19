/**
 * Provides extension to LOGGER that allows for runtime debugging.  May
 * need to depreciate this class if LOGGER does everything I need already,
 * but may be neat to create completely custom output instead of rlying on
 * LOGGER.
 *
 * @author Anthony M. Fugit
 * @version 0.1.20171018
 */

package com.vonexus;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cryptography {

    /**
     * Start logger
     */

    private static final Logger LOGGER = Logger.getLogger(Cryptography.class.getName());

    /**
     * When not using a public constructor, create a private one:
     */

    private Cryptography() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Creates a hash based on PBKKDF2
     *
     * @param password user-inputed string to encrypt
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */

    private static String generateStrongPasswordHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        int iterations = 1000;
        char[] chars = password.toCharArray();
        byte[] salt = getSalt();

        PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = skf.generateSecret(spec).getEncoded();
        return iterations + ":" + toHex(salt) + ":" + toHex(hash);
    }

    /**
     * Generate random salt
     *
     * @return
     * @throws NoSuchAlgorithmException
     */

    private static byte[] getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

    /* NOTE: Not sure what this is actually doing.  Refactored from
     * https://howtodoinjava.com/security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/
     *
     * TODO: Needs testing to see if it has purpose or not.
     */

    /**
     * Does something, I don't know.  Used when returning password to user via
     * generatesStrongPasswordHash.
     *
     * @param array
     * @return
     * @throws NoSuchAlgorithmException
     */

    private static String toHex(byte[] array) throws NoSuchAlgorithmException {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if (paddingLength > 0) {
            return String.format("%0" + paddingLength + "d", 0) + hex;
        } else {
            return hex;
        }
    }

    /**
     * Return the MD5 checksum of a string passed by user.
     *
     * @param userString string to be encoded
     * @return
     * @throws Exception
     */

    public String md5(String userString) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(userString.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (byte aByteData : byteData) {
            sb.append(Integer.toString((aByteData & 0xff) + 0x100, 16).substring(1));
        }

        //convert the byte to hex format method 2
        StringBuilder hexString = new StringBuilder();
        for (byte aByteData : byteData) {
            String hex = Integer.toHexString(0xff & aByteData);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    /**
     * Gets MD5 checksum of a file, useful for bit-comparison verification
     * between two files.
     *
     * @param filePath
     * @return
     */

    public String md5File(String filePath) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            LOGGER.log(Level.SEVERE, e.getLocalizedMessage());
            return "Returning from NoSuchAlgorithmException";
        }
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            LOGGER.log(Level.SEVERE, e.getLocalizedMessage());
            return "Returning from FileNotFoundException";
        }

        byte[] dataBytes = new byte[1024];

        int nread = 0;
        try {
            while ((nread = fis.read(dataBytes)) != -1) {
                md.update(dataBytes, 0, nread);
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getLocalizedMessage());
            return "Returning from IOException";
        }

        byte[] mdbytes = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (byte mdbyte1 : mdbytes) {
            sb.append(Integer.toString((mdbyte1 & 0xff) + 0x100, 16).substring(1));
        }

        //convert the byte to hex format method 2
        StringBuilder hexString = new StringBuilder();
        for (byte mdbyte : mdbytes) {
            String hex = Integer.toHexString(0xff & mdbyte);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}