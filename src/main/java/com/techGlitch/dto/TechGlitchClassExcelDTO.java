package
        com.techGlitch.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TechGlitchClassExcelDTO {

    public String memberCode;

    public String memberName;

    public String name;

    public String mobNo;

    public String dateOfIncident;

    public String startTime;

    public String endTime;

    public String getMemberCode() {
        return memberCode;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getName() {
        return name;
    }

    public String getMobNo() {
        return mobNo;
    }

    public String getDateOfIncident() {
        return dateOfIncident;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }
}
