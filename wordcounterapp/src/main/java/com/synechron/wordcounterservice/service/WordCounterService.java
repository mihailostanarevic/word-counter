package com.synechron.wordcounterservice.service;

import com.synechron.wordcounter.counter.Counter;
import com.synechron.wordcounter.exceptions.WordFormatInvalidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordCounterService {

    @Autowired
    private Counter counter;

    public void enterWordsIntoCounterMap(final List<String> words) throws WordFormatInvalidException {
        counter.enterWords(words.toArray(new String[0]));
    }

    public int getNumberOfOccurrences(final String word) {
        return counter.getNumberOfOccurrencesForWord(word);
    }
}
