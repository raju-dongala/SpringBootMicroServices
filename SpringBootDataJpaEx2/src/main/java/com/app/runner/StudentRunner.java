package com.app.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.app.entity.Student;
import com.app.repo.StudentRepo;

@Component
public class StudentRunner implements CommandLineRunner {
	
	@Autowired
	StudentRepo repo;
	

	public void run(String... args) throws Exception {
		Iterable<Student> iterable = repo.findAll(org.springframework.data.domain.Sort.by("sname"));
		iterable.forEach(System.out::println);
		
		PageRequest of = PageRequest.of(0, 4); 
		System.out.println("************************************");
		Page<Student> all = repo.findAll(of);
		all.forEach(System.out::println);
	}

}
