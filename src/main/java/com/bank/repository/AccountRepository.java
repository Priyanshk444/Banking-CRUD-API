package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
