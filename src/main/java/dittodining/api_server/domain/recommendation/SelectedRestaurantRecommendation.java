package dittodining.api_server.domain.recommendation;

import dittodining.api_server.domain.BaseTimeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
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
    @Column(name = "selected_restaurant_recommendation_id")
    @Comment(value = "선택된 음식점 추천 ID")
    private Long id;

    @NotNull
    @Column(name = "restaurant_recommendation_request_id")
    @Comment(value = "음식점 추천 요청 ID")
    private Long requestId;

    @NotNull
    @Column(name = "restaurant_recommendation_id")
    @Comment(value = "음식점 추천 ID")
    private Long recommendationId;

    @NotNull
    @Comment(value = "음식점 ID")
    private Long restaurantId;

    public SelectedRestaurantRecommendation(Long requestId, Long recommendationId, Long restaurantId) {
        this.requestId = requestId;
        this.recommendationId = recommendationId;
        this.restaurantId = restaurantId;
    }
}
