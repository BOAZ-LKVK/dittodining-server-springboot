package dittodining.api_server.domain.restaurant.repository;

import com.querydsl.core.Tuple;
import dittodining.api_server.domain.recommendation.entity.UserLocation;

import java.util.List;

public interface CustomizedRestaurantRepository {
    List<Tuple> findNearbyAllOrderByRecommendationScoreDesc(
            UserLocation userLocation,
            long minute,
            Long cursorRecommendationScore,
            Long limit
    );
}
