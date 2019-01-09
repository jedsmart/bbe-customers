package com.jedsmart.bbe.customers.service;

import java.util.List;

import com.jedsmart.bbe.customers.dto.AccountDTO;
import com.jedsmart.bbe.customers.model.Account;

public interface AccountService {

	public List<Account> getAll();

	public Account getById(Long id);

	public Account save(Account account);

	public Account update(Long id, Account account);

	public void delete(Long id);

	public AccountDTO convertToDTO(Account account);

}
