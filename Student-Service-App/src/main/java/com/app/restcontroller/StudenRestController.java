package com.app.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Student;
import com.app.response.StudentResponse;
import com.app.service.StudentServiceImpl;

@RestController
@RequestMapping("/v1/api/student")
public class StudenRestController {
	
	@Autowired
	StudentServiceImpl studentImpl;
	
	//Create student details
	@PostMapping("/create")
	public ResponseEntity<StudentResponse> createStudentDetails(@RequestBody Student stu) {
		StudentResponse student = studentImpl.createStudent(stu);
		ResponseEntity<StudentResponse> studentResponse=new ResponseEntity<StudentResponse>(student, HttpStatus.CREATED);
		return studentResponse;
	}
	
	// get student details based on stuId
	@GetMapping("/getStudent/{id}")
	public ResponseEntity<StudentResponse> getStudentResponseBasedOnId(@PathVariable Integer id) {
		StudentResponse studentResponseBasedOnId = studentImpl.getStudentResponseBasedOnId(id);
		ResponseEntity<StudentResponse> studentResponse=new ResponseEntity<StudentResponse>(studentResponseBasedOnId, HttpStatus.OK);
		return studentResponse;
	}
	
	// update student details
	
	@PutMapping("/update")
	public ResponseEntity<StudentResponse> updateStudentDetails(@RequestBody Student stu) {
		StudentResponse updateStudentDetails = studentImpl.updateStudentDetails(stu);
		ResponseEntity<StudentResponse> studentResponse=new ResponseEntity<StudentResponse>(updateStudentDetails, HttpStatus.OK);
		return studentResponse;
	}
	
	//Remove Student Details
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removingStudentBasedonId(@PathVariable Integer id) {
		studentImpl.removeStudentById(id);
		ResponseEntity<String> studentResponse=new ResponseEntity<String>("StudentRemoved Successfully", HttpStatus.OK);
		return studentResponse;
	}
	
}
