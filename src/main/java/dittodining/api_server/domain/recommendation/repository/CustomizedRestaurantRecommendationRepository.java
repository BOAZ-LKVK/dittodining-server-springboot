package dittodining.api_server.domain.recommendation.repository;

import dittodining.api_server.domain.recommendation.entity.RestaurantRecommendation;

import java.util.List;

public interface CustomizedRestaurantRecommendationRepository {
    List<RestaurantRecommendation> findByRequestId(
            long requestId,
            Long cursorRecommendationId,
            Long limit
    );
}
