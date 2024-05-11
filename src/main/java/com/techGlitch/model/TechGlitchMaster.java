package com.techGlitch.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "TBL_TECH_GLITCH_MASTER")
public class TechGlitchMaster {

    @Id
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "SEQ_TECH_GLITCH_MASTER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    @Column(name = "REQUEST_ID")
    private Long requestId;

    @OneToOne(mappedBy = "techGlitchMaster", cascade = CascadeType.ALL)
    @JsonManagedReference
    private TechGlitchTDay techGlitchTDay;

    @OneToOne(mappedBy = "techGlitchMaster", cascade = CascadeType.ALL)
    @JsonManagedReference
    private TechGlitchTPlusOneDay techGlitchTPlusOneDay;

    @OneToOne(mappedBy = "techGlitchMaster", cascade = CascadeType.ALL)
    @JsonManagedReference
    private TechGlitchTPlusFrtnDays techGlitchTPlusFrtnDays;

    @Column(name="REQ_REF_NO")
    private String reqRefNo;

    @Column(name="MEMBER_NAME")
    private String memberName;

    @Column(name="MEMBER_CODE")
    private String memberCode;

    //For SQL Developer
//    @Lob
//    @Column(name= "LETTER_SUBJECT", columnDefinition = "CLOB")
//    private String letterSubject;

    @Lob
    @Column(name= "LETTER_SUBJECT", columnDefinition = "LONGTEXT")
    private String letterSubject;

    @Column(name="STATUS")
    private String status;

    @Column(name="CREATED_BY")
    private String createdBy;

    @Column(name="CREATED_DATE")
    private String createdDate;

    @Column(name="EXPECTED_SUBMISSION_T_DAY")
    private String expectedSubmissionTDay;

    @Column(name = "PENALTY_T_DAY")
    private Boolean penaltyTDay;

    @Column(name = "PENALTY_T_PLUS_ONE_DAY")
    private Boolean penaltyTPlusOneDay;

    @Column(name = "PENALTY_T_PLUS_FOURTEEN_DAYS")
    private Boolean penaltyTPlusFourteenDays;

    @Column(name="EXPECTED_SUBMISSION_T_PLUS_ONE_DAY")
    private String expectedSubmissionTPlusOneDay;

    @Column(name="EXPECTED_SUBMISSION_T_PLUS_FRTN_DAYS")
    private String expectedSubmissionTPlusFrtnDays;

    @Column(name = "TONE_FILE_DOC_ID")
    private String tOneDocId;

    @Column(name = "T_FILE_DOC_ID")
    private String tDocId;

    @Column(name = "TFRTN_FILE_DOC_ID")
    private String tFrtnDocId;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "temp")
//    @JsonManagedReference
//    private List<>


}
