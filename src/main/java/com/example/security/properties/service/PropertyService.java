package com.example.security.properties.service;

import com.example.security.properties.bo.PropertyRequest;
import com.example.security.properties.bo.PropertyResponse;
import com.example.security.properties.entity.PropertyEntity;
import com.example.security.properties.PropertyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PropertyService {

    private final PropertyRepository propertyRepository;

    //get all properties
    public List<PropertyResponse> getAllProperties() {
        List<PropertyEntity> propertyEntities = propertyRepository.findAll();
        return propertyEntities.stream()
                .map(PropertyResponse::new)
                .collect(Collectors.toList());
    }

    //get property by id
    public PropertyResponse getPropertyById(Long id) {
        PropertyEntity propertyEntity = propertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property with ID " + id + " not found"));
        PropertyResponse response = new PropertyResponse(propertyEntity);
        return response;
    }


    //adding new property
    public PropertyResponse addProperty(PropertyRequest propertyRequest) {
        PropertyEntity propertyEntity = new PropertyEntity();

        propertyEntity.setName(propertyRequest.getName());
        propertyEntity.setLocation(propertyRequest.getLocation());
        propertyEntity.setDescription(propertyRequest.getDescription());
        propertyEntity.setTotalShares(propertyRequest.getTotalShares());
        propertyEntity.setAvailableShares(propertyRequest.getTotalShares()); // Initialize available shares
        propertyEntity.setValue(propertyRequest.getValue());
        propertyEntity.setRentalIncome(propertyRequest.getRentalIncome());
        propertyEntity.setCreatedAt(new Date());
        propertyEntity.setUpdatedAt(new Date());

        propertyEntity = propertyRepository.save(propertyEntity);
        return new PropertyResponse(propertyEntity);
    }

    //update a property
    public PropertyResponse updateProperty(Long id, PropertyRequest request) {
        PropertyEntity propertyEntity = propertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property with ID " + id + " not found"));

        if (request.getName() != null) propertyEntity.setName(request.getName());
        if (request.getLocation() != null) propertyEntity.setLocation(request.getLocation());
        if (request.getDescription() != null) propertyEntity.setDescription(request.getDescription());
        if (request.getTotalShares() != null) {
            propertyEntity.setTotalShares(request.getTotalShares());
            propertyEntity.setAvailableShares(request.getTotalShares()); // Reset shares if total is updated
        }
        if (request.getValue() != null) propertyEntity.setValue(request.getValue());
        if (request.getRentalIncome() != null) propertyEntity.setRentalIncome(request.getRentalIncome());
        propertyEntity.setUpdatedAt(new Date());

        propertyEntity = propertyRepository.save(propertyEntity);
        PropertyResponse updateResponse = new PropertyResponse(propertyEntity);
        return updateResponse;
    }

    public void deletePropertyById(Long id) {
        if (!propertyRepository.existsById(id)) {
            throw new RuntimeException("Property with ID " + id + " not found");
        }
        propertyRepository.deleteById(id);
    }

}

