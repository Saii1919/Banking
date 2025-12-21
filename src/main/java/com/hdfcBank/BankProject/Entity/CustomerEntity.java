package com.hdfcBank.BankProject.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CUSTOMER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(strategy = "native",name="native")
    @Column(name = "CUSTOMER_ID")
   private Long CustomerId;

    @Column(name = "NAME")
    private String name;

     @Column(name = "MOBILE_NUMBER")
    private String mobileNumber;

    @Column(name = "Email")
    private String email;


}
