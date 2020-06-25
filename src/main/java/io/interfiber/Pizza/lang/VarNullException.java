package io.interfiber.Pizza.lang;

public class VarNullException extends Exception{
    /**
     * Throw this if a user try's to do something with a variable that doesnt exist
     * @param varName
     */
   public VarNullException(String varName) {
        super("No such variable with the name: " + varName);
    }
}
