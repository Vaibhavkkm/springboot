package com.techGlitch.utils;

import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Data
public class DayTimeCondition {

    public static Boolean isTimeUnderRange(LocalDate formattedEmailSentDate, LocalDate formattedGlitchIncidentDate,
                                           LocalTime formattedEmailSentTime, LocalTime formattedGlitchTime){

        Duration between = null;
        if(formattedGlitchIncidentDate.isBefore(formattedEmailSentDate)){
            return true;
        } else if (formattedGlitchIncidentDate.isEqual(formattedEmailSentDate)){
            between = Duration.between(formattedEmailSentTime, formattedGlitchTime);

            if(between.toMinutes() <= 0 && Math.abs(between.toMinutes()) <= 90){
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    //----------------------------------------------------------------------------------------

    //< 1 Day Submission Logic

    public static Boolean isDateUnderOneDayRange(LocalDate formattedGlitchIncidentDate){

        LocalDate currentDate = LocalDate.now();
        Long dateDifference = ChronoUnit.DAYS.between(formattedGlitchIncidentDate, currentDate);
        return Math.abs(dateDifference) > 1;

    }

    //----------------------------------------------------------------------------------------

    public static Boolean isDateUnderFourteenDaysRange(LocalDate formattedGlitchIncidentDate){

        LocalDate currentDate = LocalDate.now();
        Long dateDifference = ChronoUnit.DAYS.between(formattedGlitchIncidentDate, currentDate);

        return Math.abs(dateDifference) > 14;

    }

    //----------------------------------------------------------------------------------------

    public static String dateAfterFourteenDays(LocalDate formattedEmailSentDate) {

        LocalDate resultDate = formattedEmailSentDate.plusDays((14));
        LocalTime resultTime = LocalTime.of(23, 59);
        DateTimeFormatter outputFormattedDate = DateTimeFormatter.ofPattern("dd-MMM-YYYY HH:mm");
        String formattedDateTime = resultDate.atTime(resultTime).format(outputFormattedDate);
        return formattedDateTime;
    }

    //----------------------------------------------------------------------------------------

    public static String dateAfterOneDay(LocalDate formattedEmailSentDate) {
        LocalDate resultDate = formattedEmailSentDate.plusDays((1));
        LocalTime resultTime = LocalTime.of(23, 59);
        DateTimeFormatter outputFormattedDate = DateTimeFormatter.ofPattern("dd-MMM-YYYY HH:mm");
        String formattedDateTime = resultDate.atTime(resultTime).format(outputFormattedDate);
        return formattedDateTime;

    }

    //----------------------------------------------------------------------------------------

    public static String timeAfterOneHour (LocalDate formattedGlitchIncidentDate, LocalTime formattedGlitchTime){
    LocalTime resultTime = formattedGlitchTime.plusHours((1));
    LocalDate resultDate = resultTime.isBefore(formattedGlitchTime) ? formattedGlitchIncidentDate.plusDays(1) : formattedGlitchIncidentDate;
    DateTimeFormatter outputFormattedDate = DateTimeFormatter.ofPattern ("dd-MMM-YYYY");
    String formattedDate = formattedGlitchIncidentDate.format(outputFormattedDate);
    return  formattedDate + " " + resultTime;
    }

    //----------------------------------------------------------------------------------------
}
