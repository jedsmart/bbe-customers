package com.jedsmart.bbe.customers.exception;

public class RelationNotFoundException extends RuntimeException {

	public RelationNotFoundException() {
		super("Relation not found");
	}

	public RelationNotFoundException(String message) {
		super(message);
	}

}
