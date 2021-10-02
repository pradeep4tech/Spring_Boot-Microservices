package com.springboot.webservices.restful_web_services.controller;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(value   = {"password","dateofbirth"})
@JsonFilter(value = "CustomerDataBeanFilter")
public class CustomerDataBean {

	private String name;
	//@JsonIgnore
	private String password;
	private String address;
	private String dateofbirth;

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public CustomerDataBean(String name, String password, String address) {
		super();
		this.name = name;
		this.password = password;
		this.address = address;
	}

}
