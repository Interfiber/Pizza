package io.interfiber.Pizza.lang;

public class SyntaxException extends Exception{

    /**
     *
     * @since 0.2 Beta
     * @author Interfiber
     *
     */
    public SyntaxException(String syntaxType) {
        super(syntaxType);
    }
}