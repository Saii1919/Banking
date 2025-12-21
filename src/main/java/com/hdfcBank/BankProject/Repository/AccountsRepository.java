package com.hdfcBank.BankProject.Repository;

import com.hdfcBank.BankProject.Entity.AccountsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<AccountsEntity,Long> {
    Optional<AccountsEntity>  findByCustomerId( Long CustomerId);
    boolean  deleteByCustomerId(Long CustomerId);
}
