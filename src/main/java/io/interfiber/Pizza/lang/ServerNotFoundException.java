package io.interfiber.Pizza.lang;

public class ServerNotFoundException extends Exception{
    /**
     * Throw this if a server ip cant be connected to or found
     * @param serverAddress
     */
    public ServerNotFoundException(String serverAddress) {
        super("Could not Connect to the server ip " + serverAddress);
    }
}
