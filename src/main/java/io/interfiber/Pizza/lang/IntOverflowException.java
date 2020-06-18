package io.interfiber.Pizza.lang;

public class IntOverflowException extends Exception{
    public IntOverflowException(){
        super("The contents of one Of your vars is too big!!");
    }
}
