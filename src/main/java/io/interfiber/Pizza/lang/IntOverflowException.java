package io.interfiber.Pizza.lang;

public class IntOverflowException extends Exception{
    /**
     * If a variable exceeds the java Int limit throw this
     */
    public IntOverflowException(){
        super("The contents of one Of your vars is too big!!");
    }
}
