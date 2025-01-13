package dittodining.api_server.repository.restaurant;

import dittodining.api_server.domain.restaurant.RestaurantMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantMenuRepository extends JpaRepository<RestaurantMenu, Long> {

    List<RestaurantMenu> findByRestaurantId(Long restaurantId);

    List<RestaurantMenu> findByRestaurantIdIn(List<Long> restaurantIds);
}
