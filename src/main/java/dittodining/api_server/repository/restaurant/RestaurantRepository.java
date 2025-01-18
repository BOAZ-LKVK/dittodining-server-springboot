package dittodining.api_server.repository.restaurant;

import dittodining.api_server.domain.restaurant.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>, CustomizedRestaurantRepository {
    // where x.id in ?1
    List<Restaurant> findByRestaurantIdIn(List<Long> ids);
}
