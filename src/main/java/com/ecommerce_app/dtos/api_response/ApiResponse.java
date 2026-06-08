package com.ecommerce_app.dtos.api_response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
//@RequiredArgsConstructor
@AllArgsConstructor
//@NoArgsConstructor
public class ApiResponse <T>{
      private boolean success;
      private String message;
      private T data;

}
