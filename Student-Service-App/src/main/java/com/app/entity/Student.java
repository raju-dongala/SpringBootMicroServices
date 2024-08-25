package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="studId")
	private Integer studId;
	
	@Column(name="studName")
	private String studName;
	
	@Column(name="emailId")
	private String emailId;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="bloodGrp")
	private String bloodGrp;

}
