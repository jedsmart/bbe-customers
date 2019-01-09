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
import org.springframework.web.bind.annotation.RestController;

import com.jedsmart.bbe.customers.dto.CustomerDTO;
import com.jedsmart.bbe.customers.model.Customer;
import com.jedsmart.bbe.customers.service.CustomerService;

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

	@GetMapping("/{id}")
	public CustomerDTO getById(@PathVariable(name = "id", required = true) Long id) {
		return customerService.convertToDTO(customerService.getById(id));
	}

	@PostMapping
	public CustomerDTO save(@RequestBody Customer customer) {
		return customerService.convertToDTO(customerService.save(customer));
	}

	@PutMapping("/{id}")
	public CustomerDTO update(@PathVariable(name = "id", required = true) Long id, @RequestBody Customer customer) {
		return customerService.convertToDTO(customerService.update(id, customer));
	}

}
