package com.jedsmart.bbe.customers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jedsmart.bbe.customers.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query("select c from Customer c where lower(concat(c.firstName, ' ', c.lastName)) like lower(concat('%', :criteria, '%'))")
	List<Customer> findAllByFirstNameOrLastName(String criteria);

}
