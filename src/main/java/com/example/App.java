package com.example;

/**
 * Main application class demonstrating basic Java application structure.
 */
public class App {
    private static final String DEFAULT_GREETING = "Hello World!";

    /**
     * Application entry point.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        App app = new App();
        String greeting = args.length > 0 ? app.getGreeting(args[0]) : app.getGreeting();
        System.out.println(greeting);
    }

    /**
     * Returns the default greeting message.
     * @return the greeting string
     */
    public String getGreeting() {
        return DEFAULT_GREETING;
    }

    /**
     * Returns a personalized greeting message.
     * @param name the name to greet
     * @return the personalized greeting string
     */
    public String getGreeting(String name) {
        if (name == null || name.trim().isEmpty()) {
            return getGreeting();
        }
        return "Hello " + name.trim() + "!";
    }
}
