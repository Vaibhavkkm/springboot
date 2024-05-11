package com.techGlitch.utils;

import com.techGlitch.common.Constants;
import com.techGlitch.exception.FileInvalidException;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public class FileValidationUtils {

    public static List<String> validateFiles(MultipartFile... files){

        List<String> validationStatus = new ArrayList<>();
        int count = 1;

        for(MultipartFile file : files){

            if(file==null){
                continue;
            }

            if(file.getSize() > 10*1024*1024){
                FileInvalidException exception = new FileInvalidException();
                validationStatus.add(file.getOriginalFilename() + " "+ Constants.FILE_SIZE_SHOULD_LESS_THAN_5MB);
            }
            count ++;

        }
return validationStatus;
    }

}
