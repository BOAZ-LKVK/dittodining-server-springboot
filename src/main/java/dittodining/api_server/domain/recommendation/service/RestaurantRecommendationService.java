package dittodining.api_server.domain.recommendation.service;

import dittodining.api_server.domain.recommendation.entity.RestaurantRecommendation;
import dittodining.api_server.domain.recommendation.entity.RestaurantRecommendationRequest;
import dittodining.api_server.domain.recommendation.entity.UserLocation;
import dittodining.api_server.domain.recommendation.model.RequestRestaurantRecommendationResultModel;
import dittodining.api_server.domain.recommendation.repository.RestaurantRecommendationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class RestaurantRecommendationService {

    private final int minutesToFindNearbyRestaurants = 15;

    private final RestaurantRecommendationRequestRepository restaurantRecommendationRequestRepository;

    @Autowired
    public RestaurantRecommendationService(
            RestaurantRecommendationRequestRepository restaurantRecommendationRequestRepository
    ) {
        this.restaurantRecommendationRequestRepository = restaurantRecommendationRequestRepository;
    }

    @Transactional
    public RequestRestaurantRecommendationResultModel requestRestaurantRecommendation(
            Long userId,
            UserLocation userLocation,
            LocalDateTime now
    ){
        RestaurantRecommendationRequest restaurantRecommendationRequest = RestaurantRecommendationRequest.builder()
                .userId(userId)
                .userLocation(userLocation)
                .requestedAt(now)
                .build();
        try{
            restaurantRecommendationRequestRepository.save(restaurantRecommendationRequest);
        } catch (Exception e) {
            System.err.println("Error saving restaurant recommendation request" + e);
            throw new DataAccessResourceFailureException("Database error occurred while saving restaurant recommendation request", e);
        }
        RestaurantRecommendationRequest createdRestaurantRecommendationRequest = restaurantRecommendationRequestRepository
                .findById(restaurantRecommendationRequest.getRestaurantRecommendationRequestId())
                .orElseThrow(() -> new DataRetrievalFailureException("Restaurant recommendation request not found"));


        List<RestaurantRecommendation> restaurantRecommendations = createRecommendationList(
                userLocation,
                createdRestaurantRecommendationRequest.getRestaurantRecommendationRequestId(),
                minutesToFindNearbyRestaurants,
                null,
                null
        );

        return RequestRestaurantRecommendationResultModel.builder()
                .restaurantRecommendationRequestID(createdRestaurantRecommendationRequest.getRestaurantRecommendationRequestId())
                .isAvailableLocation(!restaurantRecommendations.isEmpty())
                .build();
    }

    public List<RestaurantRecommendation> createRecommendationList(
            UserLocation userLocation,
            long restaurantRecommendationRequestId,
            long minutes,
            Long cursorRecommendationScore,
            Long limit
    ){
        return List.of();
    }


}
