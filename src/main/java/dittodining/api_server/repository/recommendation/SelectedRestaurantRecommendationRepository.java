package dittodining.api_server.repository.recommendation;

import dittodining.api_server.domain.recommendation.SelectedRestaurantRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SelectedRestaurantRecommendationRepository extends JpaRepository<SelectedRestaurantRecommendation, Long> {

    List<SelectedRestaurantRecommendation> findByRestaurantRecommendationRequestId(Long requestId);
}
