package com.synechron.wordcounterservice.controller;

import com.synechron.wordcounter.exceptions.WordFormatInvalidException;
import com.synechron.wordcounterservice.controller.dto.OccurrencesResponseDto;
import com.synechron.wordcounterservice.controller.dto.SubmitWordsRequestDto;
import com.synechron.wordcounterservice.service.WordCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/word-counter")
public class WordCounterRestController {

    @PostMapping("/submit-words")
    public void submitWords(@RequestBody final SubmitWordsRequestDto wordsDto) throws WordFormatInvalidException {
        wordCounterService.enterWordsIntoCounterMap(wordsDto.getWords());
    }

    @GetMapping("/get-occurrences/{word}")
    public OccurrencesResponseDto submitWords(@PathVariable(value = "word") final String word) {
        return new OccurrencesResponseDto(wordCounterService.getNumberOfOccurrences(word));
    }

    @Autowired
    private WordCounterService wordCounterService;
}
