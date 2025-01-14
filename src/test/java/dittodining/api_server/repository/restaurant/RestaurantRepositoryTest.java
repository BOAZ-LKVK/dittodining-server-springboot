package dittodining.api_server.repository.restaurant;

import com.querydsl.core.Tuple;
import dittodining.api_server.domain.recommendation.UserLocation;
import dittodining.api_server.domain.restaurant.Restaurant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class RestaurantRepositoryTest {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Test
    public void getAll() {
        Restaurant restaurant = restaurantRepository.findAll().getFirst();
        System.out.println(restaurant);
        System.out.println(restaurant.getCreatedAt());
        System.out.println(restaurant.getUpdatedAt());
    }

    @Test
    public void getByIdList() {
        List<Restaurant> restaurants = restaurantRepository.findByIdIn(List.of(
                1L, 2L, 3L
        ));
        assertEquals(3, restaurants.size());
        assertEquals(1L, restaurants.get(0).getId());
        assertEquals(2L, restaurants.get(1).getId());
        assertEquals(3L, restaurants.get(2).getId());
    }

    @Test
    public void findNearbyAllOrderByRecommendationScoreDescTest() {
        List<Tuple> res = restaurantRepository.findNearbyAllOrderByRecommendationScoreDesc(
                new UserLocation(new BigDecimal("37.49199660"), new BigDecimal("127.00979130")),
                10L,
                10L,
                5L
        );
        System.out.println("size = " + res.size());
    }
}