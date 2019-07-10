package com.codetest.exceptions;

public class InvalidNumberException extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;

	public InvalidNumberException(String exception) {
		super(exception);
	}

}
