package com.techGlitch.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TBL_TECH_GLITCH_T_PLUS_FOURTEEN_DAYS")
public class TechGlitchTPlusFrtnDays {

    @Id
    @SequenceGenerator(name="SEQ_GEN", sequenceName = "SEQ_TECH_GLITCH_T_PLUS_FRTN_DAYS", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    @Column(name = "REQUEST_ID")
    private Long requestId;

    @OneToOne
    @JoinColumn(name = "TONE_REQ_ID")
    @JsonBackReference
    private TechGlitchMaster techGlitchMaster;

    @Column(name = "NAME")
    private String name;

    @Column(name = "MOB_NO")
    private String mobNo;

    @Column(name = "TFRTN_FILE_NAME")
    private String tFrtnFileName;

    @Column(name = "DATE_OF_INCIDENT")
    private String dateOfIncident;

    @Column(name = "SUBMISSION_DATE_TIME")
    private LocalDate submissionDate;

    @Column(name = "START_TIME")
    private String startTime;

    @Column(name = "END_TIME")
    private String endTime;
}
