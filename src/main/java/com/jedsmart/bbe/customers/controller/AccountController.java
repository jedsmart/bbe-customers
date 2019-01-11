package com.jedsmart.bbe.customers.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jedsmart.bbe.customers.domain.Account;
import com.jedsmart.bbe.customers.dto.AccountDTO;
import com.jedsmart.bbe.customers.service.AccountService;
import com.jedsmart.bbe.customers.vo.AccountType;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping
	public List<AccountDTO> getAll() {
		return accountService.getAll().stream().map(accountService::convertToDTO).collect(Collectors.toList());
	}

	@GetMapping("/by-customer/{id}")
	public List<AccountDTO> getAccountsByCustomer(@PathVariable(name = "id", required = true) Long customerId) {
		return accountService.getByCustomerId(customerId).stream().map(accountService::convertToDTO)
				.collect(Collectors.toList());
	}

	@GetMapping("/by-bank/{id}")
	public List<AccountDTO> getAccountsByBank(@PathVariable(name = "id", required = true) Long bankId) {
		return accountService.getByBankId(bankId).stream().map(accountService::convertToDTO)
				.collect(Collectors.toList());
	}

	@GetMapping("/by-type/{type}")
	public List<AccountDTO> getAccountsByType(@PathVariable(name = "type", required = true) AccountType type) {
		return accountService.getByType(type).stream().map(accountService::convertToDTO).collect(Collectors.toList());
	}

	@GetMapping("/by-number/{number}")
	public AccountDTO getByNumber(@PathVariable(name = "number", required = true) String number) {
		return accountService.convertToDTO(accountService.getByNumber(number));
	}

	@GetMapping("/{id}")
	public AccountDTO getById(@PathVariable(name = "id", required = true) Long id) {
		return accountService.convertToDTO(accountService.getById(id));
	}

	@PostMapping
	public AccountDTO save(@RequestBody(required = true) AccountDTO account) {
		Account a = accountService.convertToDomain(account);
		return accountService.convertToDTO(accountService.save(a));
	}

	@PutMapping("/{id}")
	public AccountDTO update(@PathVariable(name = "id", required = true) Long id,
			@RequestBody(required = true) AccountDTO account) {
		Account a = accountService.convertToDomain(account);
		return accountService.convertToDTO(accountService.update(id, a));
	}

}
