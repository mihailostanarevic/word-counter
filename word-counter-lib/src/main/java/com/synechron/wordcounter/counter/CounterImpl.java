package com.synechron.wordcounter.counter;

import com.synechron.wordcounter.exceptions.WordFormatInvalidException;
import com.synechron.wordcounter.utils.Translator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.regex.Pattern;

public class CounterImpl implements Counter {

    private final Translator translator;
    private final ConcurrentMap<String, Integer> wordMap;

    private final Function<String, String> cleanInput = String::trim;
    private final Pattern wordSupportedRegex = Pattern.compile("([A-Za-z]+)");

    private final Function<String, String> translateToMapFormat = String::toUpperCase;

    public CounterImpl() {
        wordMap = new ConcurrentHashMap<>();
        translator = Translator.getInstance();
    }

    public void enterWords(final String[] words) throws WordFormatInvalidException {
        final List<String> wordsToAdd = new ArrayList<>();
        for (String word : words) {
            final List<String> analyzedWords = analyzeWords(word);
            for (String analyzedWord : analyzedWords) {
                validateWord(analyzedWord);
            }
            wordsToAdd.addAll(analyzedWords);
        }

        wordsToAdd.parallelStream().forEach(this::insertWordIntoMap);
    }

    public int getNumberOfOccurrencesForWord(final String word) {
        final String translatedWord = translator.translate(word);
        return wordMap.getOrDefault(translateToMapFormat.apply(translatedWord), 0);
    }

    //mainly for testing purposes, doesn't need to be exposed
    public ConcurrentMap<String, Integer> getMap() {
        return wordMap;
    }

    private void insertWordIntoMap(final String word) {
        final String translatedWord = translator.translate(word);
        wordMap.put(
            translateToMapFormat.apply(translatedWord),
            wordMap.getOrDefault(translateToMapFormat.apply(translatedWord), 0) + 1
        );
    }

    private List<String> analyzeWords(final String word) {
        return Arrays.asList(cleanInput.apply(word).split(" +"));
    }

    private void validateWord(final String word) throws WordFormatInvalidException {
        if (!wordSupportedRegex.matcher(word).matches()) {
            throw new WordFormatInvalidException();
        }
    }
}
