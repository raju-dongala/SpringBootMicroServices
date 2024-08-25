package com.app.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.exception.StudentNotFoundException;

@RestControllerAdvice
public class MyCustomExceptionHandler {
	

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<String> showStudentNotFoundException(StudentNotFoundException snfe){
		ResponseEntity<String> response= new ResponseEntity<String>(snfe.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		return response;
	}
	

}
