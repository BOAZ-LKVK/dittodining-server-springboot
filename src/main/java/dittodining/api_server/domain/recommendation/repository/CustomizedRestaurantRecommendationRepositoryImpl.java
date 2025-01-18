package dittodining.api_server.domain.recommendation.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import dittodining.api_server.domain.recommendation.entity.RestaurantRecommendation;
import jakarta.persistence.EntityManager;

import java.util.List;

import static dittodining.api_server.domain.recommendation.entity.QRestaurantRecommendation.restaurantRecommendation;

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
                .where(cursorRecommendationId != null ? restaurantRecommendation.restaurantRecommendationId.gt(cursorRecommendationId) : null)
                .where(restaurantRecommendation.restaurantRecommendationRequestId.eq(requestId))
                .orderBy(restaurantRecommendation.restaurantRecommendationId.asc())
                .limit(limit != null ? limit : 10)
                .fetch();
    }
}
