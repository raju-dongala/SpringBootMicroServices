package com.app.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionGlobalRest {
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<CustomExceptionMessages> showErrorMsg(StudentNotFoundException sne){
		return new ResponseEntity<CustomExceptionMessages>(
				 new CustomExceptionMessages(new Date().toString(),"Student Not Found",500,sne.getMessage()),
				 HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
