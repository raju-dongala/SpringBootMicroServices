package com.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Student {
	@Id
	Integer sid;
	
	String sname;
	
	String saddr;

}
