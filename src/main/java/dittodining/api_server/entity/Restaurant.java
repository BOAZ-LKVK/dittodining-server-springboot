package dittodining.api_server.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Restaurant {

    @Id @GeneratedValue
    private Long id;
}
