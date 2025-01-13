package dittodining.api_server.domain.restaurant;

import dittodining.api_server.repository.restaurant.RestaurantRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
@Rollback(value = true)
class RestaurantTest {
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private EntityManager em;

    @Test
    public void healthCheck(){
        List<BusinessHour> businessHours = List.of(
                new BusinessHour(DayOfWeek.DAY_OF_WEEK_WEDNESDAY, "11:00", "21:30", "15:00", "17:00", "20:30", false),
                new BusinessHour(DayOfWeek.DAY_OF_WEEK_THURSDAY, "11:00", "21:30", "15:00", "17:00", "20:30", false),
                new BusinessHour(DayOfWeek.DAY_OF_WEEK_FRIDAY, "11:00", "21:30", "15:00", "17:00", "20:30", false),
                new BusinessHour(DayOfWeek.DAY_OF_WEEK_SATURDAY, "11:00", "21:30", "15:00", "17:00", "20:30", false),
                new BusinessHour(DayOfWeek.DAY_OF_WEEK_SUNDAY, "11:00", "21:30", "15:00", "17:00", "20:30", false),
                new BusinessHour(DayOfWeek.DAY_OF_WEEK_MONDAY, "11:00", "21:30", "15:00", "17:00", "20:30", false),
                new BusinessHour(DayOfWeek.DAY_OF_WEEK_TUESDAY, "11:00", "21:30", "15:00", "17:00", "20:30", false)
        );
        Restaurant restaurant = new Restaurant(
                "일품진진수라 강남점",
                "서울 서초구 서초대로 254 지하2층",
                "[가족외식, 상견례,조용한, 격식있는, 점심식사, 저녁식사, 개별룸, 무료주차, 배달]",
                new BigDecimal("130000.00"),
                new BigDecimal("19900.00"),
                new BigDecimal("37.49199660"),
                new BigDecimal("127.00979130"),
                businessHours,
                new BigDecimal("4.05"),
                new BigDecimal("4.44"),
                842L,
                new BigDecimal("3.20"),
                19L,
                863L
        );
        restaurantRepository.save(restaurant);

        Restaurant findRestaurant = restaurantRepository.findById(restaurant.getId()).get();
        assertEquals(restaurant, findRestaurant);
        System.out.println(org.hibernate.Version.getVersionString());
    }
}