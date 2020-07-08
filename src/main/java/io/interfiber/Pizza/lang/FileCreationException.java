package io.interfiber.Pizza.lang;

public class FileCreationException extends Exception{

    public FileCreationException(String file){
        super("The File " + file + " Could Not Be Created!");
    }
}

