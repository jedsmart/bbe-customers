package com.jedsmart.bbe.customers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jedsmart.bbe.customers.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
