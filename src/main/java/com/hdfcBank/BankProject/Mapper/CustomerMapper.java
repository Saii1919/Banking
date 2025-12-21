package com.hdfcBank.BankProject.Mapper;


import com.hdfcBank.BankProject.DTO.CustomerDto;
import com.hdfcBank.BankProject.Entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;



public class CustomerMapper {

    public static CustomerEntity mapFromDto(CustomerDto customerDto,CustomerEntity customerEntity){
        customerEntity.setEmail(customerDto.getEmail());
        customerEntity.setName(customerDto.getName());
        customerEntity.setMobileNumber(customerDto.getMobileNumber());

        return  customerEntity;
    }


    public static CustomerDto mapToDto(CustomerDto customerDto,CustomerEntity customerEntity){
         customerDto.setEmail(customerEntity.getEmail());
         customerDto.setName(customerEntity.getName());
         customerDto.setMobileNumber(customerEntity.getMobileNumber());
         return customerDto;
    }
}
