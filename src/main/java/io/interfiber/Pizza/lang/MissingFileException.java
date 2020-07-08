package io.interfiber.Pizza.lang;

public class MissingFileException extends Exception {
    public MissingFileException(String file){
        super("The File " + file + " Does not exist!");
    }
}
