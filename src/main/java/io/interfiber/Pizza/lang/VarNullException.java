package io.interfiber.Pizza.lang;

public class VarNullException extends Exception{
   public VarNullException(String varName) {
        super("No such variable with the name: " + varName);
    }
}
