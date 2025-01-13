package dittodining.api_server.repository.restaurant;

import dittodining.api_server.domain.restaurant.RestaurantMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantMenuRepository extends JpaRepository<RestaurantMenu, Long> {
}
