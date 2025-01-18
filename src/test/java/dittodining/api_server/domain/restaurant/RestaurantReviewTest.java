package dittodining.api_server.domain.restaurant;

import dittodining.api_server.repository.restaurant.RestaurantReviewRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class RestaurantReviewTest {
    @Autowired
    private RestaurantReviewRepository restaurantReviewRepository;

    @Autowired
    private EntityManager em;

    @Test
    public void getAll(){
        RestaurantReview restaurantReview = em.createQuery(
                "SELECT rv FROM RestaurantReview rv",
                RestaurantReview.class
        ).getResultList().getFirst();
        System.out.println(restaurantReview);
    }

    @Test
    public void mockInsert() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        RestaurantReview restaurantReview = new RestaurantReview(
                1L,
                "jisung",
                new BigDecimal("5.00"),
                "근처 다른 한정식집과 비교해봤을때 가격대비 그저 그랬습니다.",
                LocalDateTime.parse("2024-02-13 00:00:00", formatter)
        );

        restaurantReviewRepository.save(restaurantReview);
        RestaurantReview findRestaurantReview = restaurantReviewRepository.findById(restaurantReview.getRestaurantReviewId()).get();
        assertEquals(restaurantReview, findRestaurantReview);
        System.out.println(findRestaurantReview);
    }
}