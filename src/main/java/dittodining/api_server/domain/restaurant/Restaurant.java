package dittodining.api_server.domain.restaurant;

import dittodining.api_server.domain.BaseTimeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.locationtech.jts.geom.Point;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
public class Restaurant extends BaseTimeEntity {

    @Id @GeneratedValue
    @Column(name = "restaurant_id")
    private Long id;

    @Size(max = 255) @NotNull @Comment(value = "restaurant ID")
    private String name;

    @Size(max = 1024) @NotNull @Comment(value = "restaurant address")
    private String address;

    @Lob @Size(max = 65_535) @Comment(value = "restaurant explanation")
    private String description;

    @Column(precision = 11, scale = 2) @Comment(value = "max price per person")
    private BigDecimal maximumPricePerPerson;

    @Column(precision = 11, scale = 2) @Comment(value = "min price per person")
    private BigDecimal minimumPricePerPerson;

    @Column(columnDefinition = "POINT SRID 4326") @Comment(value = "latitude + longitude")
    private Point location;

    @Column(name = "business_hours_json", columnDefinition = "JSON")
    @JdbcTypeCode(SqlTypes.JSON_ARRAY) @Comment(value = "business hour list Json")
    private List<BusinessHour> businessHours;

    @Column(precision = 5, scale = 2) @Comment(value = "recommendation score")
    private BigDecimal recommendationScore;

    @Column(name = "average_score_from_naver", precision = 5, scale = 2) @Comment(value = "average score from naver")
    private BigDecimal naverAvgScore;

    @Column(name = "total_review_count_from_naver", precision = 5, scale = 2) @Comment(value = "total review count from Naver")
    private Long naverTotalReviewCount;

    @Column(name = "average_score_from_kakao", precision = 5, scale = 2) @Comment(value = "average score from kakao")
    private BigDecimal kakaoAvgScore;

    @Column(name = "total_review_count_from_kakao", precision = 5, scale = 2) @Comment(value = "total review count from kakao")
    private Long kakaoTotalReviewCount;

    @Comment(value = "total review count")
    private Long totalReviewCount;
}
