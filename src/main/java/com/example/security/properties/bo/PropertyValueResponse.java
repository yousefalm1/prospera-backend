package com.example.security.properties.bo;

import java.util.Date;

import com.example.security.properties.entity.PropertyValueEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PropertyValueResponse {
    private Integer value;
    private Date date;

    public PropertyValueResponse(PropertyValueEntity propertyValueEntity) {
        this.value = propertyValueEntity.getValue();
        this.date = propertyValueEntity.getValueDate();
    }
}
