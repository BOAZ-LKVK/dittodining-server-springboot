package dittodining.api_server.domain;

import dittodining.api_server.domain.restaurant.Restaurant;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class RestaurantTest {
    @Autowired
    private EntityManager em;

    @Test
    public void healthCheck(){
//        Restaurant restaurant = new Restaurant(
//                "일품진진수라 강남점",
//                "서울 서초구 서초대로 254 지하2층",
//                "[\"\"가족외식\"\", \"\"상견례\"\",\"\"조용한\"\", \"\"격식있는\"\", \"\"점심식사\"\", \"\"저녁식사\"\", \"\"개별룸\"\", \"\"무료주차\"\", \"\"배달\"\"]\"",
//                130000.00,
//                19900.00,
//                37.49199660,
//                127.00979130,
//                "[{""openTime"": ""11:00"", ""closingTime"": ""21:30"", ""isClosedDay"": false, ""breakEndTime"": ""17:00"", ""dayOfWeekEnum"": ""DAY_OF_WEEK_WEDNESDAY"", ""lastOrderTime"": ""20:30"", ""breakStartTime"": ""15:00""}, {""openTime"": ""11:00"", ""closingTime"": ""21:30"", ""isClosedDay"": false, ""breakEndTime"": ""17:00"", ""dayOfWeekEnum"": ""DAY_OF_WEEK_THURSDAY"", ""lastOrderTime"": ""20:30"", ""breakStartTime"": ""15:00""}, {""openTime"": ""11:00"", ""closingTime"": ""21:30"", ""isClosedDay"": false, ""breakEndTime"": ""17:00"", ""dayOfWeekEnum"": ""DAY_OF_WEEK_FRIDAY"", ""lastOrderTime"": ""20:30"", ""breakStartTime"": ""15:00""}, {""openTime"": ""11:00"", ""closingTime"": ""21:30"", ""isClosedDay"": false, ""breakEndTime"": ""17:00"", ""dayOfWeekEnum"": ""DAY_OF_WEEK_SATURDAY"", ""lastOrderTime"": ""20:30"", ""breakStartTime"": ""15:00""}, {""openTime"": ""11:00"", ""closingTime"": ""21:30"", ""isClosedDay"": false, ""breakEndTime"": ""17:00"", ""dayOfWeekEnum"": ""DAY_OF_WEEK_SUNDAY"", ""lastOrderTime"": ""20:30"", ""breakStartTime"": ""15:00""}, {""openTime"": ""11:00"", ""closingTime"": ""21:30"", ""isClosedDay"": false, ""breakEndTime"": ""17:00"", ""dayOfWeekEnum"": ""DAY_OF_WEEK_MONDAY"", ""lastOrderTime"": ""20:30"", ""breakStartTime"": ""15:00""}, {""openTime"": ""11:00"", ""closingTime"": ""21:30"", ""isClosedDay"": false, ""breakEndTime"": ""17:00"", ""dayOfWeekEnum"": ""DAY_OF_WEEK_TUESDAY"", ""lastOrderTime"": ""20:30"", ""breakStartTime"": ""15:00""}]"
//        );
//        em.persist(restaurant);
//
//        Restaurant findRestaurant = em.find(Restaurant.class, restaurant.getId());
//        assertEquals(restaurant, findRestaurant);
//        System.out.println(org.hibernate.Version.getVersionString());
    }
    /*
    ",,,4.05,4.44,842,3.20,19,863,2024-10-14 05:39:08,2024-10-14 05:39:08,4.50,2,0507-1394-3112

     */
}