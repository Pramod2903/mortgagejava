package com.usecase.mortgage.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.usecase.mortgage.exceptions.ExceptionResponse;
import com.usecase.mortgage.exceptions.InvalidPincodeException;
import com.usecase.mortgage.exceptions.UserNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	  public final ResponseEntity<ExceptionResponse> handleUserNotFoundException
	  (UserNotFoundException ex, WebRequest request) {
		  
		ExceptionResponse errorDetails = new ExceptionResponse(new Date(), request.getDescription(false),ex.getMessage());
	    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	    
	  }
	
	@ExceptionHandler(InvalidPincodeException.class)
	  public final ResponseEntity<ExceptionResponse> handleUserNotFoundException
	  (InvalidPincodeException ex, WebRequest request) {
		  
		ExceptionResponse errorDetails = new ExceptionResponse(new Date(), request.getDescription(false),ex.getMessage());
	    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	    
	  }
}
