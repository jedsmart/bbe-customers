package com.jedsmart.bbe.customers.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jedsmart.bbe.customers.domain.Customer;
import com.jedsmart.bbe.customers.dto.CustomerDTO;
import com.jedsmart.bbe.customers.service.CustomerService;

import io.swagger.annotations.Api;

@Api("Manage customers")
@CrossOrigin
@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping
	public List<CustomerDTO> getAll() {
		return customerService.getAll().stream().map(customerService::convertToDTO).collect(Collectors.toList());
	}

	@GetMapping("/search")
	public List<CustomerDTO> search(@RequestParam(name = "criteria", required = true) String criteria) {
		List<Customer> customers = customerService.search(criteria);
		return customers.stream().map(customerService::convertToDTO).collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public CustomerDTO getById(@PathVariable(name = "id", required = true) Long id) {
		return customerService.convertToDTO(customerService.getById(id));
	}

	@PostMapping
	public CustomerDTO save(@RequestBody CustomerDTO customer) {
		Customer c = customerService.convertToDomain(customer);
		return customerService.convertToDTO(customerService.save(c));
	}

	@PutMapping("/{id}")
	public CustomerDTO update(@PathVariable(name = "id", required = true) Long id, @RequestBody CustomerDTO customer) {
		Customer c = customerService.convertToDomain(customer);
		return customerService.convertToDTO(customerService.update(id, c));
	}

}
