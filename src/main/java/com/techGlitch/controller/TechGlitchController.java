package com.techGlitch.controller;

import com.techGlitch.dto.JsonResponseDTO;
import com.techGlitch.response.TechGlitchResponse;
import com.techGlitch.service.Impl.TechGlitchServiceImpl;
import com.techGlitch.utils.FileValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(name = "techGlitch")
public class TechGlitchController {

    @Autowired
    TechGlitchServiceImpl techGlitchService;

    @PostMapping(value = "saveTechGlitchData")
    public ResponseEntity<?> saveTechGlitchData(@RequestHeader(value = "memberId") Long memberId,
                                             @RequestHeader(value = "sub") String userName,
                                             @RequestParam(value = "reqRefNo", required = false) String reqRefNo,
                                             @RequestPart JsonResponseDTO jsonResponseDTO,
                                             @RequestParam(value = "glitchFiles", required = false) MultipartFile glitchFile){


        TechGlitchResponse response = null;
        List<String> errors = null;

        try {
            errors = FileValidationUtils.validateFiles(glitchFile);

            if (!errors.isEmpty()) {
                response = TechGlitchResponse.builder()
                        .success(false)
                        .errorMessage(errors)
                        .build();

                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
            response=  techGlitchService.submitData(memberId, reqRefNo,
                    userName, jsonResponseDTO, glitchFile);

        } catch (Exception e){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }
