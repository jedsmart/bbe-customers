package com.jedsmart.bbe.customers.service;

import java.util.List;

import com.jedsmart.bbe.customers.domain.Account;
import com.jedsmart.bbe.customers.dto.AccountDTO;
import com.jedsmart.bbe.customers.vo.AccountType;

public interface AccountService {

	public List<Account> getAll();

	public List<Account> getByCustomerId(Long customerId);

	public List<Account> getByBankId(Long bankId);

	public List<Account> getByType(AccountType type);

	public Account getById(Long id);

	public Account getByNumber(String number);

	public Account save(Account account);

	public Account update(Long id, Account account);

	public void delete(Long id);

	public AccountDTO convertToDTO(Account account);

	public Account convertToDomain(AccountDTO accountDTO);

}
