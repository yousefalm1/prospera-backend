package com.example.security.properties.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PropertyRequest {
    private String name;
    private String location;
    private String description;
    private Integer totalShares;
    private Integer value;
    private Integer rentalIncome;

}
