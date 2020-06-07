package io.interfiber.Pizza.lang;

public class MissingFunctionException extends Exception{

    public MissingFunctionException(String funcName) {
        super("There is no such function in the current file named " + funcName);
    }
}
