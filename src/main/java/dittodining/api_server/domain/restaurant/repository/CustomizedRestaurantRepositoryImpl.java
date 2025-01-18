package dittodining.api_server.domain.restaurant.repository;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import dittodining.api_server.domain.recommendation.entity.UserLocation;
import jakarta.persistence.EntityManager;

import java.util.List;

import static dittodining.api_server.domain.restaurant.entity.QRestaurant.restaurant;

public class CustomizedRestaurantRepositoryImpl implements CustomizedRestaurantRepository {
    private final JPAQueryFactory queryFactory;

    public CustomizedRestaurantRepositoryImpl(EntityManager entityManager) {
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public List<Tuple> findNearbyAllOrderByRecommendationScoreDesc(
            UserLocation userLocation,
            long minute,
            Long cursorRecommendationScore,
            Long limit
    ) {
        // calculate movement radius
        long radius = 80 * minute;

        // distance calculate sql statement
        String distanceExpr = String.format("ST_Distance_Sphere(POINT(longitude, latitude), POINT(%s, %s))",
                userLocation.getLongitude().toString(), userLocation.getLatitude().toString());

        return queryFactory
                .select(restaurant,
                        Expressions.numberTemplate(Double.class, distanceExpr).as("distance"))
                .from(restaurant)
                .where(Expressions.numberTemplate(Double.class, distanceExpr).loe(radius))
                .where(cursorRecommendationScore != null ? restaurant.recommendationScore.lt(cursorRecommendationScore) : null)
                .orderBy(restaurant.recommendationScore.desc(), Expressions.numberTemplate(Double.class, distanceExpr).asc())
                .limit(limit != null ? limit : 10) // default is 10
                .fetch();
    }
}
