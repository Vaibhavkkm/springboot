package com.techGlitch.exception;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class FileInvalidException extends RuntimeException{

    private Map<String, Object> errorMessage = new HashMap<>();


}
