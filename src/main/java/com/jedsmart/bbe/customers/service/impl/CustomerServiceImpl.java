package com.jedsmart.bbe.customers.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jedsmart.bbe.customers.dto.CustomerDTO;
import com.jedsmart.bbe.customers.dto.CustomerDTO.CustomerDTOBuilder;
import com.jedsmart.bbe.customers.exception.CustomerNotFoundException;
import com.jedsmart.bbe.customers.model.Customer;
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
	public Customer getById(Long id) {
		return findCustomerById(id);
	}

	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer update(Long id, Customer customer) {
		if (null == id) {
			throw new CustomerNotFoundException("Bad request");
		} else if (!customerRepository.existsById(id)) {
			throw new CustomerNotFoundException();
		}

		return customerRepository.save(customer);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	private Customer findCustomerById(Long id) {
		return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException());
	}

	@Override
	public CustomerDTO convertToDTO(Customer customer) {
		CustomerDTOBuilder builder = CustomerDTO.builder();
		builder.id(customer.getId());
		builder.firstName(customer.getFirstName());
		builder.lastName(customer.getLastName());
		return builder.build();
	}

}
