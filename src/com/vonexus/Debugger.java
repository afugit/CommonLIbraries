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

import java.util.logging.Logger;

public class Debugger extends Logger {

    /**
     * Start logger
     */

    private static final Logger LOGGER = Logger.getLogger(Debugger.class.getName());

    /**
     * When not using a public constructor, create a private one:
     */

    private Debugger() {
        throw new IllegalStateException("Utility class");
    }

}
