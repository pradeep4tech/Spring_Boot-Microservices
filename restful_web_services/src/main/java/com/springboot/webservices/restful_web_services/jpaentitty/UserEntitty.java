package com.springboot.webservices.restful_web_services.jpaentitty;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserEntitty {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private Date dateOfBirth;
	@OneToMany(mappedBy = "user")
	private List<PostEntitty> postEntitty;
	
	public UserEntitty() {
		
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public List<PostEntitty> getPostEntitty() {
		return postEntitty;
	}
	public void setPostEntitty(List<PostEntitty> postEntitty) {
		this.postEntitty = postEntitty;
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

	
}
