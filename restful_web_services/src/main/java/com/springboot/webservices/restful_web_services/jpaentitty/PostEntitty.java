package com.springboot.webservices.restful_web_services.jpaentitty;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PostEntitty {

	@Id
	@GeneratedValue
	private Integer id;
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	private UserEntitty user;
	
	public UserEntitty getUserEntitty() {
		return user;
	}
	public void setUserEntitty(UserEntitty userEntitty) {
		this.user = userEntitty;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
