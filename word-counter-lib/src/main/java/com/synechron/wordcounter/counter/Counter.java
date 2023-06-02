package com.synechron.wordcounter.counter;

import com.synechron.wordcounter.exceptions.WordFormatInvalidException;

import java.util.concurrent.ConcurrentMap;

public interface Counter {

    void enterWords(final String[] words) throws WordFormatInvalidException;

    int getNumberOfOccurrencesForWord(final String word);

    ConcurrentMap<String, Integer> getMap();
}
