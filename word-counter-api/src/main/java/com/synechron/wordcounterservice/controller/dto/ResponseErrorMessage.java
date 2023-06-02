package com.synechron.wordcounterservice.controller.dto;

import lombok.AllArgsConstructor;

import java.time.OffsetDateTime;

@AllArgsConstructor
public class ResponseErrorMessage {
    private OffsetDateTime timestamp;
    private String message;
}
