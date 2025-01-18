package dittodining.api_server.domain.restaurant;

import dittodining.api_server.domain.BaseTimeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.math.BigDecimal;

@Entity
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Table(indexes = {
        @Index(name = "idx_restaurant_menu_m1", columnList = "created_at"),
        @Index(name = "idx_restaurant_menu_m2", columnList = "updated_at"),
        @Index(name = "idx_restaurant_menu_m3", columnList = "restaurant_id")
})
public class RestaurantMenu extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantMenuId;

    @NotNull
    @Comment(value = "음식점 ID")
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "restaurant_id")
    private Long restaurantId;

    @NotNull
    @Size(max = 255)
    @Comment(value = "메뉴 이름")
    private String name;

    @NotNull
    @Column(precision = 11, scale = 2)
    @Comment(value = "메뉴 가격")
    private BigDecimal price;

    @Lob
    @Comment(value = "메뉴 설명")
    private String description;

    @Size(max = 1024)
    @Comment(value = "이미지 URL")
    //@OneToOne 메핑을 하면 더 좋지 않을까?
    private String imageUrl;

    @Builder
    public RestaurantMenu(
            Long restaurantId,
            String name,
            BigDecimal price,
            String description,
            String imageUrl
    ) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
    }
}
