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
@Table(name = "_property_value")
public class PropertyValueEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Integer value;
    private Date valueDate;

    @ManyToOne
    private PropertyEntity property;
}
