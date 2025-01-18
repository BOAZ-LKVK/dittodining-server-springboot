package dittodining.api_server.domain.restaurant.repository;

import dittodining.api_server.domain.restaurant.entity.RestaurantReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantReviewRepository extends JpaRepository<RestaurantReview, Long> {

    List<RestaurantReview> findByRestaurantId(Long restaurantId);

    List<RestaurantReview> findByRestaurantIdIn(List<Long> restaurantIds);

    Long countByRestaurantId(Long restaurantId);
}
