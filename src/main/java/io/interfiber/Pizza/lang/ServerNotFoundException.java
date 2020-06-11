package io.interfiber.Pizza.lang;

public class ServerNotFoundException extends Exception{

    public ServerNotFoundException(String serverAddress) {
        super("Could not Connect to the server ip " + serverAddress);
    }
}
