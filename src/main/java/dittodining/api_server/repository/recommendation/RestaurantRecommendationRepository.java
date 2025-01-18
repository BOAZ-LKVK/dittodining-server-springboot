package dittodining.api_server.repository.recommendation;

import dittodining.api_server.domain.recommendation.RestaurantRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRecommendationRepository extends JpaRepository<RestaurantRecommendation, Long>, CustomizedRestaurantRecommendationRepository {

    List<RestaurantRecommendation> findByRestaurantId(Long restaurantId);

    List<RestaurantRecommendation> findByRestaurantIdIn(List<Long> restaurantIds);

    RestaurantRecommendation findTopByRestaurantRecommendationRequestIdOrderByRestaurantRecommendationRequestIdDesc(
            Long restaurantRecommendationRequestId
    );
}
