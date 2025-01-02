package dittodining.api_server.domain.restaurant;

import dittodining.api_server.domain.BaseTimeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Comment;

@Entity @ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(indexes = {
        @Index(name = "idx_restaurant_image_m1", columnList = "created_at"),
        @Index(name = "idx_restaurant_image_m2", columnList = "updated_at"),
        @Index(name = "idx_restaurant_image_m3", columnList = "restaurant_id")
})
public class RestaurantImage extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment(value = "음식점 이미지 ID")
    @Column(name = "restaurant_image_id")
    private Long id;

    @Comment(value = "음식점 ID") // 왜 DDL 에는 PK를 넣지 않았지?
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "restaurant_id")
    private Long restaurantId;

    @Size(max = 1024)
    @Comment(value = "이미지 URL")
    private String imageUrl;

    public RestaurantImage(Long restaurantId, String imageUrl) {
        this.restaurantId = restaurantId;
        this.imageUrl = imageUrl;
    }
}
