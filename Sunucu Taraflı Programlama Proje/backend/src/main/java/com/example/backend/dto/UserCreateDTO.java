package com.example.backend.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.backend.validator.UniqueOgrNo;
import com.example.backend.validator.UniquePhoneNo;
import com.example.backend.validator.UniqueUserName;

import com.example.backend.validator.UniqueeMail;
import lombok.Data;

/**
 * 
 * @author KadirRA
 * @since 1.0
 */
@Data
public class UserCreateDTO {

	@NotNull(message = "{backend.constraints.username.NotNull.message}")
	@Size(min=1, max=30, message ="{backend.constraints.username.Size.message}")
	@UniqueUserName
	private String userName;

	@NotNull(message = "{backend.constraints.firstname.NotNull.message}")
	@Size(min = 1, max = 30, message = "{backend.constraints.firstname.Size.message}")
	private String firstName;

	@NotNull(message = "{backend.constraints.lastname.NotNull.message}")
	@Size(min = 1, max = 30, message = "{backend.constraints.lastname.Size.message}")
	private String lastName;

	@NotNull(message = "{backend.constraints.email.Size.message}")
	@Size(min=3, max=50, message ="{backend.constraints.email.NotNull.message}")
	@UniqueeMail
	private String eMail;

	@NotNull(message = "{backend.constraints.ogrNo.Size.message}")
	@Size(min=9, max=15, message ="{backend.constraints.ogrNo.NotNull.message}")
	@UniqueOgrNo
	private  String ogrNo;

	@NotNull(message = "{backend.constraints.phoneNum.Size.message}")
	@Size(min=10, max=15, message ="{backend.constraints.phoneNum.NotNull.message}")
	@UniquePhoneNo
	private  String  phoneNum;




}
