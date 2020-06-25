package io.interfiber.Pizza.utils;

public class Logger {
    /**
     * Log info to the console
     * example
     * Logger l = new Logger();
     * l.info("Reading this string with my eyes!");
     * l.warn("Hmmm... Thats weird");
     * l.error("Thats Bad! But I can deal with it");
     * l.fatal("I AM DEAD!");
     * @param message
     */
    public void info(String message){
        System.out.println("[Pizza/INFO Main Thread]: " + message);
    }
    public void warn(String message){
        System.out.println("[Pizza/WARN Main Thread]: " + message);
    }
    public void error(String message){
        System.out.println("[Pizza/ERROR Main Thread]: " + message);

    }
    public void fatal(String message) {
        System.out.println("[Pizza/FATAl Main Thread]: " + message);
    }
}
