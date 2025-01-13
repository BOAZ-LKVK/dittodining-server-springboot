package dittodining.api_server.repository.recommendation;

import dittodining.api_server.domain.recommendation.RestaurantRecommendationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRecommendationRequestRepository extends JpaRepository<RestaurantRecommendationRequest, Long> {
}
