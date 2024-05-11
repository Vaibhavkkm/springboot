package com.techGlitch.service;

import com.techGlitch.dto.JsonResponseDTO;
import com.techGlitch.response.TechGlitchResponse;
import jakarta.transaction.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Transactional
public interface TechGlitchService {

    TechGlitchResponse submitData(Long memberId, String reqRefId,
                                  String userName, JsonResponseDTO jsonResponseDTO,
                                  MultipartFile glitchFile);
}
