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
     * Protected method to construct a logger for a named subsystem.
     * <p>
     * The logger will be initially configured with a null Level
     * and with useParentHandlers set to true.
     *
     * @param name               A name for the logger.  This should be a dot-separated name
     *                           and should normally be based on the package name or class name of
     *                           the subsystem, such as java.net or javax.swing.  It may be null for \
     *                           anonymous Loggers.
     * @param resourceBundleName name of ResourceBundle to be used for localizing
     *                           messages for this logger.  May be null if none of the messages require
     *                           localization.
     * @throws MissingResourceException if the resourceBundleName is non-null
     *                                  andno corresponding resource can be found.
     */
    protected Debugger(String name, String resourceBundleName) {
        super(name, resourceBundleName);
    }
}
