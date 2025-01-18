package dittodining.api_server.domain.restaurant.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Builder
@ToString
public class RestaurantReviewItem {
    private long restaurantReviewId;
    private String writerName;
    private BigDecimal score;
    private String content;
    private LocalDateTime wroteAt;
}
