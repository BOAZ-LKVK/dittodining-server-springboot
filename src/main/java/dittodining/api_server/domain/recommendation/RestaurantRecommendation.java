package dittodining.api_server.domain.recommendation;

import dittodining.api_server.domain.BaseTimeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Comment;

import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
@Table(indexes = {
        @Index(name = "idx_restaurant_recommendation_m1", columnList = "created_at"),
        @Index(name = "idx_restaurant_recommendation_m2", columnList = "updated_at"),
        @Index(name = "idx_restaurant_recommendation_m3", columnList = "restaurant_recommendation_request_id"),
        @Index(name = "idx_restaurant_recommendation_m4", columnList = "restaurant_id")
})
public class RestaurantRecommendation extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_recommendation_id")
    @Comment(value = "음식점 추천 ID")
    private Long id;

    @NotNull
    @Column(name = "restaurant_recommendation_request_id")
    @Comment(value = "음식점 추천 요청 ID")
    private Long requestId;

    @NotNull
    @Comment(value = "음식점 ID")
    private Long restaurantId;

    @NotNull
    @Column(precision = 11, scale = 2)
    @Comment(value = "미터 단위 거리")
    private BigDecimal distanceInMeters;

    public RestaurantRecommendation(Long requestId, Long restaurantId, BigDecimal distanceInMeters) {
        this.requestId = requestId;
        this.restaurantId = restaurantId;
        this.distanceInMeters = distanceInMeters;
    }
}
