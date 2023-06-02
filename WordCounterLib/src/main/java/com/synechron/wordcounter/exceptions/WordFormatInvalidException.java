package com.synechron.wordcounter.exceptions;

public class WordFormatInvalidException extends Throwable {

    public WordFormatInvalidException() {}

    @Override
    public String getMessage() {
        return MESSAGE;
    }

    public static final String MESSAGE = "Words cannot contain non-alphabetical characters.";
}
