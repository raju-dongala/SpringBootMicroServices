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
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.app.client.AddressFiegnClient;
import com.app.entity.AddressResponse;
import com.app.entity.Student;
import com.app.response.StudentResponse;
import com.app.service.StudentServiceImpl;

@RestController
@RequestMapping("/v1/api/student")
public class StudenRestController {

	@Autowired
	StudentServiceImpl studentImpl;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	WebClient webClient;

	@Autowired
	AddressFiegnClient addressFiegnClient;

	// Create student details
	@PostMapping("/create")
	public ResponseEntity<StudentResponse> createStudentDetails(@RequestBody Student stu) {
		StudentResponse student = studentImpl.createStudent(stu);
		ResponseEntity<StudentResponse> studentResponse = new ResponseEntity<StudentResponse>(student,
				HttpStatus.CREATED);
		return studentResponse;
	}

	// update student details
	@PutMapping("/update")
	public ResponseEntity<StudentResponse> updateStudentDetails(@RequestBody Student stu) {
		StudentResponse updateStudentDetails = studentImpl.updateStudentDetails(stu);
		ResponseEntity<StudentResponse> studentResponse = new ResponseEntity<StudentResponse>(updateStudentDetails,
				HttpStatus.OK);
		return studentResponse;
	}

	// Remove Student Details
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removingStudentBasedonId(@PathVariable Integer id) {
		studentImpl.removeStudentById(id);
		ResponseEntity<String> studentResponse = new ResponseEntity<String>("StudentRemoved Successfully",
				HttpStatus.OK);
		return studentResponse;
	}

	// get student details based on stuId
	
	/*@GetMapping("/getStudent/{id}")
	public ResponseEntity<StudentResponse> getStudentResponseRestTemplateBasedOnId(@PathVariable Integer id) {

		StudentResponse studentResponseBasedOnId = studentImpl.getStudentResponseBasedOnId(id);

		String baseAddressUrl = "http://localhost:8082/v1/api/address/get/{id}";

		AddressResponse addressResponse = restTemplate.getForObject(baseAddressUrl, AddressResponse.class, id);

		studentResponseBasedOnId.setAddressResponse(addressResponse);

		ResponseEntity<StudentResponse> studentResponse = new ResponseEntity<StudentResponse>(studentResponseBasedOnId,HttpStatus.OK);

		return studentResponse;
	}
	 

	// get student data using web client
	
	@GetMapping("/getStudent/{id}")
	public ResponseEntity<StudentResponse> getStudentResponseWebClientBasedOnId(@PathVariable Integer id) {

		StudentResponse studentResponseBasedOnId = studentImpl.getStudentResponseBasedOnId(id);

		// String baseAddressUrl="http://localhost:8082/v1/api/address/get/{id}";
		AddressResponse addressResponse = webClient.get().uri("/get/" + id).retrieve().bodyToMono(AddressResponse.class).block();
		studentResponseBasedOnId.setAddressResponse(addressResponse);

		ResponseEntity<StudentResponse> studentResponse = new ResponseEntity<StudentResponse>(studentResponseBasedOnId,
				HttpStatus.OK);

		return studentResponse;
	}*/
	 

	@GetMapping("/getStudent/{id}")
	public ResponseEntity<StudentResponse> getStudentResponseFiegnClientBasedOnId(@PathVariable Integer id) {

		StudentResponse studentResponseBasedOnId = studentImpl.getStudentResponseBasedOnId(id);

		// String baseAddressUrl="http://localhost:8082/v1/api/address/get/{id}";
		ResponseEntity<AddressResponse> addressResponse = addressFiegnClient.getAddressBasedOnId(id);

		studentResponseBasedOnId.setAddressResponse(addressResponse.getBody());

		ResponseEntity<StudentResponse> studentResponse = new ResponseEntity<StudentResponse>(studentResponseBasedOnId,
				HttpStatus.OK);

		return studentResponse;
	}

}
