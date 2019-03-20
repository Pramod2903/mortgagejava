package com.usecase.mortgage.exceptions;

public class InvalidPincodeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidPincodeException(){
		super();
	}
	
	public InvalidPincodeException(String message){
		super(message);
	}

}
