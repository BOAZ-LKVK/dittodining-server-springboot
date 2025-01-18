package dittodining.api_server.domain.restaurant.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@Builder
@ToString
public class RestaurantMenuModel {
    private Long restaurantMenuId;
    private String imageURL;
    private String name;
    private BigDecimal price;
    private String description;
}
