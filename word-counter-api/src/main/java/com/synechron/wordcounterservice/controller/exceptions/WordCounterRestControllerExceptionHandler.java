package com.synechron.wordcounterservice.controller.exceptions;

import com.synechron.wordcounter.exceptions.WordFormatInvalidException;
import com.synechron.wordcounterservice.controller.WordCounterRestController;
import com.synechron.wordcounterservice.controller.dto.ResponseErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;

@ControllerAdvice(basePackageClasses = WordCounterRestController.class)
public class WordCounterRestControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = WordFormatInvalidException.class)
    public ResponseEntity<Object> handleException(final WordFormatInvalidException exception) {
        return ResponseEntity.badRequest().body(new ResponseErrorMessage(OffsetDateTime.now(), exception.getMessage()));
    }
}
