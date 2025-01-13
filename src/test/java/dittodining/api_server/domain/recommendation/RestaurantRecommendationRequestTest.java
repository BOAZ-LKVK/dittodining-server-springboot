package dittodining.api_server.domain.recommendation;

import dittodining.api_server.repository.recommendation.RestaurantRecommendationRequestRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class RestaurantRecommendationRequestTest {
    @Autowired
    private RestaurantRecommendationRequestRepository restaurantRecommendationRequestRepository;

    @Autowired
    private EntityManager em;

    @Test
    public void getRestaurantRecommendationRequest() {
        List<RestaurantRecommendationRequest> res = em.createQuery(
                "SELECT rrr FROM RestaurantRecommendationRequest rrr", RestaurantRecommendationRequest.class
        ).getResultList();
        System.out.println(res.size());
        System.out.println(res.get(0));
    }

    @Test
    public void mockInsert() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        RestaurantRecommendationRequest restaurantRecommendationRequest = new RestaurantRecommendationRequest(
                null,
                new UserLocation(new BigDecimal("37.49648606"), new BigDecimal("127.02836155")),
                LocalDateTime.parse("2024-09-20 11:13:58", formatter)
        );

        restaurantRecommendationRequestRepository.save(restaurantRecommendationRequest);

        RestaurantRecommendationRequest findRestaurantRecommendationRequest = restaurantRecommendationRequestRepository.findById(restaurantRecommendationRequest.getId()).get();
        assertEquals(restaurantRecommendationRequest, findRestaurantRecommendationRequest);
        System.out.println(findRestaurantRecommendationRequest);
    }
}