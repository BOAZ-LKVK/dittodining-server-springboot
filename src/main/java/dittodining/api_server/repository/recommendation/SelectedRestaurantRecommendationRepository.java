package dittodining.api_server.repository.recommendation;

import dittodining.api_server.domain.recommendation.SelectedRestaurantRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SelectedRestaurantRecommendationRepository extends JpaRepository<SelectedRestaurantRecommendation, Long> {
}
