package dittodining.api_server.service.restaurant.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Getter
@Builder
@ToString
public class RestaurantReviewModel {
    private RestaurantReviewStatistics statistics;
    private List<RestaurantReviewItem> reviews;
    private Long totalCount;
}
