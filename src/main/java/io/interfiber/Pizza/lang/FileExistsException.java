package io.interfiber.Pizza.lang;

public class FileExistsException extends Exception{
    public FileExistsException(String path){
        super("The File " + path + " Already Exists!");
    }
}
