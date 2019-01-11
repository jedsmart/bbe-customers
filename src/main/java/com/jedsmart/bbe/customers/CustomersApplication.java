package com.jedsmart.bbe.customers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.jedsmart.bbe.customers.domain.Bank;
import com.jedsmart.bbe.customers.domain.Customer;
import com.jedsmart.bbe.customers.repository.BankRepository;
import com.jedsmart.bbe.customers.service.CustomerService;

@EnableDiscoveryClient
@SpringBootApplication
public class CustomersApplication implements ApplicationRunner {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private BankRepository bankRepository;

	public static void main(String[] args) {
		SpringApplication.run(CustomersApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		customerService.save(new Customer(1L, "Leonardo", "Fuenmayor", new Date(), new Date()));
		bankRepository.save(new Bank(1L, "0116", "BOD"));
	}

}
