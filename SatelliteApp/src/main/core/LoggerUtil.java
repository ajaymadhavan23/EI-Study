package main.core;

import java.util.logging.*;

public class LoggerUtil {
    private static Logger logger = Logger.getLogger("SatelliteLogger");

    static {
        logger.setLevel(Level.ALL);
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        logger.addHandler(handler);
        logger.setUseParentHandlers(false);
    }

    public static void logInfo(String message) {
        logger.info(message);
    }

    public static void logWarning(String message) {
        logger.warning(message);
    }

    synchronized public static void logError(String message) {
        logger.severe(message);
    }
}
