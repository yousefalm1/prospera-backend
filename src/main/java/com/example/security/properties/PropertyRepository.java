package com.example.security.properties;

import com.example.security.properties.entity.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyRepository extends JpaRepository<PropertyEntity, Long> {
    //List<PropertyEntity> findByPropertyId(Long propertyId);
}
