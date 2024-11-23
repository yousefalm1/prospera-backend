package com.example.security.properties.controller;

import com.example.security.properties.PropertyRepository;
import com.example.security.properties.bo.PropertyRequest;
import com.example.security.properties.bo.PropertyResponse;
import com.example.security.properties.service.PropertyService;
import org.hibernate.mapping.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    @Autowired
    private  PropertyService propertyService;

    private final PropertyRepository propertyRepository;
    public PropertyController(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @GetMapping("/view")
    public ResponseEntity<List<PropertyResponse>> getAllProperties() {
        return ResponseEntity.ok(propertyService.getAllProperties());
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<PropertyResponse> getPropertyById(@PathVariable Long id) {
        return ResponseEntity.ok(propertyService.getPropertyById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<PropertyResponse> addProperty(@RequestBody PropertyRequest propertyRequest) {
        return ResponseEntity.ok(propertyService.addProperty(propertyRequest));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PropertyResponse> updateProperty(@PathVariable Long id, @RequestBody PropertyRequest propertyRequest) {
        return ResponseEntity.ok(propertyService.updateProperty(id, propertyRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePropertyById(@PathVariable("id") Long id) {
        try {
            propertyService.deletePropertyById(id); // Call service to delete property
            return ResponseEntity.ok("Property has been successfully deleted.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
