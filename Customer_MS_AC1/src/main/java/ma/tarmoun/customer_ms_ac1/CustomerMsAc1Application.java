package ma.tarmoun.customer_ms_ac1;

import ma.tarmoun.customer_ms_ac1.dto.CustomerRequestDto;
import ma.tarmoun.customer_ms_ac1.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class CustomerMsAc1Application {

    public static void main(String[] args) {
        SpringApplication.run(CustomerMsAc1Application.class, args);
    }
   @Bean
    CommandLineRunner start(CustomerService customerService){


        return arrgs->{

            CustomerRequestDto customerRequestDto = new CustomerRequestDto();
             customerRequestDto.setId(UUID.randomUUID().toString());
            customerRequestDto.setName("amal");
            customerRequestDto.setEmail("amal@gmail.com");
            customerService.save(customerRequestDto) ;
            CustomerRequestDto customerRequestDto1 = new CustomerRequestDto();
            customerRequestDto1.setId(UUID.randomUUID().toString());
            customerRequestDto1.setName("ikram");
            customerRequestDto1.setEmail("ikram@gmail.com");
            customerService.save(customerRequestDto1) ;

        };
    }
}
