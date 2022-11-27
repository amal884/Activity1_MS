package com.example.billing_ms_ac2.web;

import com.example.billing_ms_ac2.dto.InvoiceRequestDto;
import com.example.billing_ms_ac2.dto.InvoiceRespoonseDto;
import com.example.billing_ms_ac2.service.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class InvoiceRestController {
    private InvoiceService invoiceService ;

    public InvoiceRestController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping(path="/invoices/{id}")
    public InvoiceRespoonseDto getInvoice(@PathVariable(name="id") String invoiceId){
        return invoiceService.getInvoice(invoiceId);

    }
    @GetMapping(path="/invoicesByCustomer/{customerId}")
    public List<InvoiceRespoonseDto> getInvoicesByCustomer(@PathVariable String customerId){
        return invoiceService.invoicesByCustomer(customerId);
    }
    @PostMapping(path="/invoices")
    public InvoiceRespoonseDto save(@RequestBody InvoiceRequestDto invoiceRequestDto){
        return invoiceService.save(invoiceRequestDto);
    }
    @GetMapping(path="/invoices")
    public List<InvoiceRespoonseDto> allInvoices(){
        return invoiceService.allInvoices();
    }



}
