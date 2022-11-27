package ma.tarmoun.customer_ms_ac1.mappers;

import ma.tarmoun.customer_ms_ac1.dto.CustomerRequestDto;
import ma.tarmoun.customer_ms_ac1.dto.CustomerResponseDto;
import ma.tarmoun.customer_ms_ac1.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDto customerToCustomerResponseDto(Customer customer);
    Customer customerRequestDtoToCustomer(CustomerRequestDto customerRequestDto);
}
