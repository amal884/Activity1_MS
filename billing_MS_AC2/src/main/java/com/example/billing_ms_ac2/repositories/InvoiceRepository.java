package com.example.billing_ms_ac2.repositories;

import com.example.billing_ms_ac2.entitiees.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice,String> {
    List<Invoice>  findByCustomerId(String clientId) ;
}
