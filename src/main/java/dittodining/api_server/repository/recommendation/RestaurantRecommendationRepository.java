package dittodining.api_server.repository.recommendation;

import dittodining.api_server.domain.recommendation.RestaurantRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRecommendationRepository extends JpaRepository<RestaurantRecommendation, Long> {
}
