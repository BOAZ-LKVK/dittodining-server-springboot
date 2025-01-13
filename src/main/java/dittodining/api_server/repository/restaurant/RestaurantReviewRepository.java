package dittodining.api_server.repository.restaurant;

import dittodining.api_server.domain.restaurant.RestaurantReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantReviewRepository extends JpaRepository<RestaurantReview, Long> {
}
