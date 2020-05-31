package io.interfiber.Pizza.lang;

public class VarNullException {
    public static void catchError(String varName){
        System.out.println("SystemErrorReport: io.interfiber.Pizza.lang.VarNullException found!");
        System.out.println("There is no such variable called " + varName + " In the current program");
        System.out.println("Fatal! Terminating with exit code value of 1");
        System.exit(1);

    }
}
