package dittodining.api_server.domain.restaurant.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Builder
@ToString
public class RestaurantReviewStatistics {
    private RestaurantReviewKakaoStatistics kakao;
    private RestaurantReviewNaverStatistics naver;
}
