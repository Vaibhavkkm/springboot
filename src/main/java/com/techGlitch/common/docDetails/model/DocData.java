package com.techGlitch.common.docDetails.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class DocData {

    private String author;
    private String comment;
    private String folderPath;
    private String docIndex;

}
