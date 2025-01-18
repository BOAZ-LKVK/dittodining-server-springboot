package dittodining.api_server.domain.recommendation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@Builder
public class RequestRestaurantRecommendationResultModel {
    private Long restaurantRecommendationRequestID;
    private boolean isAvailableLocation;
}
