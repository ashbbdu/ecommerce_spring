package com.ecommerce_app.services;

import com.ecommerce_app.dtos.api_response.ApiResponse;
import com.ecommerce_app.dtos.customers.CreateCustomerDto;
import com.ecommerce_app.dtos.customers.CustomerResponseDto;
import com.ecommerce_app.entities.CustomerEntity;
import com.ecommerce_app.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
  private final CustomerRepository customerRepository;
  private final ModelMapper modelMapper;

  public CustomerResponseDto addCustomer (CreateCustomerDto createCustomerDto) {
      CustomerEntity customer = modelMapper.map(createCustomerDto , CustomerEntity.class);
      customerRepository.save(customer);
      return modelMapper.map(customer , CustomerResponseDto.class);
  }
}
