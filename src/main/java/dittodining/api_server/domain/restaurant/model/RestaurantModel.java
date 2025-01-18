package dittodining.api_server.domain.restaurant.model;

import dittodining.api_server.domain.restaurant.entity.BusinessHour;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Getter
@AllArgsConstructor
@ToString
@Builder
public class RestaurantModel {
    private Long restaurantId;
    private String restaurantName;
    private String restaurantAddress;
    private String description;
    private BigDecimal maximumPricePerPerson;
    private BigDecimal minimumPricePerPerson;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private List<BusinessHour> businessHours;
    private List<String> restaurantImageURLs;
}
