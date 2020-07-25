package io.interfiber.Pizza.lang;

public class ClassExistsException extends Exception{

    public ClassExistsException(String className){
        super("There is already a class with the name " + className + " In the current file!");
    }
}
