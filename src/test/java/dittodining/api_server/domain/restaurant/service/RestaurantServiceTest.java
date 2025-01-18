package dittodining.api_server.domain.restaurant.service;

import dittodining.api_server.domain.restaurant.entity.*;
import dittodining.api_server.domain.restaurant.repository.RestaurantImageRepository;
import dittodining.api_server.domain.restaurant.repository.RestaurantMenuRepository;
import dittodining.api_server.domain.restaurant.repository.RestaurantRepository;
import dittodining.api_server.domain.restaurant.repository.RestaurantReviewRepository;
import dittodining.api_server.domain.restaurant.model.RestaurantMenuModel;
import dittodining.api_server.domain.restaurant.model.RestaurantModel;
import dittodining.api_server.domain.restaurant.model.RestaurantReviewModel;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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

    @Mock
    private RestaurantMenuRepository restaurantMenuRepository;

    @Mock
    private RestaurantReviewRepository restaurantReviewRepository;

    @InjectMocks
    private RestaurantService restaurantService;

    // Stub
    private Restaurant restaurant;
    private RestaurantImage restaurantImage;
    private RestaurantMenu restaurantMenu;
    private RestaurantReview restaurantReview;

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
                .restaurantId(restaurant.getRestaurantId())
                .imageUrl("https://pup-review-phinf.pstatic.net/MjAyNDA5MTBfMTMz/MDAxNzI1OTcxNTkyMDAz.rF3qTYh7tYVJsU6t4s_ZD27Px3syzXgQ7ikpuYVe4BMg.LcorDDlrQxLRKuSF4vElpzsiFuFJbu0riPicmWgsrg4g.JPEG/1000008970.jpg.jpg?type=w278_sharpen")
                .build();

        restaurantMenu = RestaurantMenu.builder()
                .restaurantId(restaurant.getRestaurantId())
                .name("채식상 1")
                .price(BigDecimal.valueOf(53000.00))
                .description("")
                .imageUrl("https://search.pstatic.net/common/?autoRotate=true&quality=95&type=f320_320&src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20221230_132%2F1672359922686QGgfm_JPEG%2F%25C1%25A6%25B8%25F1_%25BE%25F8%25C0%25BD111.jpg")
                .build();

        restaurantReview = RestaurantReview.builder()
                .restaurantId(restaurant.getRestaurantId())
                .writerName("jisung")
                .score(BigDecimal.valueOf(5.00))
                .content(null)
                .wroteAt(LocalDateTime.of(2024, 2, 13, 0, 0, 0))
                .build();
    }

    @Test
    @DisplayName("Successful Restaurant Information Retrieval Test")
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
    @DisplayName("Exception Test for Non-Existent Restaurant Retrieval")
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
    @DisplayName("Exception Test When Restaurant Has No Images")
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

    @Test
    @DisplayName("Successful Restaurant Menu List Retrieval Test")
    public void getRestaurantMenuList() {
        //given
        when(restaurantMenuRepository.findByRestaurantId(restaurant.getRestaurantId()))
                .thenReturn(List.of(restaurantMenu));
        //when
        List<RestaurantMenuModel> restaurantMenuList = restaurantService.getRestaurantMenuList(restaurant.getRestaurantId());

        //then
        assertNotEquals(restaurantMenuList.size(), 0);
        assertEquals(restaurantMenuList.getFirst().getRestaurantMenuId(), restaurantMenu.getRestaurantId());
        assertEquals(restaurantMenuList.getFirst().getImageURL(), restaurantMenu.getImageUrl());
        assertEquals(restaurantMenuList.getFirst().getName(), restaurantMenu.getName());
        assertEquals(restaurantMenuList.getFirst().getPrice(), restaurantMenu.getPrice());
        assertEquals(restaurantMenuList.getFirst().getDescription(), restaurantMenu.getDescription());

        // verify
        verify(restaurantMenuRepository).findByRestaurantId(restaurant.getRestaurantId());
    }

    @Test
    @DisplayName("Exception Case When Restaurant Has No Menus")
    public void getRestaurantMenuList_WhenNotFound_ExceptionTest(){
        //given
        Long restaurantId = -1L;
        when(restaurantMenuRepository.findByRestaurantId(restaurantId))
                .thenReturn(List.of());

        //when & then
        assertThrows(EntityNotFoundException.class,
                () -> restaurantService.getRestaurantMenuList(restaurantId)
        );
    }

    @Test
    @DisplayName("Restaurant Review List Retrieval Test")
    public void getRestaurantReviewTest() {
        //given
        when(restaurantRepository.findById(restaurant.getRestaurantId()))
                .thenReturn(Optional.of(restaurant));
        when(restaurantReviewRepository.findByRestaurantId(restaurant.getRestaurantId()))
                .thenReturn(List.of(restaurantReview));

        // when
        RestaurantReviewModel restaurantReviewModel = restaurantService.getRestaurantReview(restaurant.getRestaurantId());

        // then
        assertNotNull(restaurantReviewModel);
        assertNotNull(restaurantReviewModel.getStatistics());
        assertNotNull(restaurantReviewModel.getTotalCount());
        assertNotEquals(restaurantReviewModel.getReviews().size(), 0);

        assertEquals(restaurantReviewModel.getStatistics().getKakao().getAverageScore(), restaurant.getKakaoAvgScore());
        assertEquals(restaurantReviewModel.getStatistics().getKakao().getCount(), restaurant.getKakaoTotalReviewCount());
        assertEquals(restaurantReviewModel.getStatistics().getNaver().getAverageScore(), restaurant.getNaverAvgScore());
        assertEquals(restaurantReviewModel.getStatistics().getNaver().getCount(), restaurant.getNaverTotalReviewCount());

        assertEquals(restaurantReviewModel.getReviews().getFirst().getRestaurantReviewId(), restaurantReview.getRestaurantReviewId());
        assertEquals(restaurantReviewModel.getReviews().getFirst().getWriterName(), restaurantReview.getWriterName());
        assertEquals(restaurantReviewModel.getReviews().getFirst().getScore(), restaurantReview.getScore());
        assertEquals(restaurantReviewModel.getReviews().getFirst().getContent(), restaurantReview.getContent());
        assertEquals(restaurantReviewModel.getReviews().getFirst().getWroteAt(), restaurantReview.getWroteAt());

        assertEquals(restaurantReviewModel.getTotalCount(), restaurant.getTotalReviewCount());
    }

    @Test
    @DisplayName("Exception Test for Non-Existent Restaurant Retrieval")
    public void getRestaurantReview_WhenNotFound_ExceptionTest(){
        // given
        Long restaurantId = -1L;
        when(restaurantRepository.findById(restaurantId))
                .thenReturn(Optional.empty());

        // when & then
        assertThrows(EntityNotFoundException.class, () ->
                restaurantService.getRestaurantReview(restaurantId)
        );
    }

    @Test
    @DisplayName("Exception Test for Non-Existent Review Retrieval")
    public void getRestaurantReview_WhenNoReviews_ExceptionTest(){
        //given
        when(restaurantRepository.findById(restaurant.getRestaurantId()))
                .thenReturn(Optional.of(restaurant));
        when(restaurantReviewRepository.findByRestaurantId(restaurant.getRestaurantId()))
                .thenReturn(List.of());

        //when & then
        assertThrows(EntityNotFoundException.class, () ->
                restaurantService.getRestaurantReview(restaurant.getRestaurantId())
        );
    }
}