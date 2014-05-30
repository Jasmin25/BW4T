package nl.tudelft.bw4t.logger;


import org.apache.log4j.Level;

public class BotLog extends Level {
    
    /**
     * Value of BotLog level. This value is bigger than FATAL,
     * to make sure this is the only level that will log to the file.
     */
    public static final int BOTLOG_INT = FATAL_INT + 10;
    
    public static final Level BOTLOG = new BotLog(BOTLOG_INT, "BOTLOG", 10);
    
    /**
     * Constructor
     */
    protected BotLog(int arg0, String arg1, int arg2) {
        super(arg0, arg1, arg2);
 
    }
 
    /**
     * Checks whether logArgument is "BOTLOG" level. If yes then returns
     * BOTLOG}, else calls BotLog#toLevel(String, Level) passing
     * it Level#DEBUG as the defaultLevel.
     */
    public static Level toLevel(String logArgument) {
        if (logArgument != null && logArgument.toUpperCase().equals("BOTLOG")) {
            return BOTLOG;
        }
        return (Level) toLevel(logArgument);
    }
 
    /**
     * Checks whether val is BotLog#BOTLOG_INT. If yes then
     * returns BotLog#BOTLOG, else calls
     * BotLog#toLevel(int, Level) passing it Level#DEBUG as the
     * defaultLevel
     * 
     */
    public static Level toLevel(int val) {
        if (val == BOTLOG_INT) {
            return BOTLOG;
        }
        return (Level) toLevel(val, Level.DEBUG);
    }
 
    /**
     * Checks whether val is BotLog#BOTLOG_INT. If yes
     * then returns BotLog#BOTLOG, else calls Level#toLevel(int, org.apache.log4j.Level)
     * 
     */
    public static Level toLevel(int val, Level defaultLevel) {
        if (val == BOTLOG_INT) {
            return BOTLOG;
        }
        return Level.toLevel(val, defaultLevel);
    }
 
    /**
     * Checks whether logArgument is "BOTLOG" level. If yes then returns
     * BotLog#BOTLOG, else calls
     * Level#toLevel(java.lang.String, org.apache.log4j.Level)
     * 
     */
    public static Level toLevel(String logArgument, Level defaultLevel) {
        if (logArgument != null && logArgument.toUpperCase().equals("BOTLOG")) {
            return BOTLOG;
        }
        return Level.toLevel(logArgument, defaultLevel);
    }
    
    
}
