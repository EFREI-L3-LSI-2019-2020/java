package fr.efrei.tp3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Logger manager Manages the log4j instance
 */
public class LoggerManager {

    private static LoggerManager INSTANCE;

    static {
        LoggerManager.INSTANCE = new LoggerManager();
    }

    private Logger logger;

    private LoggerManager() {
        this.logger = LogManager.getLogger(getClass());
    }

    /**
     * Gets instance logger.
     *
     * @return the LoggerManager instance logger
     */
    public static LoggerManager getInstanceLogger() {
        return INSTANCE;
    }

    /**
     * Get logger Log4j logger.
     *
     * @return the Log4j logger
     */
    public Logger getLogger() {
        return logger;
    }
}