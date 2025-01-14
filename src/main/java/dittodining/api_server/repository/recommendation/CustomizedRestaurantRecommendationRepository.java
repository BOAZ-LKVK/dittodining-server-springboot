package dittodining.api_server.repository.recommendation;

import dittodining.api_server.domain.recommendation.RestaurantRecommendation;

import java.util.List;

public interface CustomizedRestaurantRecommendationRepository {
    List<RestaurantRecommendation> findByRequestId(
            long requestId,
            Long cursorRecommendationId,
            Long limit
    );
}
