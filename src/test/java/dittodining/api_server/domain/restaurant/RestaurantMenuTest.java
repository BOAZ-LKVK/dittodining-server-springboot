package dittodining.api_server.domain.restaurant;

import dittodining.api_server.repository.restaurant.RestaurantMenuRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
@Rollback(value = false)
class RestaurantMenuTest {
    @Autowired
    private RestaurantMenuRepository restaurantMenuRepository;

    @Autowired
    EntityManager em;

    @Test
    public void getAll(){
        RestaurantMenu restaurantMenu = em.createQuery(
                "SELECT rm FROM RestaurantMenu rm",
                RestaurantMenu.class
                ).getResultList().get(0);
        System.out.println(restaurantMenu);
    }

    @Test
    public void mockInsert() {
        RestaurantMenu restaurantMenu = new RestaurantMenu(
                1L,
                "점심특선",
                new BigDecimal("40000.00"),
                null,
                null
        );

        restaurantMenuRepository.save(restaurantMenu);

        RestaurantMenu findRestaurantMenu = restaurantMenuRepository.findById(restaurantMenu.getId()).get();
        assertEquals(restaurantMenu, findRestaurantMenu);
    }
}