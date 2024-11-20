package com.example.security.transactions;


import com.example.security.investments.InvestmentEntity;
import com.example.security.properties.PropertyEntity;
import com.example.security.user.UserEntity;
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
@Table(name = "_transaction")
public class TransactionEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private PropertyEntity property;

    private Integer userId;
    private Integer propertyId;
    private String type;
    private Double amount;
    private Date date;
    private String details;
    private Date createdAt;
    private Date updatedAt;

}

