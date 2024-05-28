package com.techGlitch.common.docDetails.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.techGlitch.common.docDetails.model.DocData;
import com.techGlitch.exception.CommonException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@RequiredArgsConstructor
@PropertySource("classpath:application.yaml")
public class DocDataServiceImpl implements DocDataService{
    @Override
    public DocData upload(MultipartFile file, String addDoc) {
        return null;
    }

    @Override
    public Long createDocFolder(Long lookInFolder, String type) throws JsonProcessingException, CommonException {
        return null;
    }

    @Override
    public DocData technicalGlitchUpload(MultipartFile file, String memberId, String reqId, String reqType) throws JsonProcessingException, CommonException {
        return null;
    }

//    private final Doc




}
