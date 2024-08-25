package com.app.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomExceptionMessages {
	
	private String date;
	private String status;
	private int code;
	private String message;

}
