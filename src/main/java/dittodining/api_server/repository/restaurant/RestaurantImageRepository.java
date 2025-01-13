package dittodining.api_server.repository.restaurant;

import dittodining.api_server.domain.restaurant.RestaurantImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantImageRepository extends JpaRepository<RestaurantImage, Long> {

    List<RestaurantImage> findByRestaurantId(Long restaurantId);

    List<RestaurantImage> fndByRestaurantIdIn(List<Long> restaurantIds);
}
