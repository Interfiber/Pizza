package io.interfiber.Pizza.lang;

public class ArrayInputNullException extends Exception{

    /**
     * If an array doesnt have any declared variables throw this exception
     * @param arrayName
     */
    public ArrayInputNullException(String arrayName){
        super("There is No Declared Variables in The Array Store File Named: " + arrayName);
    }
}
