package com.jedsmart.bbe.customers.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jedsmart.bbe.customers.domain.Account;
import com.jedsmart.bbe.customers.vo.AccountType;

public interface AccountRepository extends JpaRepository<Account, Long> {

	List<Account> findAllByCustomerId(Long customerId);

	List<Account> findAllByBankId(Long bankId);

	List<Account> findAllByType(AccountType type);

	Optional<Account> findByNumberContaining(String number);

}
