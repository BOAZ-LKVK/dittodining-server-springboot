package dittodining.api_server.service.restaurant;

import dittodining.api_server.domain.restaurant.BusinessHour;
import dittodining.api_server.domain.restaurant.DayOfWeek;
import dittodining.api_server.domain.restaurant.Restaurant;
import dittodining.api_server.domain.restaurant.RestaurantImage;
import dittodining.api_server.repository.restaurant.RestaurantImageRepository;
import dittodining.api_server.repository.restaurant.RestaurantRepository;
import dittodining.api_server.service.restaurant.model.RestaurantModel;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RestaurantServiceTest {

    @Mock
    private RestaurantRepository restaurantRepository;

    @Mock
    private RestaurantImageRepository restaurantImageRepository;

    @InjectMocks
    private RestaurantService restaurantService;

    private Restaurant restaurant;
    private RestaurantImage restaurantImage;

    @BeforeEach
    void setUp() {
        // 객체를 stub 으로 생성하는 방식
        // stub 은 메소드 호출을 검증하지 않기 때문에 객체의 동작과 상호작용을 검증하지 못한다.
        List<BusinessHour> businessHours = List.of(
                new BusinessHour(DayOfWeek.DAY_OF_WEEK_WEDNESDAY, "11:00", "21:30", "15:00", "17:00", "20:30", false),
                new BusinessHour(DayOfWeek.DAY_OF_WEEK_THURSDAY, "11:00", "21:30", "15:00", "17:00", "20:30", false),
                new BusinessHour(DayOfWeek.DAY_OF_WEEK_FRIDAY, "11:00", "21:30", "15:00", "17:00", "20:30", false),
                new BusinessHour(DayOfWeek.DAY_OF_WEEK_SATURDAY, "11:00", "21:30", "15:00", "17:00", "20:30", false),
                new BusinessHour(DayOfWeek.DAY_OF_WEEK_SUNDAY, "11:00", "21:30", "15:00", "17:00", "20:30", false),
                new BusinessHour(DayOfWeek.DAY_OF_WEEK_MONDAY, "11:00", "21:30", "15:00", "17:00", "20:30", false),
                new BusinessHour(DayOfWeek.DAY_OF_WEEK_TUESDAY, "11:00", "21:30", "15:00", "17:00", "20:30", false)
        );
        restaurant = Restaurant.builder()
                .name("일품진진수라 강남점")
                .address("서울 서초구 서초대로 254 지하2층")
                .description("[가족외식, 상견례,조용한, 격식있는, 점심식사, 저녁식사, 개별룸, 무료주차, 배달]")
                .maximumPricePerPerson(new BigDecimal("130000.00"))
                .minimumPricePerPerson(new BigDecimal("19900.00"))
                .latitude(new BigDecimal("37.49199660"))
                .longitude(new BigDecimal("127.00979130"))
                .businessHours(businessHours)
                .recommendationScore(new BigDecimal("4.05"))
                .naverAvgScore(new BigDecimal("4.44"))
                .naverTotalReviewCount(842L)
                .kakaoAvgScore(new BigDecimal("3.20"))
                .kakaoTotalReviewCount(19L)
                .totalReviewCount(863L)
                .build();
        restaurantImage = RestaurantImage.builder()
                .restaurantId(1L)
                .imageUrl("https://pup-review-phinf.pstatic.net/MjAyNDA5MTBfMTMz/MDAxNzI1OTcxNTkyMDAz.rF3qTYh7tYVJsU6t4s_ZD27Px3syzXgQ7ikpuYVe4BMg.LcorDDlrQxLRKuSF4vElpzsiFuFJbu0riPicmWgsrg4g.JPEG/1000008970.jpg.jpg?type=w278_sharpen")
                .build();
    }

    @Test
    @DisplayName("레스토랑 정보 조회 성공 테스트")
    public void getRestaurantTest() {
        //given
        when(restaurantRepository.findById(restaurant.getRestaurantId()))
                .thenReturn(Optional.of(restaurant));
        when(restaurantImageRepository.findByRestaurantId(restaurant.getRestaurantId()))
                .thenReturn(List.of(restaurantImage));

        // when
        RestaurantModel restaurantModel = restaurantService.getRestaurant(restaurant.getRestaurantId());

        // then
        assertNotNull(restaurantModel);
        assertEquals(restaurant.getRestaurantId(), restaurantModel.getRestaurantId());
        assertEquals(restaurant.getName(), restaurantModel.getRestaurantName());
        assertEquals(restaurant.getAddress(), restaurantModel.getRestaurantAddress());
        assertEquals(restaurant.getDescription(), restaurantModel.getDescription());
        assertEquals(1, restaurantModel.getRestaurantImageURLs().size());
        assertEquals(restaurantImage.getImageUrl(), restaurantModel.getRestaurantImageURLs().getFirst());

        verify(restaurantRepository).findById(restaurant.getRestaurantId());
        verify(restaurantImageRepository).findByRestaurantId(restaurant.getRestaurantId());
    }

    @Test
    @DisplayName("존재하지 않는 레스토랑 조회 예외 발생 테스트")
    public void getRestaurant_WhenNotFound_ExceptionTest(){
        // given
        Long restaurantId = -1L;
        when(restaurantRepository.findById(restaurantId))
                .thenReturn(Optional.empty());

        // when & then
        assertThrows(EntityNotFoundException.class, () ->
                restaurantService.getRestaurant(restaurantId)
        );
    }

    @Test
    @DisplayName("레스토랑 이미지가 없는 경우 예외 발생 테스트")
    public void getRestaurant_WhenNoImages_ExceptionTest(){
        //given
        when(restaurantRepository.findById(restaurant.getRestaurantId()))
                .thenReturn(Optional.of(restaurant));
        when(restaurantImageRepository.findByRestaurantId(restaurant.getRestaurantId()))
                .thenReturn(List.of()); // empty list

        // when & then
        assertThrows(EntityNotFoundException.class, () ->
                restaurantService.getRestaurant(restaurant.getRestaurantId())
        );
    }
}