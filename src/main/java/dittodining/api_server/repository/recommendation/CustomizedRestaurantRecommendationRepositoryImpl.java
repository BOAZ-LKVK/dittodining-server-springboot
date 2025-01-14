package dittodining.api_server.repository.recommendation;

import com.querydsl.jpa.impl.JPAQueryFactory;
import dittodining.api_server.domain.recommendation.RestaurantRecommendation;
import jakarta.persistence.EntityManager;

import java.util.List;

import static dittodining.api_server.domain.recommendation.QRestaurantRecommendation.restaurantRecommendation;

public class CustomizedRestaurantRecommendationRepositoryImpl implements CustomizedRestaurantRecommendationRepository {

    private final JPAQueryFactory queryFactory;

    public CustomizedRestaurantRecommendationRepositoryImpl(EntityManager entityManager) {
        queryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public List<RestaurantRecommendation> findByRequestId(
            long requestId,
            Long cursorRecommendationId,
            Long limit
    ) {
        return queryFactory
                .selectFrom(restaurantRecommendation)
                .where(cursorRecommendationId != null ? restaurantRecommendation.id.gt(cursorRecommendationId) : null)
                .where(restaurantRecommendation.requestId.eq(requestId))
                .orderBy(restaurantRecommendation.id.asc())
                .limit(limit != null ? limit : 10)
                .fetch();
    }
}
