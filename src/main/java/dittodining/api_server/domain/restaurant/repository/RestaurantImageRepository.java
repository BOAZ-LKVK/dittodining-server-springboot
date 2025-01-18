package dittodining.api_server.domain.restaurant.repository;

import dittodining.api_server.domain.restaurant.entity.RestaurantImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantImageRepository extends JpaRepository<RestaurantImage, Long> {

    List<RestaurantImage> findByRestaurantId(Long restaurantId);

    List<RestaurantImage> findByRestaurantIdIn(List<Long> restaurantIds);
}
