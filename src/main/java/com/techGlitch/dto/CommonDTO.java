package com.techGlitch.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommonDTO {

    private Long requestId;

    private String memberCode;

    private String memberName;

    private String reqRefNo;

    private String emailSentTime;

    private String emailSentDate;

    private String letterSubject;

    private String status;

    private String createdBy;

    private String createdDate;

    private String expectedSubmissionTDay;

    private Boolean penaltyTDay;

    private Boolean penaltyTPlusOneDay;

    private Boolean penaltyTPlusFourteenDays;

    private String expectedSubmissionTPlusOneDay;

    private String expectedSubmissionTPlusFrtnDays;

    private String tOneDocId;

    private String tDocId;

    private String tFrtnDocId;

    private String name;

    private String mobNo;

    private String vkkmFileName;

    private String dateOfIncident;

    private LocalDate submissionDate;

    private String startTime;

    private String endTime;

    private String tFrtnFileName;

    private String tOneFileName;

}
