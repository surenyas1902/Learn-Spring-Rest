package com.surendiran.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

	// add exception handling code here
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex) {
		
		// create a StudentErrorResponse
		
		StudentErrorResponse errorResponse = new StudentErrorResponse();
		
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<StudentErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	// Add Another exception handler. like generic exception handler
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception ex) {
		StudentErrorResponse errorResponse = new StudentErrorResponse();
		
		errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<StudentErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
