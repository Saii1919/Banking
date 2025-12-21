package com.hdfcBank.BankProject.Service.Impl;


import com.hdfcBank.BankProject.Constants.AccountConstants;
import com.hdfcBank.BankProject.DTO.AccountsDto;
import com.hdfcBank.BankProject.DTO.CustomerDto;
import com.hdfcBank.BankProject.Entity.AccountsEntity;
import com.hdfcBank.BankProject.Entity.CustomerEntity;
import com.hdfcBank.BankProject.Exceptions.CustomerAlreadyExistException;
import com.hdfcBank.BankProject.Exceptions.ResourceNotfoundException;
import com.hdfcBank.BankProject.Mapper.AccountMapper;
import com.hdfcBank.BankProject.Mapper.CustomerMapper;
import com.hdfcBank.BankProject.Repository.AccountsRepository;
import com.hdfcBank.BankProject.Repository.CustomerRepository;
import com.hdfcBank.BankProject.Service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service

public class AccountServiceImpl implements IAccountService {

    private final AccountsRepository accountsRepository;
    private final CustomerRepository customerRepository;


    @Autowired
    public AccountServiceImpl(AccountsRepository accountsRepository, CustomerRepository customerRepository ) {
        this.accountsRepository = accountsRepository;
        this.customerRepository = customerRepository;

    }

    @Override
    public void createAccount(CustomerDto customerDto) {

        Optional<CustomerEntity> presentCust= customerRepository.findBymobileNumber(customerDto.getMobileNumber());
        if(presentCust.isPresent()){
            throw new CustomerAlreadyExistException("The customer is already exist "+customerDto.getMobileNumber());
        }
        CustomerEntity cust= customerRepository.save(CustomerMapper.mapFromDto(customerDto,new CustomerEntity()));

        accountsRepository.save(createAccount(cust));
    }

    @Override
    public CustomerDto fetchAccountDetails(String mobileNumber) {
       CustomerEntity cust=customerRepository.findBymobileNumber(mobileNumber).orElseThrow(()-> new ResourceNotfoundException("This user not found",mobileNumber));
         AccountsEntity acc=accountsRepository.findByCustomerId(cust.getCustomerId()).orElseThrow(()-> new ResourceNotfoundException("This Account not found",mobileNumber));
        CustomerDto custdto= CustomerMapper.mapToDto(new CustomerDto(),cust);
        custdto.setAccountsDto(AccountMapper.mapToDto(acc,new AccountsDto()));

        return custdto;
    }

    @Override
    public boolean updateCustomerDetails(CustomerDto customerDto) {
           boolean isUpdated=false;
          if(customerDto!=null) {
              AccountsDto account=customerDto.getAccountsDto();
              if(account!=null){
                 AccountsEntity acconts=accountsRepository.findById(account.getAccountNUmber()).orElseThrow(()-> new ResourceNotfoundException("The user is not found ",account.getAccountNUmber().toString()));

               CustomerEntity cust=  customerRepository.findById(acconts.getCustomerId()).orElseThrow(()-> new ResourceNotfoundException("The user is not found ",acconts.getCustomerId().toString()));
                customerRepository.save(cust);
                isUpdated=true;
              }


          }

        return isUpdated;
    }

    @Override
    public boolean deleteAccount(String mobileNumber) {
        boolean deleted=false;
        if(mobileNumber!=null){
          CustomerEntity cust=  customerRepository.findBymobileNumber(mobileNumber).orElseThrow(()-> new ResourceNotfoundException("not available",mobileNumber));
          accountsRepository.deleteByCustomerId(cust.getCustomerId());
          customerRepository.deleteById(cust.getCustomerId());
          deleted=true;
        }
        return deleted;
    }


    private  AccountsEntity createAccount(CustomerEntity customer){

        AccountsEntity accounts = new AccountsEntity();
        accounts.setCustomerId(customer.getCustomerId());
        accounts.setBranchAddress(AccountConstants.BRANCH_ADDRESS);
        accounts.setAccountType(AccountConstants.ACCOUNT_SAVINGS);
        long randomAccNumber= 1000000000L+new Random().nextLong(9000000000l);
          accounts.setAccountNUmber(randomAccNumber);
          return accounts;
    }

}






