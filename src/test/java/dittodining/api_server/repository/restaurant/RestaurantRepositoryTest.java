package dittodining.api_server.repository.restaurant;

import dittodining.api_server.domain.restaurant.Restaurant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class RestaurantRepositoryTest {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Test
    public void getAll() {
        Restaurant restaurant = restaurantRepository.findAll().get(0);
        System.out.println(restaurant);
        System.out.println(restaurant.getCreatedAt());
        System.out.println(restaurant.getUpdatedAt());
    }
}