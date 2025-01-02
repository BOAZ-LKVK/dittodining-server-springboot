package dittodining.api_server.domain.restaurant;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestaurantImageTest {
    @Autowired
    private EntityManager em;

    @Test
    public void getAll() {
        RestaurantImage restaurantImage = em.createQuery(
                "SELECT ri FROM RestaurantImage ri", RestaurantImage.class
        ).getResultList().get(0);
        System.out.println(restaurantImage);
    }
}