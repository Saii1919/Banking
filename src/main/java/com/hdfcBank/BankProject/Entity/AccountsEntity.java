package com.hdfcBank.BankProject.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "ACCOUNTS")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class AccountsEntity extends BaseEntity{


    @Column(name = "CUSTOMER_ID")
    @NotNull
    private Long customerId;

    @Id
    @Column(name = "ACCOUNT_NUMBER")
    private Long accountNUmber;

    @Column(name="ACCOUNT_TYPE")
    private String accountType;

    @Column(name="ACCOUNT_ADDRESS")
    private String branchAddress;

}
