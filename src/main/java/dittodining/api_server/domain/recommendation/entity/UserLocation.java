package dittodining.api_server.domain.recommendation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.math.BigDecimal;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Builder
public class UserLocation {
    @NotNull
    @Column(precision = 11, scale = 8)
    @Comment(value = "유저 위도")
    private BigDecimal latitude;

    @NotNull
    @Column(precision = 11, scale = 8)
    @Comment(value = "유저 경도")
    private BigDecimal longitude;
}
