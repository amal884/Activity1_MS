package com.example.billing_ms_ac2.dto;

import com.example.billing_ms_ac2.entitiees.Customer;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
// requete
public class InvoiceRespoonseDto {
    private String id;

    private BigDecimal amount ;

    private Date date ;

    private Customer customer ;
}
