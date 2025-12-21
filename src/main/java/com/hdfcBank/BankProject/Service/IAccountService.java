package com.hdfcBank.BankProject.Service;

import com.hdfcBank.BankProject.DTO.CustomerDto;

import java.util.List;

public interface IAccountService {

       void createAccount(CustomerDto customerDto);
      CustomerDto fetchAccountDetails(String mobileNUmber);


      boolean updateCustomerDetails(CustomerDto customerDto );

      boolean deleteAccount(String mobileNumber);
}
