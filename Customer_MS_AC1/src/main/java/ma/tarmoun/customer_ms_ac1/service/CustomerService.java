package ma.tarmoun.customer_ms_ac1.service;


import ma.tarmoun.customer_ms_ac1.dto.CustomerRequestDto;
import ma.tarmoun.customer_ms_ac1.dto.CustomerResponseDto;

import java.util.List;

public interface CustomerService {

     CustomerResponseDto save(CustomerRequestDto customerRequestDto) ;
     CustomerResponseDto getCustomer(String id) ;
     CustomerResponseDto update(CustomerRequestDto customerRequestDto) ;
     List<CustomerResponseDto>  listCustomers() ;

}
