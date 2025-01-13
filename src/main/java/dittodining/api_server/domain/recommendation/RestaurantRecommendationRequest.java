package dittodining.api_server.domain.recommendation;

import dittodining.api_server.domain.BaseTimeEntity;
import jakarta.persistence.*;
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
        @Index(name = "idx_restaurant_recommendation_request_m1", columnList = "created_at"),
        @Index(name = "idx_restaurant_recommendation_request_m2", columnList = "updated_at"),
        @Index(name = "idx_restaurant_recommendation_request_m3", columnList = "user_id")
})
public class RestaurantRecommendationRequest extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_recommendation_request_id")
    @Comment(value = "음식점 추천 요청 ID")
    private Long id;

    @Comment(value = "사용자 ID")
    private Long userId;

    @Embedded
    private UserLocation userLocation;
}
