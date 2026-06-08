package com.ecommerce_app.services;

import com.ecommerce_app.dtos.api_response.ApiResponse;
import com.ecommerce_app.dtos.customers.CreateCustomerDto;
import com.ecommerce_app.dtos.customers.CustomerResponseDto;
import com.ecommerce_app.entities.CustomerEntity;
import com.ecommerce_app.exceptions.ResourceAlreadyExistsException;
import com.ecommerce_app.exceptions.ResourceNotFoundException;
import com.ecommerce_app.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
  private final CustomerRepository customerRepository;
  private final ModelMapper modelMapper;

  public CustomerResponseDto addCustomer (CreateCustomerDto createCustomerDto) {
      if(customerRepository.existsByEmail(createCustomerDto.getEmail())) {
          throw new ResourceAlreadyExistsException(
                  "Customer already exists with email: "
                          + createCustomerDto.getEmail()
          );
      }

      if(customerRepository.existsByPhone(createCustomerDto.getPhone())) {
          throw new ResourceAlreadyExistsException(
                  "Customer already exists with phone: "
                          + createCustomerDto.getPhone()
          );
      }

      CustomerEntity customer = modelMapper.map(createCustomerDto , CustomerEntity.class);
      customerRepository.save(customer);
      return modelMapper.map(customer , CustomerResponseDto.class);
  }

  public CustomerResponseDto getCustomerById (Long customerId) {
      CustomerEntity customer = customerRepository.findById(customerId).orElseThrow(() ->
              new ResourceNotFoundException("Customer not found"));

      return modelMapper.map(customer , CustomerResponseDto.class);

  }

  public List<CustomerResponseDto> getAllCustomers () {
      List<CustomerEntity> customers = customerRepository.findAll();
      return customers.stream().map(res -> modelMapper.map(res , CustomerResponseDto.class)).toList();
  }

}
