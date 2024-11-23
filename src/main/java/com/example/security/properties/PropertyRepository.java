package com.example.security.properties;

import com.example.security.properties.entity.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PropertyRepository extends JpaRepository<PropertyEntity, Long> {
//    Optional<PropertyEntity> findById(Long id);
//
}
