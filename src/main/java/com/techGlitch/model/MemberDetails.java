package com.techGlitch.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TBL_MEMBER_DETAILS")
public class MemberDetails {

    @Id
    @Column(name = "MEMBER_ID", nullable = false)
    private Long id;

    @Column(name = "MEMBER_CODE", nullable = false)
    private String memberCode;

    @Column(name = "MEMBER_NAME")
    private String memberName;

}
