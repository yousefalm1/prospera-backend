package com.example.security.properties;

import jakarta.persistence.*;
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
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "totalShares", nullable = false)
    private Integer totalShares;

    @Column(name = "availableShares", nullable = false)
    private Integer availableShares;

    @Column(name = "value", nullable = false)
    private Integer value;

    @Column(name = "rentalIncome", nullable = false)
    private Integer rentalIncome;

    @Column(name = "createdAt", nullable = false)
    private Date createdAt;

    @Column(name = "updatedAt", nullable = false)
    private Date updatedAt;

}