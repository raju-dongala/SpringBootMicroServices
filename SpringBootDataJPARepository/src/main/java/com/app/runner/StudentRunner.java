package com.app.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import com.app.entity.Student;
import com.app.repo.StudentRepo;

@Component
public class StudentRunner implements CommandLineRunner {
	
	@Autowired
	StudentRepo repo;
	

	public void run(String... args) throws Exception {
		
		//Student stu=new Student(10,"Sandhya","Bendapudi");
		Student stu=new Student();
		stu.setSid(10);
		Example<Student> of = Example.of(stu);// Example object is used to search a particular records 
		
		List<Student> all = repo.findAll(of);
		all.forEach(System.out::println);
		//System.out.println(of.getMatcher().toString());
		
		Student bySid = repo.findBySid(1);
		System.out.println(bySid);
		
		Student bySnameAndSaddr = repo.findBySnameAndSaddr("Ravanamma", "Tuni");
		System.out.println(bySnameAndSaddr);
		
		List<Student> bySnameOrSaddr = repo.findBySnameOrSaddr("Rakesh", "Tuni");
		bySnameOrSaddr.forEach(System.out::println);
		
		List<Student> allDetails = repo.findAll();
		allDetails.forEach(System.out::println);
		
		List<String> nameOfStudent = repo.getNameOfStudent();
		
		nameOfStudent.forEach(System.out::println);

	}

}
