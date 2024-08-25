package com.app.service;

import com.app.entity.Student;
import com.app.response.StudentResponse;

public interface IStudentService {
	
	public StudentResponse getStudentResponseBasedOnId(Integer id);
	
	public StudentResponse createStudent(Student stu);
	
	public StudentResponse updateStudentDetails(Student stu);
	
	public void removeStudentById(Integer id);

}
