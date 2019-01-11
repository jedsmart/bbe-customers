package com.jedsmart.bbe.customers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jedsmart.bbe.customers.domain.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {

}
