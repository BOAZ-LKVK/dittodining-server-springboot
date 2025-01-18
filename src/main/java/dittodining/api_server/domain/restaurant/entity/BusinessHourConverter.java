package dittodining.api_server.domain.restaurant.entity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.io.IOException;
import java.util.List;

@Converter
public class BusinessHourConverter implements AttributeConverter<List<BusinessHour>, String> {
    private final ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);

    @Override
    public String convertToDatabaseColumn(List<BusinessHour> businessHours) {
        try {
            return objectMapper.writeValueAsString(businessHours);
        } catch (IOException e) {
            throw new IllegalArgumentException("Error converting list of BusinessHour to JSON string", e);
        }
    }

    @Override
    public List<BusinessHour> convertToEntityAttribute(String businessHoursJson) {
        try {
            return objectMapper.readValue(businessHoursJson, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new IllegalArgumentException("Error converting JSON string to list of BusinessHour", e);
        }
    }
}
