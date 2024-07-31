package utils;

//import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logger {
    private static final Logger logger = (Logger) LoggerFactory.getLogger(Logger.class);
    
    public static Logger getLogger() {
        return logger;
    }
}
