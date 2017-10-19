/**
 * E-mail interface to send/receive e-mail and other forms of communication.
 *
 * @author Anthony M. Fugit
 * @version 0.1.20171018
 */

package com.vonexus;

import java.util.logging.Logger;

public class Communications {

    /**
     * Start logger
     */

    private static final Logger LOGGER = Logger.getLogger(Communications.class.getName());

    /**
     * When not using a public constructor, create a private one:
     */

    private Communications() {
        throw new IllegalStateException("Utility class");
    }


}

