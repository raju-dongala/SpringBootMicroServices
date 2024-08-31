package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="address")
public class Address {

	@Id
	@Column(name="addressId")
	private Integer addressId;
	
	@Column(name="lane1")
	private String lane1;
	
	@Column(name="lane2")
	private String lane2;
	
	@Column(name="state")
	private String state;
	
	@Column(name="zipCode")
	private Integer zipCode;
}
