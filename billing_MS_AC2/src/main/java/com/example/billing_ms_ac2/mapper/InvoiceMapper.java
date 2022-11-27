package com.example.billing_ms_ac2.mapper;

import com.example.billing_ms_ac2.dto.InvoiceRequestDto;
import com.example.billing_ms_ac2.dto.InvoiceRespoonseDto;
import com.example.billing_ms_ac2.entitiees.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    Invoice fromInvoiceRequestDto(InvoiceRequestDto invoiceRequestDto);
    InvoiceRespoonseDto fromInvoice(Invoice invoice) ;
}
