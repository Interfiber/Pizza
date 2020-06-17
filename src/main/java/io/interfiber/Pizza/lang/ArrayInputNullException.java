package io.interfiber.Pizza.lang;

public class ArrayInputNullException extends Exception{

    public ArrayInputNullException(String arrayName){
        super("There is No Declared Variables in The Array Store File Named: " + arrayName);
    }
}
