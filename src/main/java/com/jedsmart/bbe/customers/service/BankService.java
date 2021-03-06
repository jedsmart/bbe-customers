package com.jedsmart.bbe.customers.service;

import java.util.List;

import com.jedsmart.bbe.customers.domain.Bank;
import com.jedsmart.bbe.customers.dto.BankDTO;

public interface BankService {

	public List<Bank> getAll();

	public Bank getById(Long id);

	public Bank save(Bank bank);

	public Bank update(Long id, Bank bank);

	public void delete(Long id);

	public BankDTO convertToDTO(Bank bank);

}
