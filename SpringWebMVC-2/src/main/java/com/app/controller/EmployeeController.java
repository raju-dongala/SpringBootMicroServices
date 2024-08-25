package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.entity.EmployeeEntity;
import com.app.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/show")
	public String showEmployeeDetails(Model model) {
		List<EmployeeEntity> allEmployees = empService.getAllEmployees();
		model.addAttribute("show", allEmployees);
		return "Show";
	}
	
	@GetMapping("/display")
	public String displayForm(Model model) {
		EmployeeEntity emp=new EmployeeEntity();
		model.addAttribute("employee", emp);
		return "DisplayForm";
	}
	
	@PostMapping("/save")
	public String saveUser(Model model,@ModelAttribute EmployeeEntity emp) {
		
		EmployeeEntity saveEmployeeDetails = empService.saveEmployeeDetails(emp);
		model.addAttribute("details", saveEmployeeDetails);
		return "EmployeDetails";
	} 

}
