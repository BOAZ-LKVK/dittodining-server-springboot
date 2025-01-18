package dittodining.api_server.domain.restaurant;

import dittodining.api_server.repository.restaurant.RestaurantImageRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class RestaurantImageTest {
    @Autowired
    private RestaurantImageRepository restaurantImageRepository;

    @Autowired
    private EntityManager em;

    @Test
    public void getAll() {
        RestaurantImage restaurantImage = em.createQuery(
                "SELECT ri FROM RestaurantImage ri", RestaurantImage.class
        ).getResultList().get(0);
        System.out.println(restaurantImage);
    }

    @Test
    public void mockInsert() {
        RestaurantImage restaurantImage = new RestaurantImage(
                1L,
                "https://pup-review-phinf.pstatic.net/MjAyNDA5MTBfMTMz/MDAxNzI1OTcxNTkyMDAz.rF3qTYh7tYVJsU6t4s_ZD27Px3syzXgQ7ikpuYVe4BMg.LcorDDlrQxLRKuSF4vElpzsiFuFJbu0riPicmWgsrg4g.JPEG/1000008970.jpg.jpg?type=w278_sharpen"
        );
        restaurantImageRepository.save(restaurantImage);

        RestaurantImage findRestaurantImage = restaurantImageRepository.findById(restaurantImage.getRestaurantImageId()).get();

        assertEquals(restaurantImage, findRestaurantImage);
    }
}