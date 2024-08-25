package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Employee")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class EmployeeEntity {
	
	@Id
	@Column(name = "empid")
	private Integer empId;
	
	@Column(name= "empname")
    private String empName;
	
	@Column(name="emprole")
	private String empRole;
	
}
