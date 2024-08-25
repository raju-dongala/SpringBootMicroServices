package com.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
	
	// findBy methods
	
	Student findBySid(Integer id);;
	
	Student findBySnameAndSaddr(String sname,String addr);
	
	List<Student> findBySnameOrSaddr(String sname,String addr);
	
	//Custom Queries
	
	@Query("select s.sname from Student s")
	List<String> getNameOfStudent();

}
