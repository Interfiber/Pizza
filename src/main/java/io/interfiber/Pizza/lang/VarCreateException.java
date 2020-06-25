package io.interfiber.Pizza.lang;

public class VarCreateException extends Exception{
    /**
     * Throw this if you tried but failed to create a varible
     * @param VarName
     */
    public VarCreateException(String VarName){
        super("Failed To Create A Variable With The Name Of " + VarName);
    }
}
