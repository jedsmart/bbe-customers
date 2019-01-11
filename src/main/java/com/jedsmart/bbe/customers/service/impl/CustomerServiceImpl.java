package com.jedsmart.bbe.customers.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jedsmart.bbe.customers.domain.Customer;
import com.jedsmart.bbe.customers.domain.Customer.CustomerBuilder;
import com.jedsmart.bbe.customers.dto.CustomerDTO;
import com.jedsmart.bbe.customers.dto.CustomerDTO.CustomerDTOBuilder;
import com.jedsmart.bbe.customers.exception.ResourceNotFoundException;
import com.jedsmart.bbe.customers.repository.CustomerRepository;
import com.jedsmart.bbe.customers.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getAll() {
		return customerRepository.findAll();
	}

	@Override
	public List<Customer> search(String criteria) {
		return customerRepository.findAllByFirstNameOrLastName(criteria);
	}

	@Override
	public Customer getById(Long id) {
		return findCustomerById(id);
	}

	@Override
	public Customer save(Customer customer) {
		if (null == customer.getId()) {
			Date date = new Date();
			customer.setRegDate(date);
			customer.setModDate(date);
		}
		return customerRepository.save(customer);
	}

	@Override
	public Customer update(Long id, Customer customer) {
		Customer dbCustomer = findCustomerById(id);

		customer.setId(id);
		customer.setModDate(new Date());
		customer.setRegDate(dbCustomer.getRegDate());

		return save(customer);
	}

	@Override
	public void delete(Long id) {
		customerRepository.delete(findCustomerById(id));
	}

	private Customer findCustomerById(Long id) {
		if (null == id) {
			throw new ResourceNotFoundException("Bad request");
		}

		return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
	}

	@Override
	public CustomerDTO convertToDTO(Customer customer) {
		CustomerDTOBuilder builder = CustomerDTO.builder();
		builder.id(customer.getId());
		builder.firstName(customer.getFirstName());
		builder.lastName(customer.getLastName());
		return builder.build();
	}

	@Override
	public Customer convertToDomain(CustomerDTO customer) {
		CustomerBuilder builder = Customer.builder();
		builder.id(customer.getId());
		builder.firstName(customer.getFirstName());
		builder.lastName(customer.getLastName());
		return builder.build();
	}

}
