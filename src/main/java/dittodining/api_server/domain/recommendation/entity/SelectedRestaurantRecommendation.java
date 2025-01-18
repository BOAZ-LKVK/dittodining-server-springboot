package dittodining.api_server.domain.recommendation.entity;

import dittodining.api_server.common.entity.BaseTimeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
@Table(indexes = {
        @Index(name = "idx_user_selected_restaurant_recommendation_m1", columnList = "created_at"),
        @Index(name = "idx_user_selected_restaurant_recommendation_m2", columnList = "updated_at"),
        @Index(name = "idx_user_selected_restaurant_recommendation_m3", columnList = "restaurant_recommendation_request_id"),
        @Index(name = "idx_user_selected_restaurant_recommendation_m4", columnList = "restaurant_recommendation_id"),
        @Index(name = "idx_user_selected_restaurant_recommendation_m5", columnList = "restaurant_id"),
})
public class SelectedRestaurantRecommendation extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment(value = "선택된 음식점 추천 ID")
    private Long selectedRestaurantRecommendationId;

    @NotNull
    @Comment(value = "음식점 추천 요청 ID")
    private Long restaurantRecommendationRequestId;

    @NotNull
    @Comment(value = "음식점 추천 ID")
    private Long restaurantRecommendationId;

    @NotNull
    @Comment(value = "음식점 ID")
    private Long restaurantId;

    @Builder
    public SelectedRestaurantRecommendation(Long restaurantRecommendationRequestId, Long restaurantRecommendationId, Long restaurantId) {
        this.restaurantRecommendationRequestId = restaurantRecommendationRequestId;
        this.restaurantRecommendationId = restaurantRecommendationId;
        this.restaurantId = restaurantId;
    }
}
