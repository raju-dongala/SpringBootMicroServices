package com.app.service;

import java.util.Optional; 

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Student;
import com.app.excption.StudentNotFoundException;
import com.app.repo.StudentRepo;
import com.app.response.StudentResponse;

@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	StudentRepo stuRepo;
	
	@Autowired
	ModelMapper modelMap;

	@Override
	public StudentResponse getStudentResponseBasedOnId(Integer id) {
		Student orElseThrow = stuRepo.findById(id).orElseThrow(()->new StudentNotFoundException("Student Not Found in Database: "+id));
		StudentResponse studentMap = modelMap.map(orElseThrow, StudentResponse.class);
		return studentMap;
	}

	@Override
	public StudentResponse createStudent(Student stu) {
		Student save = stuRepo.save(stu);
		StudentResponse saveStu = modelMap.map(save, StudentResponse.class);
		return saveStu;
	}

	@Override
	public StudentResponse updateStudentDetails(Student stu) {
		Student orElseThrow = stuRepo.findById(stu.getStudId()).orElseThrow(()->new StudentNotFoundException("Student Not Found"));
		if(orElseThrow!=null) {
			Student save = stuRepo.save(stu);
			return modelMap.map(save, StudentResponse.class);
		}
		return null;		
	}

	@Override
	public void removeStudentById(Integer id) {
		Student orElseThrow = stuRepo.findById(id).orElseThrow(()->new StudentNotFoundException("Student Not Found in Database: "+id));
		stuRepo.deleteById(orElseThrow.getStudId());
	}
	
	

}
