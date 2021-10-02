package com.springboot.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.webservices.restful_web_services.bean.Name;
import com.springboot.webservices.restful_web_services.bean.Person1;
import com.springboot.webservices.restful_web_services.bean.Person2;
import com.springboot.webservices.restful_web_services.bean.UserBean;

@RestController
public class VersioningController {

	@GetMapping("/v1/listofCustomersDetails")
	public Person1 getListOfCustomers1()
	{
		return new Person1("Pradeep");
	}
	
	@GetMapping("/v2/listofCustomersDetails")
	public Person2 getListOfCustomers2()
	{
		return new Person2(new Name("pradeep","kumar"));
	}
	
	@GetMapping(value = "/person/header" , headers  = "X-API-VERSION=1")
	public Person1 headers()
	{
		return new Person1("Pradeep");
	}
	@GetMapping(value = "/person/header" , headers = "X-API-VERSION=2")
	public Person2 headers1()
	{
		return new Person2(new Name("pradeep","kumar"));
	}
	
	@GetMapping(value = "/person/param" , params = "version=1")
	public Person1 param1()
	{
		return new Person1("Pradeep");
	}
	@GetMapping(value = "/person/param" , params = "version=2")
	public Person2 param2()
	{
		return new Person2(new Name("pradeep","kumar"));
	}
	
	@GetMapping(value = "/person/produces" ,produces = "application/vnd.company.app-v1+xml")
	public Person1 produces1()
	{
		return new Person1("Pradeep");
	}
	
	@GetMapping(value = "/person/produces" ,produces = "application/vnd.company.app-v2+xml")
	public Person2 produces2()
	{
		return new Person2(new Name("pradeep","kumar"));
	}
	
}
