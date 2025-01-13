package dittodining.api_server.domain.restaurant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
@AllArgsConstructor
public class BusinessHour {
    private DayOfWeek dayOfWeekEnum;
    private String openTime;
    private String closingTime;
    private String breakStartTime;
    private String breakEndTime;
    private String lastOrderTime;
    private boolean isClosedDay;
}
