package com.example.billing_ms_ac2.service;

import com.example.billing_ms_ac2.dto.InvoiceRequestDto;
import com.example.billing_ms_ac2.dto.InvoiceRespoonseDto;
import com.example.billing_ms_ac2.entitiees.Customer;
import com.example.billing_ms_ac2.entitiees.Invoice;
import com.example.billing_ms_ac2.mapper.InvoiceMapper;
import com.example.billing_ms_ac2.openfeign.CustomerRestClient;
import com.example.billing_ms_ac2.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {
    private InvoiceRepository invoiceRepository ;
    private InvoiceMapper invoiceMapper ;
    private CustomerRestClient  customerRestClient;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper, CustomerRestClient customerRestClient) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
        this.customerRestClient = customerRestClient;
    }

    @Override
    public InvoiceRespoonseDto save(InvoiceRequestDto invoiceRequestDto) {
//         si les tables se trouvent dans le mm bdd sgbd  qui va faire sa
        Customer customer= new Customer();
        try{
             customer = customerRestClient.getCustomer(invoiceRequestDto.getCustomerId());
        } catch (Exception e){
             throw  e ;
        }

        Invoice invoice = invoiceMapper.fromInvoiceRequestDto(invoiceRequestDto);
        invoice.setId(UUID.randomUUID().toString());
        invoice.setDate(new Date());

        Invoice savedInvoice  =invoiceRepository.save(invoice);
        savedInvoice.setCustomer(customer);
        return invoiceMapper.fromInvoice(savedInvoice);
    }

    @Override
    public InvoiceRespoonseDto getInvoice(String invoiceId) {
        Invoice invoice = invoiceRepository.findById(invoiceId).get();
        Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
        invoice.setCustomer(customer);
        return invoiceMapper.fromInvoice(invoice);
    }

    @Override
    public List<InvoiceRespoonseDto> invoicesByCustomer(String customerId) {
        List<Invoice> invoices = invoiceRepository.findByCustomerId(customerId) ;
        for(Invoice invoice:invoices){
            Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
            invoice.setCustomer(customer);
        }
        return invoices.stream().map(invoice->invoiceMapper.fromInvoice(invoice)).collect(Collectors.toList());
    }

    @Override
    public List<InvoiceRespoonseDto> allInvoices() {
        List<Invoice> invoices = invoiceRepository.findAll();
       for(Invoice invoice:invoices){
           Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
           invoice.setCustomer(customer);
       }
        return invoices.stream().map(invoice -> invoiceMapper.fromInvoice(invoice)).collect(Collectors.toList());
    }
}
