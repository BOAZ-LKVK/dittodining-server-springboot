package dittodining.api_server.repository.restaurant;

import dittodining.api_server.domain.restaurant.RestaurantImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantImageRepository extends JpaRepository<RestaurantImage, Long> {
}
