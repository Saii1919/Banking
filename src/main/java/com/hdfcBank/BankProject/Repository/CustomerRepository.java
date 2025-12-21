package com.hdfcBank.BankProject.Repository;

import com.hdfcBank.BankProject.Entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {

Optional<CustomerEntity> findBymobileNumber(String Mobile);

}
