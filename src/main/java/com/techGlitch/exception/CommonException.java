package com.techGlitch.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
public class CommonException extends Exception {

    private static final Long serialVersionUID = 1L;

    @Getter
    private String errorCode;

    @Getter
    private String message;


    @Getter
    private HttpStatus status;

}
