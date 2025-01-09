package dittodining.api_server.domain.recommendation;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestaurantRecommendationTest {

    @Autowired
    private EntityManager em;

    @Test
    public void getRestaurantRecommendation() {
        List<RestaurantRecommendation> res = em.createQuery(
                "SELECT rr FROM RestaurantRecommendation rr", RestaurantRecommendation.class
        ).getResultList();
        System.out.println(res.size());
        for(int i = 0; i < 5; i++){
            System.out.println(res.get(i));
        }
    }
}