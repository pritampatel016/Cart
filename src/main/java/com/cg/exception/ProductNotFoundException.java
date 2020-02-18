package com.cg.exception;

public class ProductNotFoundException extends Exception {

	public ProductNotFoundException(String message, Throwable cause) {
		super(message, cause);

	}

	public ProductNotFoundException(String message) {
		super(message);

	}

}
