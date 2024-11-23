package com.example.security.properties.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_property")
public class PropertyEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String location;
    private String description;
    private Integer totalShares;
    private Integer availableShares;
    private Integer value;
    private Integer rentalIncome;
    private Date createdAt;
    private Date updatedAt;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PropertyValueEntity> propertyValues;

}