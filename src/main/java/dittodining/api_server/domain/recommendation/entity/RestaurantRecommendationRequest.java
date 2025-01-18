package dittodining.api_server.domain.recommendation.entity;

import dittodining.api_server.common.entity.BaseTimeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
@Table(indexes = {
        @Index(name = "idx_restaurant_recommendation_request_m1", columnList = "created_at"),
        @Index(name = "idx_restaurant_recommendation_request_m2", columnList = "updated_at"),
        @Index(name = "idx_restaurant_recommendation_request_m3", columnList = "user_id")
})
public class RestaurantRecommendationRequest extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment(value = "음식점 추천 요청 ID")
    private Long restaurantRecommendationRequestId;

    @Comment(value = "사용자 ID")
    private Long userId;

    @Embedded
    private UserLocation userLocation;

    @NotNull
    @Comment(value = "요청 시간")
    private LocalDateTime requested_at;

    @Builder
    public RestaurantRecommendationRequest(Long userId, UserLocation userLocation, LocalDateTime requested_at) {
        this.userId = userId;
        this.userLocation = userLocation;
        this.requested_at = requested_at;
    }
}
