package com.example.billing_ms_ac2.service;

import com.example.billing_ms_ac2.dto.InvoiceRequestDto;
import com.example.billing_ms_ac2.dto.InvoiceRespoonseDto;

import java.util.List;

public interface InvoiceService {
     InvoiceRespoonseDto save(InvoiceRequestDto invoiceRequestDto);
     InvoiceRespoonseDto getInvoice(String invoiceId) ;
     List<InvoiceRespoonseDto> invoicesByCustomer(String customerId) ;
     List<InvoiceRespoonseDto> allInvoices() ;


}
