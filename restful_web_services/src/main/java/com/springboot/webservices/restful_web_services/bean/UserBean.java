package com.springboot.webservices.restful_web_services.bean;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class UserBean {

	private Integer id;
	@Size(min = 2, message = "Name Should be 2 characters")
	private String name;
	@Past
	private Date dateOfBirth;

	public UserBean(Integer string, String string2, Date string3) {
		this.id = string;
		this.name = string2;
		this.dateOfBirth = string3;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
