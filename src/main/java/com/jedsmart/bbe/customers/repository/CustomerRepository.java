package com.jedsmart.bbe.customers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jedsmart.bbe.customers.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
