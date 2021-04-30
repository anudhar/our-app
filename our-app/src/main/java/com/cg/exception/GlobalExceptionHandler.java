package com.cg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleUserNotFoundException(UserNotFoundException ex){
		
		ExceptionResponse er = new ExceptionResponse();
		er.setErroeCode(HttpStatus.NOT_FOUND.value());
		er.setErrorMessage(ex.getMessage());
		return new ResponseEntity<>(er,HttpStatus.OK);
	}
	
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<ExceptionResponse> handleUserAlreadyExistsException(UserAlreadyExistsException ex){
		
		ExceptionResponse er = new ExceptionResponse();
		er.setErroeCode(HttpStatus.NOT_FOUND.value());
		er.setErrorMessage(ex.getMessage());
		return new ResponseEntity<>(er,HttpStatus.OK);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex){
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	
}
