package com.learningportal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public  ResponseEntity<ErrorResponse> NoElementfound(UserNotFoundException ex) {
		
		  ErrorResponse errorResponse = new ErrorResponse(
		            HttpStatus.NOT_FOUND.value(),  // Status code (404) if want to add/remove any property then create or remove from class
		            ex.getMessage()                // Custom message from the exception
		        );
		
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
		
		
	}

}
