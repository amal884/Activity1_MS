package com.example.billing_ms_ac2.entitiees;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    @Id
    private String id;
    private Date date ;
    private BigDecimal amount ;
    private String customerId ;

    @Transient
    private Customer customer ;
}
