package io.interfiber.Pizza.lang;

public class SyntaxException extends Exception{

    /**
     * Throw this if the user typed something incorrectly
     * @since 0.2 Beta
     * @author Interfiber
     *
     */
    public SyntaxException(String syntaxType) {
        super(syntaxType);
    }
}