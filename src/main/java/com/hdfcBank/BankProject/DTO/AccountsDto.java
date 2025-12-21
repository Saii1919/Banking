package com.hdfcBank.BankProject.DTO;


import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
public class AccountsDto {

    @NotNull()
    private Long accountNUmber;
    private String accountType;
    private String branchAddress;
}
