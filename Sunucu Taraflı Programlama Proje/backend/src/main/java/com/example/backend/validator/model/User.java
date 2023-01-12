package com.example.backend.validator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name = "ogrenci")
public class User {

	@Id
	@Column(name = "User_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "user_name", nullable = false, length = 30, unique = true)
	private String userName;

	@Column(name = "first_name", nullable = false, length = 30)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 30)
	private String lastName;

	@Column(name = "e_mail", nullable = false, length = 50, unique = true)
	private String eMail;

	@Column(name = "phone_number", nullable = false, length = 15, unique = true)
	private String  phoneNo;
	@Column(name = "ogr_no", nullable = false, length = 15, unique = true)
	private String ogrNo;


	public User(String userName, String firstName, String lastName,String eMail, String phoneNo, String ogrNo) {
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
		this.phoneNo = phoneNo;
		this.ogrNo = ogrNo;
	}
}
