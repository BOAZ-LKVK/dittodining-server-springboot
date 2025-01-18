package dittodining.api_server.domain.recommendation.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckApi {
    @GetMapping("/health")
    public String hello() {
        return "Health Check OK";
    }
}
