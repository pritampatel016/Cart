package com.cg.exception;

public class CartIdNotFoundException extends Exception {

	public CartIdNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public CartIdNotFoundException(String message) {
		super(message);

	}

}
