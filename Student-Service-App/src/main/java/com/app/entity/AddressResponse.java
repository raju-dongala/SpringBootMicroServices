package com.app.entity;

import lombok.Data;

@Data
public class AddressResponse {
	private Integer addressId;

	private String lane1;

	private String lane2;

	private String state;

	private Integer zipCode;
}
