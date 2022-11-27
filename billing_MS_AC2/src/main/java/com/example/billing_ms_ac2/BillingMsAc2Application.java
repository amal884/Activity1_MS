package com.example.billing_ms_ac2;

import com.example.billing_ms_ac2.dto.InvoiceRequestDto;
import com.example.billing_ms_ac2.service.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
@EnableFeignClients
public class BillingMsAc2Application {

    public static void main(String[] args) {
        SpringApplication.run(BillingMsAc2Application.class, args);
    }

    @Bean
    CommandLineRunner start(InvoiceService invoiceService){
        return args -> {
            invoiceService.save(new InvoiceRequestDto(BigDecimal.valueOf(90000),"49863e49-5d43-4fdf-b714-5c70284a6d7a"));





        };
    }

}
