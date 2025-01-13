package dittodining.api_server.domain.recommendation;

import dittodining.api_server.repository.recommendation.RestaurantRecommendationRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class RestaurantRecommendationTest {
    @Autowired
    private RestaurantRecommendationRepository restaurantRecommendationRepository;

    @Autowired
    private EntityManager em;

    @Test
    public void getRestaurantRecommendation() {
        List<RestaurantRecommendation> res = em.createQuery(
                "SELECT rr FROM RestaurantRecommendation rr", RestaurantRecommendation.class
        ).getResultList();
        System.out.println(res.size());
        System.out.println(res.get(0));
    }

    @Test
    public void mockInsert() {
        RestaurantRecommendation restaurantRecommendation = new RestaurantRecommendation(
                2L,
                190L,
                new BigDecimal("3176.82")
        );

        restaurantRecommendationRepository.save(restaurantRecommendation);

        RestaurantRecommendation findRestaurantRecommendation = restaurantRecommendationRepository.findById(2L).get();
        assertEquals(restaurantRecommendation, findRestaurantRecommendation);
        System.out.println(findRestaurantRecommendation);
    }
}