package dittodining.api_server.domain.restaurant;

import dittodining.api_server.domain.BaseTimeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.locationtech.jts.geom.Point;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED) @ToString(callSuper = true)
@Table(indexes = {
        @Index(name = "idx_restaurant_m1", columnList = "created_at"),
        @Index(name = "idx_restaurant_m2", columnList = "updated_at"),
        @Index(name = "idx_restaurant_m3", columnList = "latitude, longitude, recommendation_score"),
        @Index(name = "idx_restaurant_m4", columnList = "recommendation_score"),
})
public class Restaurant extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantId;

    @Size(max = 255)
    @NotNull
    @Comment(value = "restaurant ID")
    private String name;

    @Size(max = 1024)
    @NotNull
    @Comment(value = "restaurant address")
    private String address;

    @Lob
    @NotNull
    @Size(max = 65_535)
    @Comment(value = "restaurant explanation")
    private String description;

    @NotNull
    @Column(precision = 11, scale = 2)
    @Comment(value = "max price per person")
    private BigDecimal maximumPricePerPerson;

    @NotNull
    @Column(precision = 11, scale = 2)
    @Comment(value = "min price per person")
    private BigDecimal minimumPricePerPerson;

    @NotNull
    @Column(precision = 11, scale = 8)
    @Comment(value = "위도")
    private BigDecimal latitude;

    @NotNull
    @Column(precision = 11, scale = 8)
    @Comment(value = "경도")
    private BigDecimal longitude;
    // 곧 이걸로 리팩토링 예정
    @Column(columnDefinition = "POINT SRID 4326") @Comment(value = "latitude + longitude")
    private Point location;

    @NotNull
    @Column(name = "business_hours_json", columnDefinition = "JSON")
    @Comment(value = "business hour list Json")
    @Convert(converter = BusinessHourConverter.class)
    private List<BusinessHour> businessHours;

    @NotNull
    @Column(precision = 5, scale = 2)
    @Comment(value = "recommendation score")
    private BigDecimal recommendationScore;

    @Column(name = "average_score_from_naver", precision = 5, scale = 2)
    @Comment(value = "average score from naver")
    private BigDecimal naverAvgScore;

    @NotNull
    @Column(name = "total_review_count_from_naver", precision = 5, scale = 2)
    @Comment(value = "total review count from Naver")
    private Long naverTotalReviewCount;

    @Column(name = "average_score_from_kakao", precision = 5, scale = 2)
    @Comment(value = "average score from kakao")
    private BigDecimal kakaoAvgScore;

    @NotNull
    @Column(name = "total_review_count_from_kakao", precision = 5, scale = 2)
    @Comment(value = "total review count from kakao")
    private Long kakaoTotalReviewCount;

    @NotNull
    @Comment(value = "total review count")
    private Long totalReviewCount;

    @Builder
    public Restaurant(
            String name,
            String address,
            String description,
            BigDecimal maximumPricePerPerson,
            BigDecimal minimumPricePerPerson,
            BigDecimal latitude,
            BigDecimal longitude,
//            Point location,
            List<BusinessHour> businessHours,
            BigDecimal recommendationScore,
            BigDecimal naverAvgScore,
            Long naverTotalReviewCount,
            BigDecimal kakaoAvgScore,
            Long kakaoTotalReviewCount,
            Long totalReviewCount
    ) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.maximumPricePerPerson = maximumPricePerPerson;
        this.minimumPricePerPerson = minimumPricePerPerson;
        this.latitude = latitude;
        this.longitude = longitude;
//        this.location = location;
        this.businessHours = businessHours;
        this.recommendationScore = recommendationScore;
        this.naverAvgScore = naverAvgScore;
        this.naverTotalReviewCount = naverTotalReviewCount;
        this.kakaoAvgScore = kakaoAvgScore;
        this.kakaoTotalReviewCount = kakaoTotalReviewCount;
        this.totalReviewCount = totalReviewCount;
    }
}
