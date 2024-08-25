package com.app.service;

import java.util.List;

import com.app.entity.Student;
import com.app.exception.StudentNotFoundException;


public interface IStudentService {
	
	public List<Student> getAllStudentDetails();
	
	public Student createStudent(Student stud);
	
	public void updateStudent(Student stu);
	
	public void deleteStudentDetails(Integer Id) throws StudentNotFoundException;
	
	public Student getStudentDetail(Integer Id) throws StudentNotFoundException;

}
