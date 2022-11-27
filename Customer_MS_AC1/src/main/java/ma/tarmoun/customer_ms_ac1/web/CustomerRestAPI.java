package ma.tarmoun.customer_ms_ac1.web;

import ma.tarmoun.customer_ms_ac1.dto.CustomerRequestDto;
import ma.tarmoun.customer_ms_ac1.dto.CustomerResponseDto;
import ma.tarmoun.customer_ms_ac1.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class CustomerRestAPI {
    private CustomerService customerService ;

    public CustomerRestAPI(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/customers")
    public List<CustomerResponseDto> allCustomers(){

        return  customerService.listCustomers() ;

    }
    @PostMapping(path = "/customers")
    public CustomerResponseDto save(@RequestBody CustomerRequestDto customerRequestDto){
        customerRequestDto.setId(UUID.randomUUID().toString());
        return customerService.save(customerRequestDto);
    }
    @GetMapping(path = "/customers/{id}")
    public CustomerResponseDto getCustomer(@PathVariable  String id){

        return customerService.getCustomer(id) ;
    }
}
