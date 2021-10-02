package com.springboot.webservices.restful_web_services.bean;

/**
 * @author pradeep
 *
 */
public class PostBean {

	private Integer id;
	private String description;

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

	public PostBean(Integer id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

}
