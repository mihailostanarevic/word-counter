package com.synechron.wordcounter.utils;

public class Translator {

    private static Translator INSTANCE;
    public static String WORD_THAT_HAS_TRANSLATION = "ovo";
    public static String TRANSLATED_WORD = "this";

    private Translator() {}

    public static Translator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Translator();
        }

        return INSTANCE;
    }

    public String translate(final String word) {
        if (word.equals(WORD_THAT_HAS_TRANSLATION)) return TRANSLATED_WORD;
        return word;
    }
}
