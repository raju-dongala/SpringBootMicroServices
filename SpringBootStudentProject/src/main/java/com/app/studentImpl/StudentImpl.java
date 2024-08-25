package com.app.studentImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Student;
import com.app.exception.StudentNotFoundException;
import com.app.repo.StudentRepo;
import com.app.service.IStudentService;

@Service
public class StudentImpl implements IStudentService{
	
	@Autowired
	private StudentRepo sturepo;

	@Override
	public List<Student> getAllStudentDetails() {
		List<Student> all = sturepo.findAll();
		return all;
	}

	

	@Override
	public void updateStudent(Student stu) {
		if(stu!=null)
		sturepo.save(stu);
	}

	@Override
	public void deleteStudentDetails(Integer Id) throws StudentNotFoundException {
		try {
			Student student = sturepo.findById(Id)
					.orElseThrow(() -> new StudentNotFoundException("Student Not Found with this '" + Id + "'"));
			sturepo.deleteById(student.getStudId());
		} catch (StudentNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		
			
	}

	@Override
	public Student getStudentDetail(Integer Id) throws StudentNotFoundException {
		Student student = sturepo.findById(Id)
				.orElseThrow(() -> new StudentNotFoundException("Student Not Found with this '" + Id + "'"));
		return student;
	}



	@Override
	public Student createStudent(Student stud) {
		if (stud != null) {
			Student save = sturepo.save(stud);
			return save;
		}
		return null;
	}

}
