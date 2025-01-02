package dittodining.api_server.domain.restaurant;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class BusinessHour {
    private DayOfWeek dayOfWeekEnum;
    private String openTime;
    private String closingTime;
    private boolean isClosedDay;
}
