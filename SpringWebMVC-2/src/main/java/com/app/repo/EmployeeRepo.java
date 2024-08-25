package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.EmployeeEntity;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Integer> {

}
