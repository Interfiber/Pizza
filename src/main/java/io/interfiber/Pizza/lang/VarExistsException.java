package io.interfiber.Pizza.lang;

public class VarExistsException extends Exception{
    /**
     * Throw this when user try's to create a variable that already exists
     * @param varName
     */
    public VarExistsException(String varName){
        super("There Is Already A Variable in the current file called " + varName);
    }
}
