package com.techGlitch.common.docDetails.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.techGlitch.common.docDetails.model.DocData;
import com.techGlitch.exception.CommonException;
import org.springframework.web.multipart.MultipartFile;

public interface DocDataService {

    DocData upload(MultipartFile file, String addDoc);
    public Long createDocFolder(Long lookInFolder, String type) throws JsonProcessingException, CommonException;

    public DocData technicalGlitchUpload(MultipartFile file, String memberId, String reqId, String reqType) throws JsonProcessingException, CommonException;

}
