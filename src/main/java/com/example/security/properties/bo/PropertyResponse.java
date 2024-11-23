package com.example.security.properties.bo;

import com.example.security.properties.entity.PropertyEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PropertyResponse {
    private Long id;
    private String name;
    private String location;
    private String description;
    private Integer totalShares;
    private Integer availableShares;
    private Integer value;
    private Integer rentalIncome;
    private List<PropertyValueResponse> propertyValues;

    public PropertyResponse(PropertyEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.location = entity.getLocation();
        this.description = entity.getDescription();
        this.totalShares = entity.getTotalShares();
        this.availableShares = entity.getAvailableShares();
        this.value = entity.getValue();
        this.rentalIncome = entity.getRentalIncome();
        this.propertyValues = entity.getPropertyValues().stream()
                .map(PropertyValueResponse::new)
                .collect(Collectors.toList());
    }

}
