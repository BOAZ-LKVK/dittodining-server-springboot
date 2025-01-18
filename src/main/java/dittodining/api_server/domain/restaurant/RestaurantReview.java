package dittodining.api_server.domain.restaurant;

import dittodining.api_server.domain.BaseTimeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Table(indexes = {
        @Index(name = "idx_restaurant_menu_m1", columnList = "created_at"),
        @Index(name = "idx_restaurant_menu_m2", columnList = "updated_at"),
        @Index(name = "idx_restaurant_menu_m3", columnList = "restaurant_id")
})
public class RestaurantReview extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantReviewId;

    @NotNull
    @Comment(value = "음식점 ID")
    private Long restaurantId;

    @NotNull
    @Size(max = 255)
    @Comment(value = "작성자 이름")
    private String writerName;

    @Column(precision = 5, scale = 2)
    @Comment(value = "평점")
    private BigDecimal score;

    @Lob
    @Comment(value = "내용")
    private String content;

    @NotNull
    @Comment(value = "작성 일시")
    private LocalDateTime wroteAt;

    @Builder
    public RestaurantReview(
            Long restaurantId,
            String writerName,
            BigDecimal score,
            String content,
            LocalDateTime wroteAt
    ) {
        this.restaurantId = restaurantId;
        this.writerName = writerName;
        this.score = score;
        this.content = content;
        this.wroteAt = wroteAt;
    }
}
