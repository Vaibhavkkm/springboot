package com.techGlitch.service.Impl;

import com.techGlitch.common.Constants;
import com.techGlitch.dto.JsonResponseDTO;
import com.techGlitch.model.MemberDetails;
import com.techGlitch.model.TechGlitchMaster;
import com.techGlitch.model.TechGlitchTDay;
import com.techGlitch.repository.*;
import com.techGlitch.response.TechGlitchResponse;
import com.techGlitch.service.TechGlitchService;
import com.techGlitch.utils.DayTimeCondition;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.event.WindowFocusListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.Locale;

@Service
@Slf4j
public class TechGlitchServiceImpl implements TechGlitchService {

    //------------------------------------------------------------------

    @Autowired
    MemberDetailsRepo memberDetailsRepo;

    @Autowired
    TechGlitchMasterRepo techGlitchMasterRepo;
    @Autowired
    TechGlitchTDayRepo techGlitchTDayRepo;
    @Autowired
    TechGlitchTPlusFrtnDaysRepo techGlitchTPlusFrtnDaysRepo;
    @Autowired
    TechGlitchTPlusOneDayRepo techGlitchTPlusOneDayRepo;

    //------------------------------------------------------------------

    public TechGlitchResponse getDataByReqRefNo(String reqRefNo){

        TechGlitchMaster techGlitchMaster = techGlitchMasterRepo.findByReqRefNo(reqRefNo);

        if((techGlitchMaster == null)){
            TechGlitchResponse response = TechGlitchResponse.builder()
                    .message(Constants.DATA_NOT_FOUND)
                    .success(false)
                    .build();
            return response;
        }

        //Direct Return
        return TechGlitchResponse.builder()
                .message(Constants.DATA_RETRIEVED_SUCCESSFULLY)
                .success(true)
                .techGlitchMaster(techGlitchMaster)
                .build();
    }

    //------------------------------------------------------------------

    private String generateReferenceNumber(Long memberId, Long requestId){

        String referenceNo= "";

        if(memberId != null && memberId != 0){

            MemberDetails memberDetails = memberDetailsRepo.findById(memberId).orElse(null);
            String memberCode = memberDetails !=null ? memberDetails.getMemberCode() : "";
            return memberCode +"/TECH_GLITCH/" + requestId;
        }

        return referenceNo;

    }

    @Override
    @Transactional
    public TechGlitchResponse submitData(Long memberId, String reqRefId,
                                         String userName, JsonResponseDTO jsonResponseDTO,
                                         MultipartFile glitchFile){

        String referenceNo= "";

        if(jsonResponseDTO.getRequestType().equals("T_DAY")){
            log.info("Inside T_DAY Request Type");
            TechGlitchTDay.TechGlitchTDayBuilder techGlitchTDayBuilder = null;

            Boolean penalty = true;
            String glitchStartTime = jsonResponseDTO.getCommonDTO().getStartTime();
            String incidentDate = jsonResponseDTO.getCommonDTO().getDateOfIncident();
            String emailSentTime = jsonResponseDTO.getCommonDTO().getEmailSentTime();
            String emailSentDate = jsonResponseDTO.getCommonDTO().getEmailSentDate();

            DateTimeFormatter dateFormatter = new DateTimeFormatterBuilder()
                    .parseCaseInsensitive()
                    .appendPattern("dd-MMM-YYYY")
                    .toFormatter(Locale.ENGLISH);

            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime formattedEmailSentTime = LocalTime.parse(emailSentTime, timeFormatter);
            LocalDate formattedEmailSentDate = LocalDate.parse(emailSentDate, dateFormatter);
            LocalDate formattedIncidentDate = LocalDate.parse(incidentDate, dateFormatter);
            LocalTime formattedGlitchTime = LocalTime.parse(glitchStartTime, timeFormatter);
            log.info("Checking if penalty is applicable or not");
            Boolean timeUnderRange = DayTimeCondition.isTimeUnderRange(formattedEmailSentDate, formattedIncidentDate, formattedEmailSentTime, formattedGlitchTime);
            penalty = timeUnderRange;

            String expectedDateOfSubmissionTDay = DayTimeCondition.timeAfterOneHour(formattedIncidentDate, formattedGlitchTime);
            String expectedDateOfSubmissionTPlsOneDay = DayTimeCondition.dateAfterOneDay(formattedIncidentDate);
            String expectedDateOfSubmissionTPlsFrtnDays = DayTimeCondition.dateAfterFourteenDays(formattedIncidentDate);
            log.info("Penalty Checked");

           TechGlitchMaster techGlitchMasterBuilder = TechGlitchMaster.builder()
                    .memberCode(jsonResponseDTO.getCommonDTO().getMemberCode())
                    .memberName(jsonResponseDTO.getCommonDTO().getMemberName())
                    .letterSubject(jsonResponseDTO.getCommonDTO().getLetterSubject())
                    .createdBy(userName)
                    .createdDate(String.valueOf(new Date(System.currentTimeMillis())))
                    .expectedSubmissionTDay(expectedDateOfSubmissionTDay)
                    .expectedSubmissionTPlusOneDay(expectedDateOfSubmissionTPlsOneDay)
                    .expectedSubmissionTPlusFrtnDays(expectedDateOfSubmissionTPlsFrtnDays)
                    .reqRefNo(referenceNo)
                    .status(Constants.T_DAY)
                    .penaltyTDay(penalty)
                   .build();
           techGlitchMasterRepo.save(techGlitchMasterBuilder);




        }
        return null;

    }




}