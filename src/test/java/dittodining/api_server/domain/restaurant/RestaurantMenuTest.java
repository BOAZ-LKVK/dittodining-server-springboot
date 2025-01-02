package dittodining.api_server.domain.restaurant;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class RestaurantMenuTest {
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
}