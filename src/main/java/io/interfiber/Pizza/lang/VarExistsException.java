package io.interfiber.Pizza.lang;

public class VarExistsException extends Exception{

    public VarExistsException(String varName){
        super("There Is Already A Variable in the current file called " + varName);
    }
}
