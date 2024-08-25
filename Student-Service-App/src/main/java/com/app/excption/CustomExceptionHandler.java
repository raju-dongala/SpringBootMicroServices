package com.app.excption;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<String> showCustomErrorMsg(StudentNotFoundException snfe){
		return new ResponseEntity<String>(snfe.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
