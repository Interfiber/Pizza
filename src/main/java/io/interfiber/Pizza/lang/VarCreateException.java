package io.interfiber.Pizza.lang;

public class VarCreateException extends Exception{

    public VarCreateException(String VarName){
        super("Failed To Create A Variable With The Name Of " + VarName);
    }
}
