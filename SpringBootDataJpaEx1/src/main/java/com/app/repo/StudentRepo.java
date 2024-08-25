package com.app.repo;

import org.springframework.data.repository.CrudRepository;

import com.app.entity.Student;

public interface StudentRepo extends CrudRepository<Student, Integer> {

}
