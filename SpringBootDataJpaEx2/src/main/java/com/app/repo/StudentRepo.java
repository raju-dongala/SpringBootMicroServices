package com.app.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.entity.Student;

public interface StudentRepo extends PagingAndSortingRepository<Student, Integer>{

	

}
