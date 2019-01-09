package com.jedsmart.bbe.customers.exception;

public class CustomerNotFoundException extends RuntimeException {

	public CustomerNotFoundException(String message) {
		super(message);
	}

	public CustomerNotFoundException() {
		super("Customer not found");
	}

}
