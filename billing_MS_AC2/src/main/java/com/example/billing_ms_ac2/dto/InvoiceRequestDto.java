package com.example.billing_ms_ac2.dto;

import com.example.billing_ms_ac2.entitiees.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
// requete
@Data
public class InvoiceRequestDto {

    private BigDecimal amount ;
    private String customerId ;
}
