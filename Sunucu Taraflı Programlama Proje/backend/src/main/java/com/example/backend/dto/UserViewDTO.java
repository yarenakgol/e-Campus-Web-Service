package com.example.backend.dto;

import java.io.Serializable;

import com.example.backend.validator.model.User;
import lombok.Getter;

@Getter
public final class UserViewDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private final String userName;

	private final String firstName;

	private final String lastName;
	private final String eMail;
	private final String phoneNum;
	private final String ogrNo;

	private UserViewDTO(String userName, String firstName, String lastName,  String eMail, String phoneNum, String ogrNo) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
		this.phoneNum = phoneNum;
		this.ogrNo = ogrNo;
	}

	public static UserViewDTO of(User user) {
		return new UserViewDTO(user.getUserName(), user.getFirstName(), user.getLastName(),user.getEMail(),user.getPhoneNo(),user.getOgrNo());
	}

}
