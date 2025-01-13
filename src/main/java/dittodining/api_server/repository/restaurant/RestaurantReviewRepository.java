package dittodining.api_server.repository.restaurant;

import dittodining.api_server.domain.restaurant.RestaurantReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantReviewRepository extends JpaRepository<RestaurantReview, Long> {

    List<RestaurantReview> findByRestaurantId(Long restaurantId);

    List<RestaurantReview> findByRestaurantIdIn(List<Long> restaurantIds);

    Long countByRestaurantId(Long restaurantId);
}
