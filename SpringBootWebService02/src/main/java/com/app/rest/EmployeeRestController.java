package com.app.rest;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Address;
import com.app.entity.Employee;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/v1/api/employee")
public class EmployeeRestController {
	
	@GetMapping("/details")
	public ResponseEntity<Employee> showData(){
		Employee e=new Employee(101,"Raju",43000.0,new Address("Rajahmundry"),List.of("C","Java","Spring"),Map.of("M1",10,"M2",20,"M3",30));
		return new ResponseEntity<Employee>(e,HttpStatus.OK);
	}
	
	@PostMapping("/data")
	public ResponseEntity<String> getResponse(@RequestBody Employee emp){
		String emp1 = emp.toString();
		return new ResponseEntity<String>(emp1,HttpStatus.OK);
	}
	
	@GetMapping("/request")
	public ResponseEntity<String> getDataByRequestParam(@RequestParam("empId") Integer empId){
		System.out.println(empId);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@GetMapping("/user/{empId}")
	public ResponseEntity<String> getDataByPathParam(@PathVariable("empId") Integer empId){
		//System.out.println(empId);
		return new ResponseEntity<String>("empId"+empId,HttpStatus.OK);
	}
	
	
}
