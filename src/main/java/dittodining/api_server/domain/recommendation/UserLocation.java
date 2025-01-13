package dittodining.api_server.domain.recommendation;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.math.BigDecimal;

@Embeddable
@NoArgsConstructor
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
