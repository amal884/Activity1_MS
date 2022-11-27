package ma.tarmoun.customer_ms_ac1.service;

import ma.tarmoun.customer_ms_ac1.dto.CustomerRequestDto;
import ma.tarmoun.customer_ms_ac1.dto.CustomerResponseDto;
import ma.tarmoun.customer_ms_ac1.entities.Customer;
import ma.tarmoun.customer_ms_ac1.mappers.CustomerMapper;
import ma.tarmoun.customer_ms_ac1.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private CustomerMapper customerMapper ;

    private CustomerRepository customerRepository ;

    public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerResponseDto save(CustomerRequestDto customerRequestDto) {
        Customer customer = customerMapper.customerRequestDtoToCustomer(customerRequestDto);
        System.out.println(customer);
        Customer savedCustomer = customerRepository.save(customer) ;
        CustomerResponseDto customerResponseDto = customerMapper.customerToCustomerResponseDto(savedCustomer);
        return customerResponseDto;
    }

    @Override
    public CustomerResponseDto getCustomer(String id) {

        Customer customer = customerRepository.findById(id).get();
        return  customerMapper.customerToCustomerResponseDto(customer) ;
    }

    @Override
    public CustomerResponseDto update(CustomerRequestDto customerRequestDto) {
        Customer customer = customerMapper.customerRequestDtoToCustomer(customerRequestDto) ;
        Customer updatedCustomer= customerRepository.save(customer) ;
        return customerMapper.customerToCustomerResponseDto(updatedCustomer) ;
    }

    @Override
    public List<CustomerResponseDto> listCustomers() {

        List<Customer> customers = customerRepository.findAll();
        List<CustomerResponseDto> customerResponseDtos = customers.stream()
                .map(customer -> customerMapper.customerToCustomerResponseDto(customer)).collect(Collectors.toList());



        return customerResponseDtos;
    }
}
