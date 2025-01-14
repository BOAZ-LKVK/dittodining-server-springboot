package dittodining.api_server.domain.restaurant;

import lombok.*;

@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BusinessHour {
    private DayOfWeek dayOfWeekEnum;
    private String openTime;
    private String closingTime;
    private String breakStartTime;
    private String breakEndTime;
    private String lastOrderTime;
    private boolean isClosedDay;
}
