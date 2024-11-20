package com.example.security.transactions;


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
@Table(name = "_transaction")
public class TransactionEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Integer userId;
    private Integer propertyId;
    private String type;
    private Double amount;
    private Date date;
    private String details;
    private Date createdAt;
    private Date updatedAt;


}

