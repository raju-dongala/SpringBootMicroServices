package com.app.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.exception.StudentNotFoundException;

@RestController
@RequestMapping("/v1/api/student")
public class StudentRestController {
	
	@GetMapping("/show/{studId}")
	public ResponseEntity<String> showStudentDetails(@PathVariable("studId") Integer id) throws StudentNotFoundException{
		if(id==100) {
			//Student stu=new Student(100, "Raju", "Rajahmundry");
			return new ResponseEntity<String>("User Found",HttpStatus.OK);
		}else {
			throw new RuntimeException("Student Not Found");
		}
	}
	
	//Custom Exception handler in spring boot
	/*@GetMapping("/show/{studId}")
	public ResponseEntity<String> showStudentDetails(@PathVariable("studId") Integer id) {
		try {
			if(id==100) {
				//Student stu=new Student(100, "Raju", "Rajahmundry");
				return new ResponseEntity<String>("User Found",HttpStatus.OK);
			}else {
				throw new StudentNotFoundException("Student Not Found");
			}
		} catch (StudentNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		
	}*/
	
	
	

}
