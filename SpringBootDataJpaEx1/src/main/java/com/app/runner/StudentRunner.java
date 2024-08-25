package com.app.runner;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.entity.Student;
import com.app.repo.StudentRepo;

@Component
public class StudentRunner implements CommandLineRunner {
	
	@Autowired
	StudentRepo stuRepo;

	@Override
	public void run(String... args) throws Exception {
		
		Student stu=new Student();
		stu.setSid(0001);
		stu.setSaddr("Nakkapali");
		stu.setSname("Rakesh");
		
		//stuRepo.save(stu);
		
		Student stu1=new Student();
		stu1.setSid(0013);
		stu1.setSaddr("Tuni");
		stu1.setSname("Ravanamma");
		
		Student stu2=new Student();
		stu2.setSid(0136);
		stu2.setSaddr("Namavaram");
		stu2.setSname("Pavan");
		
		//stuRepo.saveAll(Arrays.asList(stu,stu1,stu2));
		
		long count = stuRepo.count();
		System.out.println(count);
		
		Iterable<Student> all = stuRepo.findAll();
		System.out.println("================");
		all.forEach((u)->System.out.println(u));
		System.out.println("=================");
		
		
		Optional<Student> byId = stuRepo.findById(12);
		if(byId.isPresent()) {
			System.out.println(byId.get());
		}else {
			System.out.println("NOT FOUND");
		}
		
}

}
