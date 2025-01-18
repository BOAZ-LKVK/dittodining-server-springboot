package dittodining.api_server.domain.recommendation.repository;

import dittodining.api_server.domain.recommendation.entity.RestaurantRecommendationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRecommendationRequestRepository extends JpaRepository<RestaurantRecommendationRequest, Long> {
}
