package com.portal.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {
	
	private String type;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String email;
	private String password;

}
