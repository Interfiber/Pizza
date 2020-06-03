package io.interfiber.Pizza.coreFunctions;

import java.io.IOException;

public class command {

    public static void executeCommand(String command) throws IOException {
            Process p = Runtime.getRuntime().exec(command);
    }
}
