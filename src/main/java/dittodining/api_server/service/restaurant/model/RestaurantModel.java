package dittodining.api_server.service.restaurant.model;

import dittodining.api_server.domain.restaurant.BusinessHour;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@AllArgsConstructor
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
