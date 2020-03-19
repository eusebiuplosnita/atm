package com.interview.ing.atm.machine.exceptions;

public class NotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9081527779478936311L;
	
	public NotFoundException(String message) {
		super(message);
	}
	
	public NotFoundException(String message, Throwable ex) {
		super(message, ex);
	}
}
