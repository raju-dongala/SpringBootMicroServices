package com.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/student")
public class StudentController {
	
	//fetch student
	@GetMapping("/details")
	public ResponseEntity<String> fetchStudent(){
		ResponseEntity<String> re=new ResponseEntity<>("Student got fetched",HttpStatus.OK);
		return re;
	}
	
	//create student record
	@PostMapping("/create")
	public ResponseEntity<String> createStudent(){
		ResponseEntity<String> re=new ResponseEntity<>("Student got Created",HttpStatus.OK);
		return re;
	}
	
	//update student record
	@PutMapping("/update")
	public ResponseEntity<String> updateStudent(){
		ResponseEntity<String> re=new ResponseEntity<>("Student got Updated",HttpStatus.OK);
		return re;
	}
	
	//delete student record
	@DeleteMapping("/delete")
	public ResponseEntity<String> removeStudent(){
		ResponseEntity<String> re=new ResponseEntity<>("Student got removed",HttpStatus.OK);
		return re;
	}
	

}
