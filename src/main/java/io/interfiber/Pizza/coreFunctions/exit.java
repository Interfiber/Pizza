package io.interfiber.Pizza.coreFunctions;

import io.interfiber.Pizza.utils.cleanup;

public class exit {

    public static void terminateProcess(int exitCode) {
        // Run cleanup on tmp dirs
        cleanup.cleanup();
        // Exit program
        System.exit(exitCode);

    }
}
