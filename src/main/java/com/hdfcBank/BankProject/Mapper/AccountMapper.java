package com.hdfcBank.BankProject.Mapper;


import com.hdfcBank.BankProject.DTO.AccountsDto;
import com.hdfcBank.BankProject.Entity.AccountsEntity;




public class AccountMapper {

    public  static AccountsEntity mapFromDto(AccountsEntity accountsEntity,AccountsDto accountsDto){

        accountsEntity.setAccountNUmber(accountsDto.getAccountNUmber());
        accountsEntity.setAccountType(accountsDto.getAccountType());
        accountsEntity.setBranchAddress(accountsDto.getBranchAddress());
                return accountsEntity;
    }

    public  static AccountsDto mapToDto(AccountsEntity accountsEntity,AccountsDto accountsDto ){
        accountsDto.setAccountNUmber(accountsEntity.getAccountNUmber());
        accountsDto.setAccountType(accountsEntity.getAccountType());
        accountsDto.setBranchAddress(accountsEntity.getBranchAddress());

         return accountsDto;

    }
}
