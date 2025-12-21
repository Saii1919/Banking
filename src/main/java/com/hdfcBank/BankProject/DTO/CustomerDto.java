package com.hdfcBank.BankProject.DTO;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

@Data
public class CustomerDto {

    @NotEmpty(message = "name cannot be null")
    @Size(min = 5,max = 10)
    private String name;
    @Email(message = "Mail should be in the proper format")
    private String email;
    @NotNull (message = "Please make sure the Mobile number should not be null")
    private String mobileNumber;

    private AccountsDto accountsDto;

}
