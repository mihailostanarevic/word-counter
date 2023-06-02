package com.synechron.wordcounter.counter;

import com.synechron.wordcounter.exceptions.WordFormatInvalidException;
import com.synechron.wordcounter.utils.Translator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CounterTests {

    private final String[] testWords = new String[5];
    private Counter counter;

    @BeforeEach
    public void fillTestWordsArray() {
        testWords[0] = Translator.WORD_THAT_HAS_TRANSLATION;
        testWords[1] = "Is a ";
        testWords[2] = "Word    Counter ";
        testWords[3] = "App ";
        testWords[4] = "123";
        this.counter = new CounterImpl();
    }

    @Test
    @DisplayName("should raise exception that inputted words are not in the correct format")
    public void testShouldRaiseWordFormatException() {
        Throwable exception = assertThrows(WordFormatInvalidException.class, () -> counter.enterWords(testWords));
        assertEquals(exception.getMessage(), WordFormatInvalidException.MESSAGE);
    }

    @Test
    @DisplayName("should enter correct amount of words into map")
    public void testShouldEnterCorrectAmountOfWordsIntoMap() throws WordFormatInvalidException {
        testWords[4] = "Valid";

        counter.enterWords(testWords);
        assertEquals(counter.getMap().entrySet().size(), 7);
    }

    @Test
    @DisplayName("should enter have adequate map as a result")
    public void testShouldRetrieveCorrectNumberOfOccurrences() throws WordFormatInvalidException {
        testWords[4] = "this";

        counter.enterWords(testWords);

        assertEquals(2, counter.getNumberOfOccurrencesForWord("this"));
    }

    @Test
    @DisplayName("should have adequate map as a result")
    public void testShouldHaveAdequateMapAsAResult() throws WordFormatInvalidException {
        testWords[4] = "this";

        counter.enterWords(testWords);

        final ConcurrentMap<String, Integer> resultMap = new ConcurrentHashMap<>();
        resultMap.put("THIS", 2);
        resultMap.put("IS", 1);
        resultMap.put("A", 1);
        resultMap.put("WORD", 1);
        resultMap.put("COUNTER", 1);
        resultMap.put("APP", 1);

        assertEquals(resultMap, counter.getMap());
    }
}
