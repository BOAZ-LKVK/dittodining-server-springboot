package dittodining.api_server.domain;

import dittodining.api_server.domain.restaurant.Restaurant;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class RestaurantTest {
    @Autowired
    private EntityManager em;

    @Test
    public void healthCheck(){
        Restaurant restaurant = new Restaurant();
        em.persist(restaurant);

        Restaurant findRestaurant = em.find(Restaurant.class, restaurant.getId());
        assertEquals(restaurant, findRestaurant);
        System.out.println(org.hibernate.Version.getVersionString());
    }
}