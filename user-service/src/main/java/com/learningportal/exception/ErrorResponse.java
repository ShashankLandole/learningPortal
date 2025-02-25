package com.learningportal.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
	 private int statusCode;
	    private String message;
		
	    public ErrorResponse(String message) {
			super();
			this.message = message;
		}
	    
	    
}
