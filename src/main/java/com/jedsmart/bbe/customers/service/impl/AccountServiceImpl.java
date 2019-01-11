package com.jedsmart.bbe.customers.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jedsmart.bbe.customers.domain.Account;
import com.jedsmart.bbe.customers.domain.Account.AccountBuilder;
import com.jedsmart.bbe.customers.dto.AccountDTO;
import com.jedsmart.bbe.customers.dto.AccountDTO.AccountDTOBuilder;
import com.jedsmart.bbe.customers.exception.ResourceNotFoundException;
import com.jedsmart.bbe.customers.repository.AccountRepository;
import com.jedsmart.bbe.customers.service.AccountService;
import com.jedsmart.bbe.customers.vo.AccountType;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public List<Account> getAll() {
		return accountRepository.findAll();
	}

	@Override
	public List<Account> getByCustomerId(Long customerId) {
		if (null == customerId) {
			throw new ResourceNotFoundException("Bad request");
		}

		return accountRepository.findAllByCustomerId(customerId);
	}

	@Override
	public List<Account> getByBankId(Long bankId) {
		if (null == bankId) {
			throw new ResourceNotFoundException("Bad request");
		}

		return accountRepository.findAllByBankId(bankId);
	}

	@Override
	public List<Account> getByType(AccountType type) {
		if (null == type) {
			throw new ResourceNotFoundException("Bad request");
		}

		return accountRepository.findAllByType(type);
	}

	@Override
	public Account getById(Long id) {
		return findAccountById(id);
	}

	@Override
	public Account getByNumber(String number) {
		return findAccountByNumber(number);
	}

	@Override
	public Account save(Account account) {
		if (null == account.getId()) {
			Date date = new Date();
			account.setRegDate(date);
			account.setModDate(date);
		}
		return accountRepository.save(account);
	}

	@Override
	public Account update(Long id, Account account) {
		Account dbAccount = findAccountById(id);

		account.setId(id);
		account.setModDate(new Date());
		account.setRegDate(dbAccount.getRegDate());

		return save(account);
	}

	@Override
	public void delete(Long id) {
		accountRepository.delete(findAccountById(id));
	}

	@Override
	public AccountDTO convertToDTO(Account account) {
		AccountDTOBuilder builder = AccountDTO.builder();
		builder.id(account.getId());
		builder.customerId(account.getCustomerId());
		builder.bankId(account.getBankId());
		builder.type(account.getType());
		builder.number(account.getNumber());
		builder.holderId(account.getHolderId());
		builder.holderName(account.getHolderName());
		builder.holderMail(account.getHolderMail());
		builder.holderPhone(account.getHolderPhone());
		return builder.build();
	}

	@Override
	public Account convertToDomain(AccountDTO accountDTO) {
		AccountBuilder builder = Account.builder();
		builder.id(accountDTO.getId());
		builder.customerId(accountDTO.getCustomerId());
		builder.bankId(accountDTO.getBankId());
		builder.type(accountDTO.getType());
		builder.number(accountDTO.getNumber());
		builder.holderId(accountDTO.getHolderId());
		builder.holderName(accountDTO.getHolderName());
		builder.holderMail(accountDTO.getHolderMail());
		builder.holderPhone(accountDTO.getHolderPhone());
		return builder.build();
	}

	private Account findAccountById(Long id) {
		if (null == id) {
			throw new ResourceNotFoundException("Bad request");
		}

		return accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account not found"));
	}

	private Account findAccountByNumber(String number) {
		if (StringUtils.isEmpty(StringUtils.trimToEmpty(number))) {
			throw new ResourceNotFoundException("Bad request");
		}

		return accountRepository.findByNumberContaining(number)
				.orElseThrow(() -> new ResourceNotFoundException("Account not found"));
	}

}
