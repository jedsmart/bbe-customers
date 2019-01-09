package com.jedsmart.bbe.customers.service;

import java.util.List;

import com.jedsmart.bbe.customers.dto.CustomerDTO;
import com.jedsmart.bbe.customers.model.Customer;

public interface CustomerService {

	public List<Customer> getAll();

	public Customer getById(Long id);

	public Customer save(Customer customer);

	public Customer update(Long id, Customer customer);

	public void delete(Long id);

	public CustomerDTO convertToDTO(Customer customer);

}
