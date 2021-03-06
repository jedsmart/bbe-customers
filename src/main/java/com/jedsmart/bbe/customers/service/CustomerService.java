package com.jedsmart.bbe.customers.service;

import java.util.List;

import com.jedsmart.bbe.customers.domain.Customer;
import com.jedsmart.bbe.customers.dto.CustomerDTO;

public interface CustomerService {

	public List<Customer> getAll();
	
	public List<Customer> search(String criteria);

	public Customer getById(Long id);

	public Customer save(Customer customer);

	public Customer update(Long id, Customer customer);

	public void delete(Long id);

	public CustomerDTO convertToDTO(Customer customer);

	public Customer convertToDomain(CustomerDTO customer);

}
