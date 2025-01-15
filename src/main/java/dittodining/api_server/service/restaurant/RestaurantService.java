package dittodining.api_server.service.restaurant;

import dittodining.api_server.domain.restaurant.Restaurant;
import dittodining.api_server.domain.restaurant.RestaurantImage;
import dittodining.api_server.repository.restaurant.RestaurantImageRepository;
import dittodining.api_server.repository.restaurant.RestaurantMenuRepository;
import dittodining.api_server.repository.restaurant.RestaurantRepository;
import dittodining.api_server.repository.restaurant.RestaurantReviewRepository;
import dittodining.api_server.service.restaurant.model.RestaurantModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

// 참고 https://homoefficio.github.io/2019/10/03/Java-Optional-%EB%B0%94%EB%A5%B4%EA%B2%8C-%EC%93%B0%EA%B8%B0/

@Service
@Transactional(readOnly = true)
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMenuRepository restaurantMenuRepository;
    private final RestaurantReviewRepository restaurantReviewRepository;
    private final RestaurantImageRepository restaurantImageRepository;

    // 이 과정을 RequiredArgsConstructor 로 한번에 해결가능 -> final 필드만 가진 녀석만 생성자를 만들어줌
    @Autowired
    public RestaurantService(
            RestaurantRepository restaurantRepository,
            RestaurantMenuRepository restaurantMenuRepository,
            RestaurantReviewRepository restaurantReviewRepository,
            RestaurantImageRepository restaurantImageRepository
    ){
        this.restaurantRepository = restaurantRepository;
        this.restaurantMenuRepository = restaurantMenuRepository;
        this.restaurantReviewRepository = restaurantReviewRepository;
        this.restaurantImageRepository = restaurantImageRepository;
    }

    public RestaurantModel getRestaurant(Long restaurantId) {
        Restaurant restaurant = restaurantRepository
                .findById(restaurantId)
                .orElseThrow(() -> new EntityNotFoundException("Restaurant not found"));

        // spring data jpa repo 의 메소드는 값이 없으면 비어있는 컬랙션을 반환해 준다.
        List<RestaurantImage> restaurantImages = restaurantImageRepository
                .findByRestaurantId(restaurantId);
        if (restaurantImages.isEmpty()) {
            throw new EntityNotFoundException("Restaurant Image not found");
        }

        List<String> restaurantImageURLs = new ArrayList<>(restaurantImages.size());
        for (RestaurantImage restaurantImage : restaurantImages) {
            restaurantImageURLs.add(restaurantImage.getImageUrl());
        }

        return new RestaurantModel(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getAddress(),
                restaurant.getDescription(),
                restaurant.getMaximumPricePerPerson(),
                restaurant.getMinimumPricePerPerson(),
                restaurant.getLongitude(),
                restaurant.getLatitude(),
                restaurant.getBusinessHours(),
                restaurantImageURLs
        );
    }
}
