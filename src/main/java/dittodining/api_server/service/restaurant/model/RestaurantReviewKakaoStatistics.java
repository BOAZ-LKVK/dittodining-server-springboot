package dittodining.api_server.service.restaurant.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@Builder
@Getter
@ToString
public class RestaurantReviewKakaoStatistics {
    private BigDecimal averageScore;
    private Long count;
}
