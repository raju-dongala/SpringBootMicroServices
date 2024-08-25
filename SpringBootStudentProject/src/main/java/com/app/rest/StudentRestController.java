package com.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Student;
import com.app.exception.StudentNotFoundException;
import com.app.service.IStudentService;

@RestController
@RequestMapping("/v1/api/student")
public class StudentRestController {
	
	@Autowired
	IStudentService iss;
	
	@GetMapping("/getDetails/{id}")
	public ResponseEntity<Student> showStudentDetail(@PathVariable("id") Integer id) throws StudentNotFoundException{
		Student studentDetail = iss.getStudentDetail(id);
		ResponseEntity<Student> reponse= ResponseEntity.ok(studentDetail);
		return reponse;
	}
	
	@PostMapping("/createDetails")
	public ResponseEntity<Student> createStudentDetail(@RequestBody Student stu) throws StudentNotFoundException{
		Student student = iss.createStudent(stu);
		ResponseEntity<Student> reponse= ResponseEntity.ok(student);
		return reponse;
	}
	
	@PutMapping("/updateDetails")
	public ResponseEntity<Student> updateStudentDetail(@RequestBody Student stu) throws StudentNotFoundException{
		ResponseEntity<Student> reponse=null;
		Student studentDetail = iss.getStudentDetail(stu.getStudId());
		if(studentDetail!=null) {
			iss.updateStudent(studentDetail);
			reponse=ResponseEntity.ok(studentDetail);
		}else {
			throw new StudentNotFoundException("Student Not Found : "+stu.getStudId());
		}
		return reponse;
	}

}
