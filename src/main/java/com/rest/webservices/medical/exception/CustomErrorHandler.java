package com.rest.webservices.medical.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomErrorHandler {

    private LocalDateTime dateTime;
    private String message;
    private String path;
}
