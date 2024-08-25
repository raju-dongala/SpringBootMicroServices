package com.app.entity;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	private Integer empId;
	
	private String empName;
	
	private Double empSal;
	
	private Address addr;
	
	private List<String> projects;
	
	private Map<String, Integer> codes;
 
}
