package io.interfiber.Pizza.lang;

public class NullPointerException {

    public static void catchException(){
        System.err.println("SystemErrorReport: io.interfiber.Pizza.lang.NullPointerException found!");
        System.out.println("Terminating program with exit code of 1");
        System.exit(1);

    }
}