package dittodining.api_server.domain.restaurant;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestaurantReviewTest {
    @Autowired
    EntityManager em;

    @Test
    public void getAll(){
        RestaurantReview restaurantReview = em.createQuery(
                "SELECT rv FROM RestaurantReview rv",
                RestaurantReview.class
        ).getResultList().get(0);
        System.out.println(restaurantReview);
    }
}