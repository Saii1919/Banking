package com.hdfcBank.BankProject.RestController;


import com.hdfcBank.BankProject.Constants.AccountConstants;
import com.hdfcBank.BankProject.DTO.CustomerDto;
import com.hdfcBank.BankProject.DTO.ResponseDto;
import com.hdfcBank.BankProject.Service.IAccountService;
import com.hdfcBank.BankProject.bhaskarUserDetailsInfo;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api",produces = MediaType.APPLICATION_JSON_VALUE)

@Validated
public class AccountController {

   private final IAccountService iAccountService;

   @Autowired
   private bhaskarUserDetailsInfo bhaskarUserDetailsInfos;

   public AccountController(IAccountService iAccountService) {
      this.iAccountService = iAccountService;
   }

   @Value("${build.name}")
   private String NameOfDev;

   @PostMapping("/create")
   public ResponseEntity<ResponseDto>  createAccount(@Valid @RequestBody CustomerDto customerDto){
      iAccountService.createAccount(customerDto);
      return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(AccountConstants.STATUS_201,AccountConstants.MESSAGE_201));
   }

   @GetMapping("/fetch")
   public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam String mobileNumber){
      CustomerDto c=iAccountService.fetchAccountDetails(mobileNumber);
      return ResponseEntity.status(HttpStatus.OK).body(c);
   }



   public ResponseEntity<ResponseDto> updateAccountEntity(@Valid @RequestBody CustomerDto customerDto){
      boolean isUpdated = iAccountService.updateCustomerDetails(customerDto);
      if(isUpdated) {
         return ResponseEntity
                 .status(HttpStatus.OK)
                 .body(new ResponseDto(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200));
      }else{
         return ResponseEntity
                 .status(HttpStatus.EXPECTATION_FAILED)
                 .body(new ResponseDto(AccountConstants.STATUS_417, AccountConstants.MESSAGE_417_UPDATE));
      }
   }


   @DeleteMapping("/delete")
   public  ResponseEntity<ResponseDto> deleteAccount(@RequestParam String mobileNumber){
      boolean isDeleted = iAccountService.deleteAccount(mobileNumber);
      if(isDeleted){
         return ResponseEntity
                 .status(HttpStatus.OK)
                 .body(new ResponseDto(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200));
      }else{
         return ResponseEntity
                 .status(HttpStatus.EXPECTATION_FAILED)
                 .body(new ResponseDto(AccountConstants.STATUS_417, AccountConstants.MESSAGE_417_DELETE));
      }

      }

      @GetMapping("/fetch/developer")
      public ResponseEntity<String>  nameOfDeveloper(){
         return ResponseEntity.status(HttpStatus.OK).body(NameOfDev);
      }


      @GetMapping("/user-info")
      public ResponseEntity<bhaskarUserDetailsInfo> getUserDetails(){
         System.out.println("welcome to the file details");
         return ResponseEntity.status(HttpStatus.OK).body(bhaskarUserDetailsInfos) ;

      }

   }




