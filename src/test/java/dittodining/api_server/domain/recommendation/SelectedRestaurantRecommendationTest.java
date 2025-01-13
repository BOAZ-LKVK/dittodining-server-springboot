package dittodining.api_server.domain.recommendation;

import dittodining.api_server.repository.recommendation.SelectedRestaurantRecommendationRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class SelectedRestaurantRecommendationTest {
    @Autowired
    private SelectedRestaurantRecommendationRepository selectedRestaurantRecommendationRepository;

    @Autowired
    private EntityManager em;

    @Test
    public void getSelectedRestaurantRecommendation() {
        List<SelectedRestaurantRecommendation> res = em.createQuery(
                "SELECT srr FROM SelectedRestaurantRecommendation srr", SelectedRestaurantRecommendation.class
        ).getResultList();
        System.out.println(res.size());
        System.out.println(res.get(0));
    }

    @Test
    public void mockInsert() {
        SelectedRestaurantRecommendation selectedRestaurantRecommendation  = new SelectedRestaurantRecommendation(
                11L,
                91L,
                190L
        );

        selectedRestaurantRecommendationRepository.save(selectedRestaurantRecommendation);

        SelectedRestaurantRecommendation findSelectedRestaurantRecommendation = selectedRestaurantRecommendationRepository.findById(selectedRestaurantRecommendation.getId()).get();
        assertEquals(selectedRestaurantRecommendation, findSelectedRestaurantRecommendation);
        System.out.println(findSelectedRestaurantRecommendation);
    }
}