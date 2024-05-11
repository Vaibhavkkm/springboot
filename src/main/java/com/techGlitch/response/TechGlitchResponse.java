package com.techGlitch.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.techGlitch.model.TechGlitchMaster;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class TechGlitchResponse {

    private Boolean success;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TechGlitchMaster techGlitchMaster;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> errorMessage;



}
