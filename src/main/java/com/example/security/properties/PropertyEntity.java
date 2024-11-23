package com.example.security.properties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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

}